import stream.Stream;
import stream.StreamGenerator;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class TestMyStream {

    public static void main(String[] args){
        Stream<Integer> intStream = StreamGenerator.getIntegerStream(10);

//        intStream = intStream.filter(TestMyStream::idOdd);
//        intStream = intStream.map(TestMyStream::scaleTwo);
        intStream = intStream.map(TestMyStream::square);
//        intStream = intStream.limit(3);

//        int max = intStream.min(Integer::compareTo);
//
//        System.out.println(max);

        Integer sum = intStream.reduce(0,(v1,v2) -> v1 + v2);
        System.out.println(sum);

//        intStream.forEach(System.out::print);

//        Integer sum = intStream.collect(new Collector<Integer, Integer, Integer>() {
//            @Override
//            public Accumulate<Integer, Integer> accumulator() {
//                return (t1, t2) -> t1 + t2;
//            }
//
//            @Override
//            public Supplier<Integer> supplier() {
//                return () -> 10;
//            }
//
//            @Override
//            public Function<Integer, Integer> finisher() {
//                return integer -> integer;
//            }
//        });
//        System.out.println(sum);
//
//        intStream.forEach(System.out::print);
    }

    private static boolean idOdd(int num){
        return (num % 2 == 0);
    }

    private static Integer square(int num){
        return num * num;
    }

    private static Integer scaleTwo(int num){
        return num * 2;
    }

    private static String toStr(int num){
        return num + "";
    }
}
