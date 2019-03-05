package functional;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * filter 过滤操作
 */
@FunctionalInterface
public interface Predicate <T>{

    boolean isOK(T t);
}
