import stream.Stream;
import stream.StreamGenerator;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestStream {

    public static void main(String[] args){
        Stream<Integer> stream = StreamGenerator.getIntegerStream(10);

        Stream<Integer> squareStream = stream.map(TestStream::square);

//        Stream<Integer> three = stream.limit(3);

        Integer sum = squareStream.reduce(0,(result,item)-> result + item);
        System.out.println(sum);
    }

    private static Integer square(int num){
        return num * 3;
    }
}
