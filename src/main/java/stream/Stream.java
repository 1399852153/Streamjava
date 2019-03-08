package stream;

import function.*;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Stream <T> implements StreamInterface<T> {

    //===============================属性================================

    private T head;

    private boolean isEnd;

    private Process process;

    //==============================构造方法===============================

    public static class Builder<T>{
        private Stream<T> target;

        public Builder() {
            this.target = new Stream<>();
        }

        public Builder<T> head(T head){
            target.head = head;
            return this;
        }

        public Builder<T> isEnd(boolean isEnd){
            target.isEnd = isEnd;
            return this;
        }

        public Builder<T> process(Process process){
            target.process = process;
            return this;
        }

        public Stream<T> build(){
            return target;
        }
    }

    //=================================API实现==============================

    @Override
    public <R> Stream<R> map(Function<R, T> mapper) {
        Process lastProcess = this.process;
        this.process = new Process(
                ()->{
                    Stream stream = lastProcess.eval();
                    return map(mapper,stream);
                }
        );

        // 求值链条 加入一个新的process map
        return new Stream.Builder<R>()
                .process(this.process)
                .build();
    }

    @Override
    public <R> Stream<R> flatMap(Function<? extends Stream<? extends R>,? super T> mapper) {
        Process lastProcess = this.process;
        this.process = new Process(
            ()->{
                Stream stream = lastProcess.eval();
                return flatMap(mapper,stream);
            }
        );

        // 求值链条 加入一个新的process map
        return new Stream.Builder<R>()
            .process(this.process)
            .build();
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate) {
        Process lastProcess = this.process;
        this.process = new Process(
                ()-> {
                    Stream stream = lastProcess.eval();
                    return filter(predicate,stream);
                }
        );

        // 求值链条 加入一个新的process filter
        return this;
    }

    @Override
    public Stream<T> limit(int n) {
        Process lastProcess = this.process;
        this.process = new Process(
                ()-> {
                    Stream stream = lastProcess.eval();
                    return limit(n,stream);
                }
        );

        // 求值链条 加入一个新的process limit
        return this;
    }

    @Override
    public void forEach(ForEach<T> consumer) {
        // 终结操作 直接开始求值
        forEach(consumer,this.eval());
    }

    @Override
    public <R> R reduce(R initVal, BiFunction<R, R, T> accumulator) {
        // 终结操作 直接开始求值
        return reduce(initVal,accumulator,this.eval());
    }

    @Override
    public <R, A> R collect(Collector<T, A, R> collector) {
        // 终结操作 直接开始求值
        A result = collect(collector,this.eval());

        // 通过finish方法进行收尾
        return collector.finisher().apply(result);
    }

    @Override
    public T max(Comparator<T> comparator) {
        Stream<T> eval = this.eval();

        if(eval.isEmptyStream()){
            return null;
        }else{
            return max(comparator,eval,eval.head);
        }
    }

    @Override
    public T min(Comparator<T> comparator) {
        Stream<T> eval = this.eval();

        if(eval.isEmptyStream()){
            return null;
        }else{
            return min(comparator,eval,eval.head);
        }
    }

    //===============================私有方法====================================

    private <R> Stream<R> map(Function<R, T> mapper,Stream<T> stream){
        if(stream.isEmptyStream()){
            return StreamInterface.makeEmptyStream();
        }

        R head = mapper.apply(stream.head);

        return new Stream.Builder<R>()
                .head(head)
                .process(new Process(()->map(mapper,stream.eval())))
                .build();
    }

    private <R> Stream<R> flatMap(Function<? extends Stream<? extends R>,? super T> mapper,Stream<T> stream) {
        if(stream.isEmptyStream()){
            return StreamInterface.makeEmptyStream();
        }

        Stream head = mapper.apply(stream.head);

        return null;
    }

    private Stream<T> filter(Predicate<T> predicate,Stream<T> stream){
        if(stream.isEmptyStream()){
            return StreamInterface.makeEmptyStream();
        }

        if(predicate.isOK(stream.head)){
            Stream<T> ok = new Stream.Builder<T>()
                    .head(stream.head)
                    .process(new Process(()->filter(predicate,stream.eval())))
                    .build();
            return ok;
        }else{
            Stream<T> not_ok = filter(predicate,stream.eval());
            return not_ok;
        }
    }

    private <R> R reduce(R initVal, BiFunction<R,R,T> accumulator, Stream<T> stream){
        if(stream.isEmptyStream()){
            return initVal;
        }

        T head = stream.head;
        R result = reduce(initVal,accumulator,stream.eval());

        return accumulator.apply(result,head);
    }

    private Stream<T> limit(int num,Stream<T> stream){
        if(num == 0){
            return StreamInterface.makeEmptyStream();
        }

        return new Stream.Builder<T>()
                .head(stream.head)
                .process(new Process(()->limit(num-1,stream.eval())))
                .build();
    }

    private void forEach(ForEach<T> consumer,Stream<T> stream){
        if(stream.isEmptyStream()){
            return;
        }

        consumer.apply(stream.head);
        forEach(consumer,stream.eval());
    }

    private <R, A> A collect(Collector<T, A, R> collector,Stream<T> stream){
        if(stream.isEmptyStream()){
            return collector.supplier().get();
        }

        T head = stream.head;
        A tail = collect(collector,stream.eval());

        return collector.accumulator().apply(tail,head);
    }

    private T max(Comparator<T> comparator,Stream<T> stream,T max){
        if(stream.isEnd){
            return max;
        }

        T head = stream.head;
        // head 和 max 进行比较
        if(comparator.compare(head,max) > 0){
            // head 较大 作为新的max传入
            return max(comparator,stream.eval(),head);
        }else{
            // max 较大 不变
            return max(comparator,stream.eval(),max);
        }
    }

    private T min(Comparator<T> comparator,Stream<T> stream,T min){
        if(stream.isEnd){
            return min;
        }

        T head = stream.head;
        // head 和 min 进行比较
        if(comparator.compare(head,min) < 0){
            // head 较小 作为新的min传入
            return min(comparator,stream.eval(),head);
        }else{
            // min 较小 不变
            return min(comparator,stream.eval(),min);
        }
    }

    private Stream<T> append(Stream<T> stream1,Stream<T> stream2){
        if(stream1.isEmptyStream()){
            return stream2;
        }

        return new Stream.Builder<T>()
            .head(stream1.head)
            .process(new Process(()->append(stream1.eval(),stream2)))
            .build();
    }

//    private Stream<T> flatten(Stream<T> stream_in_stream){
////        return reduce(StreamInterface.makeEmptyStream(), new Accumulate<Stream<T>, T>() {
////            @Override
////            public Stream<T> apply(Stream<T> t1, T t2) {
////                return append(t1,t2);
////            }
////        });
//    }

    private Stream<T> eval(){
        return this.process.eval();
    }

    private boolean isEmptyStream(){
        return this.isEnd;
    }
}
