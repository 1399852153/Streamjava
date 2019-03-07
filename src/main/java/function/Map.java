package function;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * apply 映射操作
 */
@FunctionalInterface
public interface Map<R,T>{

    R apply(T item);
}
