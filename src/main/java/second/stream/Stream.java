package second.stream;

import first.functional.Accumulate;
import first.functional.ForEach;
import first.functional.Map;
import first.functional.Predicate;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Stream <T> implements StreamInterface<T> {

    //===============================属性================================

    private T head;

    private Stream<T> tail;

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

        public Builder<T> tail(Stream<T> tail){
            target.tail = tail;
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
    public <R> Stream<R> map(Map<R, T> mapper) {
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

        return this;
    }

    @Override
    public void forEach(ForEach<T> consumer) {
        forEach(consumer,this.eval());
    }

    @Override
    public <R> R reduce(R initVal, Accumulate<R, T> accumulator) {
        return reduce(initVal,accumulator,this.eval());
    }

    //===============================私有方法====================================

    private <R> Stream<R> map(Map<R, T> mapper,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        R head = mapper.apply(stream.head);

        return new Stream.Builder<R>()
                .head(head)
                .process(new Process(()->map(mapper,stream.eval())))
                .build();
    }

    private Stream<T> filter(Predicate<T> predicate,Stream<T> stream){
        if(isEmptyStream(stream)){
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

    private <R> R reduce(R initVal,Accumulate<R,T> accumulator,Stream<T> stream){
        if(isEmptyStream(stream)){
            return initVal;
        }

        T head = stream.head;
        R result = reduce(initVal,accumulator,stream.eval());

        // reduce实现
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
        if(isEmptyStream(stream)){
            return;
        }

        consumer.apply(stream.head);
        forEach(consumer,stream.eval());
    }

    private Stream<T> eval(){
        return this.process.eval();
    }

    private static boolean isEmptyStream(Stream stream){
        return stream.isEnd;
    }
}
