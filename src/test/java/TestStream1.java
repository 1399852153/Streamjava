//import first.stream.Stream;
//import first.stream.StreamGenerator;
//
///**
// * @Author xiongyx
// * on 2019/3/5.
// */
//public class TestStream1 {
//
//    public static void main(String[] args){
//        Stream<Integer> stream = StreamGenerator.getIntegerStream(10);
//
////        first.stream = first.stream.filter(TestStream1::idOdd);
//        Stream<String> strStream = stream.map(TestStream1::toStr);
//
////        Stream<Integer> three = first.stream.limit(3);
//
//        Integer sum = stream.reduce(0,(result,item)-> result + item);
//        System.out.println(sum);
//    }
//
//    private static boolean idOdd(int num){
//        return (num % 2 == 0);
//    }
//
//    private static Integer square(int num){
//        return num * 3;
//    }
//
//    private static String toStr(int num){
//        return num + "";
//    }
//}
