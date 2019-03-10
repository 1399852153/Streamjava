package function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * 提供初始值
     * @return 初始化的值
     * */
    T get();
}
