import stream.Stream;
import stream.StreamGenerator;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestStream {

    public static void main(String[] args){
        Stream<Integer> stream = StreamGenerator.getIntegerStream(10);

        Stream<Integer> fiveStream = stream.map(item-> item * 5);

        Stream stream1 = fiveStream.getTail().getEval().apply();
        fiveStream.setTail(stream1);
        Stream stream2 = stream1.getTail().getEval().apply();
        stream1.setTail(stream2);
        Stream stream3= stream2.getTail().getEval().apply();
        stream2.setTail(stream3);
        Stream stream4 = stream3.getTail().getEval().apply();
        stream3.setTail(stream4);
        Stream stream5 = stream4.getTail().getEval().apply();
        stream4.setTail(stream5);
    }
}
