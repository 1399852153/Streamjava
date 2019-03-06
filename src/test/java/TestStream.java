import stream.Stream;
import stream.StreamGenerator;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestStream {

    public static void main(String[] args){
        Stream<Integer> stream = StreamGenerator.getIntegerStream(10);

        stream = stream.filter(TestStream::idOdd);
        stream = stream.map(TestStream::square);

//        Stream<Integer> three = stream.limit(3);

        Integer sum = stream.reduce(0,(result,item)-> result + item);
        System.out.println(sum);
    }

    private static boolean idOdd(int num){
        return (num % 2 == 0);
    }

    private static Integer square(int num){
        return num * 3;
    }
}
