// 构造 流对象
function cons_stream(h,t){
	return {
		head : h,
		tail : t
	}
}

// 构造 空的流对象
function empty_stream(x,y){
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
	return stream.tail;
}