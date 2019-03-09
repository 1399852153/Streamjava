import stream.Stream;
import stream.genetator.CollectionStreamGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xiongyx
 * on 2019/3/8.
 */
public class FlatMapTest {

    public static void main(String[] args){
        testCollectionGenerator();
    }

    private static void testCollectionGenerator(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> listStream = CollectionStreamGenerator.getListStream(list);

        listStream.filter(item->item<5).map(item->item * item);

        listStream.forEach(System.out::println);
    }
}
