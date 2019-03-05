package functional;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * map 映射操作
 */
@FunctionalInterface
public interface Mapper <R,T>{

    R map(T item);
}
