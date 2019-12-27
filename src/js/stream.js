// 创建、构造流
function create_stream(isEmpty,head,promise){
    return {
        isEmpty : isEmpty,
        head : head,
        promise : promise
    }
}

// 创建空流
function create_empty_stream(){
    return create_stream(true);
}

// 判断一个流是否为空流
function is_empty_stream(stream){
    return stream.isEmpty === true;
}

// 对流求值
function stream_eval(stream){
    return stream.promise();
}

// =========================================测试代码==========================================

// 强制求值操作 forEach
function forEach(stream, consumer){
    if(is_empty_stream(stream)){
        return;
    }

    let head = stream.head;
    consumer(head);

    let evaluated = stream_eval(stream);
    forEach(evaluated,consumer);
}

// 惰性求值操作 map
function map(stream, mapper){
    if(is_empty_stream(stream)){
        return create_empty_stream();
    }

    let mappered = mapper(stream.head);
    return create_stream(false,mappered,function(){
        return map(stream_eval(stream),mapper);
    });
}

// 惰性求值操作 limit
function limit(stream, limitNum){
    if(is_empty_stream(stream) || limitNum === 0){
        return create_empty_stream();
    }

    return create_stream(false,stream.head,function(){
        return limit(stream_eval(stream),limitNum-1);
    });
}

function create_num_stream(low,high){
    return create_stream(false,low,function(){
        if(low === high){
            return create_empty_stream();
        }

        return create_num_stream(low+1,high);
    });
}

let intStream = create_num_stream(0,10);

debugger;
let mappedStream = map(intStream,function(item){
    return item * item;
});

let limitStream = limit(mappedStream,6);

forEach(limitStream,function(data){
    console.log(data);
});