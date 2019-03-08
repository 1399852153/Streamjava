package stream;

import function.BiFunction;
import function.Supplier;

import java.util.function.Function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 */
public interface Collector<T, A, R> {

    Supplier<A> supplier();

    BiFunction<A, A, T> accumulator();

    Function<A, R> finisher();
}
