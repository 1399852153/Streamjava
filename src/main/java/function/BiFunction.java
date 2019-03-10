package function;

/**
 * @Author xiongyx
 * on 2019/3/8.
 */
@FunctionalInterface
public interface BiFunction<R, T, U> {

    /**
     * 函数式接口
     * 类似于 z = F(x,y)
     * */
    R apply(T t, U u);
}
