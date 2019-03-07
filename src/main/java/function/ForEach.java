package function;

/**
 * @Author xiongyx
 * on 2019/3/5.
 *
 * forEach 遍历操作
 */
@FunctionalInterface
public interface ForEach <T>{

    void apply(T item);
}
