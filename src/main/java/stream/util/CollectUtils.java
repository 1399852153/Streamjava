package stream.util;

import function.BiFunction;
import function.Supplier;
import stream.Collector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @Author xiongyx
 * on 2019/3/10.
 *
 * stream.collect() 参数常用工具类
 */
public class CollectUtils {

    /**
     * stream 转换为 List
     * */
    public static <T> Collector<T, List<T>, List<T>> toList(){
        return new Collector<T, List<T>, List<T>>() {
            @Override
            public Supplier<List<T>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiFunction<List<T>, List<T>, T> accumulator() {
                return (list, item) -> {
                    list.add(item);
                    return list;
                };
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return list -> list;
            }
        };
    }

    /**
     * stream 转换为 Set
     * */
    public static <T> Collector<T, Set<T>, Set<T>> toSet(){
        return new Collector<T, Set<T>, Set<T>>() {
            @Override
            public Supplier<Set<T>> supplier() {
                return HashSet::new;
            }

            @Override
            public BiFunction<Set<T>, Set<T>, T> accumulator() {
                return (set, item) -> {
                    set.add(item);
                    return set;
                };
            }

            @Override
            public Function<Set<T>, Set<T>> finisher() {
                return set -> set;
            }
        };
    }
}
