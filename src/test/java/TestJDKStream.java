import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestJDKStream {

    public static void main(String[] args){
        Stream<Integer> stream = new ArrayList<Integer>().stream();
        stream.map(item->item-1).filter(item->item==0);
    }
}
