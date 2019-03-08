package function;

/**
 * @Author xiongyx
 * on 2019/3/8.
 */
@FunctionalInterface
public interface BiFunction<R, T, U> {

    R apply(T t, U u);
}
