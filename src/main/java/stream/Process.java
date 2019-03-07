package stream;

import function.EvalFunction;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
public class Process {

    Process next;

    EvalFunction evalFunction;

    public Process(EvalFunction evalFunction) {
        this.evalFunction = evalFunction;
    }

    public Stream eval(){
        Stream result = evalFunction.apply();

        return result;
    }
}
