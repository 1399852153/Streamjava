package function;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * filter 过滤操作
 */
@FunctionalInterface
public interface Predicate <T>{

    /**
     * 函数式接口
     * @param item 迭代的每一项
     * @return true 满足条件
     *          false 不满足条件
     * */
    boolean satisfy(T item);
}
