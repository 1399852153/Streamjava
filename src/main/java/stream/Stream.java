package stream;

import functional.Accumulate;
import functional.ForEach;
import functional.Map;
import functional.NextItem;
import functional.Predicate;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class Stream <T> implements StreamInterface<T>{

    //=====================================成员属性===============================

    private T head;

    private Stream<T> tail;

    private boolean isEnd;

    private NextItem<T> eval;

    //====================================构造函数===============================

    public Stream() {
    }

    public Stream(T head, Stream<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public Stream(NextItem<T> eval) {
        this.eval = eval;
    }

    public Stream(boolean isEnd) {
        this.isEnd = isEnd;
    }

    //=====================================公共接口=================================

    @Override
    public <R> Stream<R> map(Map<R,T> mapper){
        Stream<R> lazy = new Stream<>(
            () -> map(mapper,this)
        );

        return lazy;
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate){
        Stream<T> lazy = new Stream<>(
            () -> filter(predicate,this)
        );

        return lazy;
    }

    @Override
    public Stream<T> limit(int n) {
        return limit(n,this);
    }

    @Override
    public void forEach(ForEach<T> forEach){
    }

    @Override
    public <R> R reduce(R initVal,Accumulate<R,T> accumulator) {
        return reduce(initVal,accumulator,this.eval.apply());
    }

    //=====================================私有方法=====================================

    private <R> Stream<R> map(Map<R,T> mapper,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        R head = mapper.apply(stream.head);
        Stream<R> tail = new Stream<>(
            ()-> map(mapper,stream.force())
        );
        return new Stream<>(head, tail);
    }

    private Stream<T> filter(Predicate<T> predicate,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        if(predicate.isOK(stream.head)){
            Stream<T> ok = new Stream<>(head,filter(predicate,stream.force()));
            return ok;
        }else{
            Stream<T> not_ok =  filter(predicate,stream.force());
            return not_ok;
        }
    }

    private Stream<T> limit(int n, Stream<T> stream){
        if(n <= 0){
            return StreamInterface.makeEmptyStream();
        }

        T head = stream.head;

        Stream<T> tail = limit(n-1,stream.force());

        return new Stream<>(head,tail);
    }

    private <R> R reduce(R initVal,Accumulate<R,T> accumulator,Stream<T> stream){
        if(isEmptyStream(stream)){
            return initVal;
        }

        T head = stream.head;
        R tail = reduce(initVal,accumulator,stream.force());

        return accumulator.apply(tail,head);
    }

    private Stream<T> force(){
        Stream<T> eval = this.tail.eval.apply();
        return eval;
    }

    private static boolean isEmptyStream(Stream stream){
        return stream.isEnd;
    }
}
