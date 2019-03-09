package stream.genetator;

import stream.Process;
import stream.Stream;
import stream.StreamInterface;

import java.util.Iterator;
import java.util.List;

/**
 * @Author xiongyx
 * on 2019/3/9.
 */
public class CollectionStreamGenerator {

    public static <T> Stream<T> getListStream(List<T> list){
        return getListStream(list.iterator(),true);
    }

    private static <T> Stream<T> getListStream(Iterator<T> iterator,boolean isStart){
        if(!iterator.hasNext()){
            return StreamInterface.makeEmptyStream();
        }

        if(isStart){
            Stream<T> stream = new Stream.Builder<T>()
                    .process(new Process(()-> getListStream(iterator,false)))
                    .build();
            return stream;
        }else{
            Stream<T> stream = new Stream.Builder<T>()
                    .head(iterator.next())
                    .process(new Process(()-> getListStream(iterator,false)))
                    .build();
            return stream;
        }
    }
}
