package stream;

import function.*;


/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public interface StreamInterface<T> {

    /**
     * 映射
     * lazy
     * */
    <R> Stream<R> map(Function<R,T> mapper);

    /**
     * 扁平化 映射
     * */
    <R> Stream<R> flatMap(Function<? extends Stream<R>, T> mapper);

    /**
     * 过滤
     * lazy
     * */
    Stream<T> filter(Predicate<T> predicate);

    /**
     * 截断
     * lazy
     * */
    Stream<T> limit(int n);

    /**
     * 遍历
     * eval
     * */
    void forEach(ForEach<T> consumer);

    /**
     * 浓缩
     * eval
     * */
    public <R> R reduce(R initVal, BiFunction<R, R, T> accumulator);

    /**
     * 收集
     * eval
     * */
    <R, A> R collect(Collector<T,A,R> collector);

    /**
     * 最大值
     * eval
     * */
    T max(Comparator<T> comparator);

    /**
     * 最大值
     * eval
     * */
    T min(Comparator<T> comparator);

    /**
     * 返回空的 stream
     * @return 空stream
     * */
    static <T> Stream<T> makeEmptyStream(){
        return new Stream.Builder<T>()
            .isEnd(true).build();
    }
}
