//package first.stream;
//
///**
// * @Author xiongyx
// * on 2019/3/5.
// */
//public class StreamGenerator {
//
//    public static Stream<Integer> getIntegerStream(int n){
//        if(n < 0){
//            return StreamInterface.makeEmptyStream();
//        }
//
//        Stream intStream = new Stream<>(
//                n,
//                new Stream(
//                        ()->getIntegerStream(n-1)
//                )
//        );
//
//
//        return intStream;
//    }
//}
