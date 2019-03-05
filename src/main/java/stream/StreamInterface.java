package stream;

import functional.ForEach;
import functional.Map;
import functional.Predicate;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public interface StreamInterface<T> {

    <R> Stream<R> map(Map<R,T> mapper);

    Stream<T> filter(Predicate<T> predicate);

    void forEach(ForEach<T> forEach);

    static <T> Stream<T> makeEmptyStream(){
        return new Stream<>(true);
    }
}
