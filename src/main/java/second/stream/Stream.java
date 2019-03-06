package second.stream;

import first.functional.Accumulate;
import first.functional.ForEach;
import first.functional.Map;
import first.functional.Predicate;
import second.functional.EvalFunction;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Stream <T> implements StreamInterface<T>{

    //===============================属性================================

    private T head;

    private Stream tail;

    private boolean isEnd;

    private Process process;

    //==============================构造方法===============================


    public Stream(T head, Process process) {
        this.head = head;
        this.process = process;
    }

    public Stream(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public Stream(Process process) {
        this.process = process;
    }

    //=================================API实现==============================

    @Override
    public <R> Stream<R> map(Map<R, T> mapper) {
        Process lastProcess = this.process;

        // 求值链条 加入一个新的process map
        return new Stream<>(new Process(lastProcess,()-> map(mapper,this)));
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate) {
        Process lastProcess = this.process;

        // 求值链条 加入一个新的process filter
        return new Stream<>(new Process(lastProcess,()-> filter(predicate,this)));
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
        return null;
    }

    //===============================私有方法====================================

    private <R> Stream<R> map(Map<R, T> mapper,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        // todo map实现
        return null;
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

        // todo reduce实现
        return null;
    }

    private static boolean isEmptyStream(Stream stream){
        return stream.isEnd;
    }
}
