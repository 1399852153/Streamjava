package second.functional;

import second.stream.Stream;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
@FunctionalInterface
public interface EvalFunction {

    Stream apply();
}
