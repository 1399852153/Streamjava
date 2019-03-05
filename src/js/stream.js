function delay(fn){
	return function(){
		return fn();
	}
}

function force(delayed_fn){
	return delayed_fn();
}

// 构造 流对象
function cons_stream(h,nextFn){
	return {
		head : h,
		tail : delay(nextFn)
	}
}

// 构造 空的流对象
function empty_stream(){
	return 'none';
}

// 是否是空的流对象 boolean
function is_empty_stream(stream){
	return (stream === 'none');
}

// 获得流对象的头部
function head(stream){
	return stream.head;
}

// 获得流对象的尾部
function tail(stream){
	return force(stream.tail);
}