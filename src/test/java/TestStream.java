import stream.Stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestStream {

    public static void main(String[] args){
        Stream<Integer> stream = new Stream<>();

        stream.map(item-> 1).filter(item-> item == 0);
    }
}
