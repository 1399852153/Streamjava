package stream;

import functional.ForEach;
import functional.Mapper;
import functional.NextItem;
import functional.Predicate;

import java.util.List;

/**
 * @Author xiongyx
 * on 2019/3/5.
 */
public class Stream <T>{

    //=====================================成员属性===============================

    private T head;

    private NextItem nextItem;

    //====================================构造函数===============================

    public Stream() {
    }

    private Stream(List<T> list){

    }
    //=====================================公共接口=================================

    public <R> Stream<R> map(Mapper<R,T> mapper){

        return new Stream<>();
    }

    public Stream<T> filter(Predicate<T> predicate){

        return new Stream<>();
    }

    public void forEach(ForEach<T> forEach){
    }
}
