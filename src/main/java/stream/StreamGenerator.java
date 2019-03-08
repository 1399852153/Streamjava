package stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class StreamGenerator {

    public static Stream<Integer> getIntegerStream(int n){
        if(n < 0){
            return StreamInterface.makeEmptyStream();
        }

        Stream<Integer> intStream = new Stream.Builder<Integer>()
                .head(n)
                .process(new Process(()->getIntegerStream(n-1)))
                .build();

        return intStream;
    }

    public static Stream<Integer> getIntegerStream(int low,int high){
        if(low > high){
            return StreamInterface.makeEmptyStream();
        }

        Stream<Integer> intStream = new Stream.Builder<Integer>()
                .head(low)
                .process(new Process(()->getIntegerStream(low+1,high)))
                .build();

        return intStream;
    }
}
