package stream;

import functional.Accumulate;
import functional.ForEach;
import functional.Map;
import functional.Predicate;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public interface StreamInterface<T> {

    /**
     * 映射
     * */
    <R> Stream<R> map(Map<R,T> mapper);

    /**
     * 过滤
     * */
    Stream<T> filter(Predicate<T> predicate);

    /**
     * 截断
     * */
    Stream<T> limit(int n);

    /**
     * 遍历
     * 终止操作
     * */
    void forEach(ForEach<T> forEach);

    /**
     * 浓缩
     * 终止操作
     * */
    <R> R reduce(R initVal,Accumulate<R,T> accumulator);

    /**
     * 返回空的 stream
     * @return 空stream
     * */
    static <T> Stream<T> makeEmptyStream(){
        return new Stream<>(true);
    }
}
