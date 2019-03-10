import stream.MyStream;
import stream.genetator.IntegerStreamGenerator;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class TestMyStream {

    public static void main(String[] args){
        MyStream<Integer> intMyStream = IntegerStreamGenerator.getIntegerStream(1,2);

//        intMyStream = intMyStream.filter(TestMyStream::idOdd);
//        intMyStream = intMyStream.map(TestMyStream::scaleTwo);
//        intMyStream = intMyStream.map(TestMyStream::square);
        intMyStream = intMyStream.limit(3);

//        int max = intMyStream.min(Integer::compareTo);
//
//        System.out.println(max);

//        Integer sum = intMyStream.reduce(0,(v1,v2) -> v1 + v2);
//        System.out.println(sum);

//        intMyStream.forEach(System.out::print);


        intMyStream.forEach(System.out::println);
    }

    private static boolean idOdd(int num){
        return (num % 2 != 0);
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
