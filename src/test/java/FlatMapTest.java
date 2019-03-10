import stream.genetator.CollectionStreamGenerator;
import stream.util.CollectUtils;

import java.util.ArrayList;
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
        List<String> teamIndia = Arrays.asList("11", "12", "13");
        List<String> teamAustralia = Arrays.asList("21", "22", "23","24");
        List<String> teamEngland = Arrays.asList("31", "32", "33");
        List<String> teamNewZeland = Arrays.asList("41", "42", "43");
        List<String> teamSouthAfrica = Arrays.asList("52", "53");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);

        List list = CollectionStreamGenerator.getListStream(playersInWorldCup2016)
                .flatMap(CollectionStreamGenerator::getListStream)
                .filter(item->item.endsWith("2"))
                .limit(2)
                .collect(CollectUtils.toList());

        list.forEach(System.out::println);
//                .forEach(System.out::println);
    }
}
