import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class TestJDKStream {

    public static void main(String[] args){
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

        // Now let's do this in Java 8 using FlatMap
        playersInWorldCup2016.stream()
            .flatMap(pList -> pList.stream())
                .filter(item->item.endsWith("4"))
                .limit(3)
                .forEach(System.out::println);
    }
}
