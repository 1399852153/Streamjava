package first.functional;

import first.stream.Stream;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
@FunctionalInterface
public interface NextItem<T> {

     Stream<T> apply();
}
