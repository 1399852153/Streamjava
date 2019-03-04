function stream_enumerate_interval(low,high){
	if(low > high){
		return empty_stream;
	}
	
	return cons_stream(
		low,
		function(){
			return stream_enumerate_interval(low + 1,high);
		}	
	);
}


function integer_staring_from(n){
	return cons_stream(
		n,
		function(){
			return integer_staring_from(n+1);
		}
	)
}