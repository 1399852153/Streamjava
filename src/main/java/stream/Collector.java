package stream;

import function.Accumulate;
import function.Supplier;

import java.util.function.Function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 */
public interface Collector<T, A, R> {

    Supplier<A> supplier();

    Accumulate<A, T> accumulator();

    Function<A, R> finisher();
}
