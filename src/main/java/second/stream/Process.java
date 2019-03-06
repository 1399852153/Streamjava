package second.stream;

import second.functional.EvalFunction;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Process {

    Process last;

    EvalFunction evalFunction;

    public Process(Process last, EvalFunction evalFunction) {
        this.last = last;
        this.evalFunction = evalFunction;
    }

    public Process(EvalFunction evalFunction) {
        this.evalFunction = evalFunction;
    }
}
