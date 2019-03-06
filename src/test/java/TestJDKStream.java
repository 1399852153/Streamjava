import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestJDKStream {

    public static void main(String[] args){
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
//        stream = stream.map(TestJDKStream::square);
//        Stream<Integer> zero = square.limit(2);
        Optional<Integer> aa = stream.reduce((a,b)-> a+b);
        System.out.println(aa);
    }

    private static Integer square(int num){
        return num * num;
    }
}
