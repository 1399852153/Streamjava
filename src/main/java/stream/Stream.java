package stream;

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

    /**
     * 是否被求值过
     * */
    private boolean evaled;

    private NextItem<T> eval;

    public T getHead() {
        return head;
    }

    public void setHead(T head) {
        this.head = head;
    }

    public Stream<T> getTail() {
        return tail;
    }

    public void setTail(Stream<T> tail) {
        this.tail = tail;
    }

    public NextItem<T> getEval() {
        return eval;
    }

    public void setEval(NextItem<T> eval) {
        this.eval = eval;
    }

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
        return map(mapper,this);
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate){

        return new Stream<>();
    }

    @Override
    public void forEach(ForEach<T> forEach){
    }

    //=====================================私有方法=====================================

    private <R> Stream<R> map(Map<R,T> mapper,Stream<T> stream){
        if(isEmptyStream(stream)){
            return StreamInterface.makeEmptyStream();
        }

        R head = mapper.apply(stream.head);
        Stream tail = new Stream<>(
                ()-> map(mapper,stream.force()
                ));


        Stream newStream = new Stream(
                head,
                tail
        );
        return newStream;
    }

    private void delay(NextItem<T> nextItem){

    }

    private Stream force(){
        return this.tail.eval.apply();
    }

    private static boolean isEmptyStream(Stream stream){
        return stream.isEnd;
    }
}
