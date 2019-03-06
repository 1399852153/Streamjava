package second.stream;

import second.functional.EvalFunction;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Process<T> {

    Process<T> last;

    EvalFunction<T> evalFunction;

    public Process(Process<T> last, EvalFunction<T> evalFunction) {
        this.last = last;
        this.evalFunction = evalFunction;
    }

    public Process(EvalFunction<T> evalFunction) {
        this.evalFunction = evalFunction;
    }
}
