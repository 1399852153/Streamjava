import java.math.BigDecimal;
import second.stream.Stream;
import second.stream.StreamGenerator;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class TestStream2 {

    public static void main(String[] args){
        Stream<Integer> intStream = StreamGenerator.getIntegerStream(10);

        intStream = intStream.map(TestStream2::square);

        Integer sum = intStream.reduce(0,(v1,v2) -> v1 + v2);
    }

    private static boolean idOdd(int num){
        return (num % 2 == 0);
    }

    private static Integer square(int num){
        return num * 3;
    }

    private static String toStr(int num){
        return num + "";
    }
}
