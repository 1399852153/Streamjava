//package first.stream;
//
//import first.functional.Accumulate;
//import first.functional.ForEach;
//import first.functional.Map;
//import first.functional.Predicate;
//
///**
// * @Author xiongyx
// * on 2019/3/5.
// */
//public class Stream <T> implements StreamInterface<T>{
//
//    //=====================================成员属性===============================
//
//    private T head;
//
//    private Stream<T> tail;
//
//    private boolean isEnd;
//
//    private NextItemChain processChain = new NextItemChain();
//
//    //====================================构造函数===============================
//
//    public Stream() {
//    }
//
//    public Stream(NextItemChain processChain) {
//        this.processChain = processChain;
//    }
//
//    public Stream(T head, Stream<T> tail) {
//        this.head = head;
//        this.tail = tail;
//    }
//
//
//    public Stream(boolean isEnd) {
//        this.isEnd = isEnd;
//    }
//
//    //=====================================公共接口=================================
//
//    @Override
//    public <R> Stream<R> map(Map<R,T> mapper){
//        this.processChain.addProcess(()-> map(mapper,this));
//
//        return new Stream<>(this.processChain);
//    }
//
//    @Override
//    public Stream<T> filter(Predicate<T> predicate){
//        this.processChain.addProcess(()-> filter(predicate,this));
//
//        return this;
//    }
//
//    @Override
//    public Stream<T> limit(int n) {
//        return limit(n,this);
//    }
//
//    @Override
//    public void forEach(ForEach<T> forEach){
//    }
//
//    @Override
//    public <R> R reduce(R initVal,Accumulate<R,T> accumulator) {
//        return reduce(initVal,accumulator,this);
//    }
//
//    //=====================================私有方法=====================================
//
//    private <R> Stream<R> map(Map<R,T> mapper,Stream<T> stream){
////        if(isEmptyStream(first.stream)){
////            return StreamInterface.makeEmptyStream();
////        }
////
////        R head = mapper.apply(first.stream.head);
////        Stream<R> tail = new Stream<>(
////            ()-> map(mapper,first.stream.force())
////        );
////        return new Stream<>(head, tail);
//
//        return null;
//    }
//
//    private Stream<T> filter(Predicate<T> predicate,Stream<T> stream){
//        if(isEmptyStream(stream)){
//            return StreamInterface.makeEmptyStream();
//        }
//
//        if(predicate.isOK(stream.head)){
//            Stream<T> ok = new Stream<>(head,filter(predicate,stream.force()));
//            return ok;
//        }else{
//            Stream<T> not_ok =  filter(predicate,stream.force());
//            return not_ok;
//        }
//    }
//
//    private Stream<T> limit(int n, Stream<T> stream){
//        if(n <= 0){
//            return StreamInterface.makeEmptyStream();
//        }
//
//        T head = stream.head;
//
//        Stream<T> tail = limit(n-1,stream.force());
//
//        return new Stream<>(head,tail);
//    }
//
//    private <R> R reduce(R initVal,Accumulate<R,T> accumulator,Stream<T> stream){
//        if(isEmptyStream(stream)){
//            return initVal;
//        }
//
//        T head = stream.head;
//        R tail = reduce(initVal,accumulator,stream.force());
//
//        return accumulator.apply(tail,head);
//    }
//
//    private Stream<T> force(){
//        Stream<T> eval = this.tail.processChain.eval(this);
//        return eval;
//    }
//
//    private static boolean isEmptyStream(Stream stream){
//        return stream.isEnd;
//    }
//}
