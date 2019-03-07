package function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 */
@FunctionalInterface
public interface Supplier<T> {

    T get();
}
