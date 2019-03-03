//debugger;

var array = getIntArray(10);
console.log("ordinaryArray =" + array);

// forEach Test
forEach(array,function(item,index,array){
	console.log("item =" + item + " index =" + index);
});

// filter Test
var oddArray = filter(array,function(item){
	return (item % 2 !== 0);
});
console.log("oddArray =" + oddArray);

// map Test
var squareArray = map(array,function(item){
	return item * item;
});
console.log("squartArray =" + squareArray);

// reduce Test
var addSum = reduce(squareArray,function(item1,item2){
	return item1 + item2;
},0);
console.log("addSum =" + addSum);

// flatMap Test

//=================================define====================================
// getIntArray
function getIntArray(n){
	let array = [];
	for(let i=0; i<=n; i++){
		array.push(i);
	}
	
	return array;
}

// forEach
function forEach(array,consumer_f){
	for(let i=0; i<array.length; i++){
		var item = array[i];
		consumer_f(item,i,array);
	}
}

// filter
function filter(array,predicate_f){
	let filted = [];
	
	forEach(array,function(item){
		if(predicate_f(item)){
			filted.push(item);
		}
	});
	
	return filted;
}

// map
function map(array,mapper_f){
	let mapped = [];
	
	forEach(array,function(item){
		mapped.push(mapper_f(item));
	});
	
	return mapped;
}

// reduce
function reduce(array,accumulator_f,start){
	let accumulate = start;
	
	forEach(array,function(item){
		accumulate = accumulator_f(accumulate,item);
	});
	
	return accumulate;
}