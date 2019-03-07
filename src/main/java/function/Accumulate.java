package function;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * accumulate 累加操作
 */
public interface Accumulate <T,U>{

    T apply(T t1, U t2);
}
