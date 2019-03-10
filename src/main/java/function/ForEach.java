package function;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * forEach 遍历操作
 */
@FunctionalInterface
public interface ForEach <T>{

    /**
     * 迭代器
     * @param item 被迭代的每一项
     * */
    void apply(T item);
}
