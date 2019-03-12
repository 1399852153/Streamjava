import java.util.Arrays;
import java.util.List;
import stream.MyStream;
import stream.genetator.CollectionStreamGenerator;
import stream.genetator.IntegerStreamGenerator;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class TestMyStream {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,1,1,2,3,4,5,6,2,3,2);

        MyStream<Integer> intMyStream = CollectionStreamGenerator.getListStream(list);

//        intMyStream = intMyStream.distinct();

//        System.out.println(intMyStream.count());

//        intMyStream.forEach(System.out::println);

        System.out.println(intMyStream.anyMatch(item->item==6));
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
