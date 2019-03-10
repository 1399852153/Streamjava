package stream;

import function.BiFunction;
import function.Supplier;

import java.util.function.Function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 *
 * collect接口 收集器
 * 通过传入组合子，生成高阶过程
 */
public interface Collector<T, A, R> {

    /**
     * 收集时，提供初始化的值
     * */
    Supplier<A> supplier();

    /**
     * A = A + T
     * 累加器，收集时的累加过程
     * */
    BiFunction<A, A, T> accumulator();

    /**
     * 收集完成之后的收尾操作
     * */
    Function<A, R> finisher();
}
