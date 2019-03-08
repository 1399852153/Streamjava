package function;

/**
 * @Author xiongyx
 * @Date 2019/3/8
 */
@FunctionalInterface
public interface Comparator<T>  {

    int compare(T o1, T o2);
}
