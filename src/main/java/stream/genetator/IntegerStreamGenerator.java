package stream.genetator;

import stream.Process;
import stream.Stream;
import stream.StreamInterface;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class IntegerStreamGenerator {

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
        return getIntegerStreamInner(low,high,true);
    }

    private static Stream<Integer> getIntegerStreamInner(int low,int high,boolean isStart){
        if(low > high){
            return StreamInterface.makeEmptyStream();
        }

        if(isStart){
            Stream<Integer> intStream = new Stream.Builder<Integer>()
                    .process(new Process(()->getIntegerStreamInner(low,high,false)))
                    .build();
            return intStream;
        }else{
            Stream<Integer> intStream = new Stream.Builder<Integer>()
                    .head(low)
                    .process(new Process(()->getIntegerStreamInner(low+1,high,false)))
                    .build();
            return intStream;
        }
    }
}
