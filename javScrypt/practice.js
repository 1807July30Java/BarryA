var ar= [1,2,3,4];

function arrayRotateOne(arr, n){
	var el;

	for (var i = 0; i <n; i++) {
		arr.push(arr.shift());
	}
	return arr;
}; console.log(arrayRotateOne(ar,1));
