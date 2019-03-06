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

    private Process<T> process;

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

        // 求值链条 加入一个新的process map
        return new Stream.Builder<R>()
            .process(new Process(lastProcess,()-> map(mapper,this)))
            .build();
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate) {
        Process lastProcess = this.process;

        // 求值链条 加入一个新的process filter
        return new Stream.Builder<T>()
            .process(new Process(lastProcess,()-> filter(predicate,this)))
            .build();
    }

    @Override
    public Stream<T> limit(int n) {
        return null;
    }

    @Override
    public void forEach(ForEach<T> forEach) {

    }

    @Override
    public <R> R reduce(R initVal, Accumulate<R, T> accumulator) {
        return reduce(initVal,accumulator,this.eval());
    }

    //===============================私有方法====================================

    private Stream<T> eval(){
        return this.process.evalFunction.apply();
    }

    private <R> Stream<R> map(Map<R, T> mapper,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        R head = mapper.apply(stream.head);
        Stream<R> tail = map(mapper,stream.process.evalFunction.apply());

        // todo map实现
        return new Stream.Builder<R>()
            .head(head)
            .tail(tail)
            .build();
    }

    private Stream<T> filter(Predicate<T> predicate,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        // todo filter实现
        return null;
    }

    private <R> R reduce(R initVal,Accumulate<R,T> accumulator,Stream<T> stream){
        if(isEmptyStream(stream)){
            return initVal;
        }

        T head = stream.head;

//        Stream<T> tail = reduce(initVal,accumulator,stream.eval());



        // todo reduce实现
        return null;
    }

    private static boolean isEmptyStream(Stream stream){
        return stream.isEnd;
    }
}
