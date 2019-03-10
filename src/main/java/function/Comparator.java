package function;

/**
 * @Author xiongyx
 * @Date 2019/3/8
 */
@FunctionalInterface
public interface Comparator<T>  {

    /**
     * 比较方法逻辑
     * @param o1    参数1
     * @param o2    参数2
     * @return      返回值大于0 ---> (o1 > o2)
     *               返回值等于0 ---> (o1 = o2)
     *               返回值小于0 ---> (o1 < o2)
     */
    int compare(T o1, T o2);
}
