package function;

/**
 * @Author xiongyx
 * on 2019/3/7.
 */
@FunctionalInterface
public interface Function<R,T> {

    R apply(T t);
}
