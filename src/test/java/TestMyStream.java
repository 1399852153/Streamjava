import stream.Stream;
import stream.StreamGenerator;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class TestMyStream {

    public static void main(String[] args){
        Stream<Integer> intStream = StreamGenerator.getIntegerStream(10);

        intStream = intStream.filter(TestMyStream::idOdd);
//        intStream = intStream.map(TestMyStream::scaleTwo);
        intStream = intStream.map(TestMyStream::square);
        intStream = intStream.limit(3);

//        Integer sum = intStream.reduce(0,(v1,v2) -> v1 + v2);
//        System.out.println(sum);

        intStream.forEach(System.out::print);
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
