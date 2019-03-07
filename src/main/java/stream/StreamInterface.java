package stream;

import function.Accumulate;
import function.ForEach;
import function.Function;
import function.Predicate;


/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public interface StreamInterface<T> {

    /**
     * 映射
     * */
    <R> Stream<R> map(Function<R,T> mapper);

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
    void forEach(ForEach<T> consumer);

    /**
     * 浓缩
     * 终止操作
     * */
    <R> R reduce(R initVal,Accumulate<R,T> accumulator);

    /**
     * 收集
     * 终止操作
     * */
    <R, A> R collect(Collector<T,A,R> collector);

    /**
     * 返回空的 first.stream
     * @return 空stream
     * */
    static <T> Stream<T> makeEmptyStream(){
        return new Stream.Builder<T>()
            .isEnd(true).build();
    }
}
