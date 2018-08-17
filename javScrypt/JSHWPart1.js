var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/

homework.fibonacci = function(n){
var x = n;
var y = 1;
var total = 1; 

if (x === 0) {
	total = 0;
	console.log(total);
	return total;
} else {

	while (y != x) {
		total = total + (y+1);
		y += 1;
	}

	console.log(total);
	return total;
}

};


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
var arr = [];
y = array.length;
console.log(Math.min(...array));

for (let i = 0; i < y; i++) {
	var x=Math.min(...array);
	arr.push(x);
	array.splice(array.indexOf(x), 1);
	console.log(arr);
}
return arr;
}; 



/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
var x = n;
var y = 1;
var total = 1; 


if (x === 0) {
	total = 1;
	console.log(total);
	return total;
} else {

	while (y != x) {
		total = total * (y+1);
		y += 1;
	}

	console.log(total);
	return total;
}

};homework.factorial();

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {

for (var i = 0; i < n; i++) {
	array.push(array.shift())
}
return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	var oPar = 0;
	var oCur = 0;
	var oBra = 0;
	boolean balanced;
	for (var i = 0; i < bracketsString.length; i++) {
		if (bracketsString[i]=== "(") {
			oPar+=1;
		} else if (bracketsString[i]=== "{") {
			oCur +=1;
		}else if (bracketsString[i]==="[") {
			oBra +=1;
		}else if (bracketsString[i]=== "}") {
			oCur -=1;
		}else if (bracketsString[i]==="]") {
			oBra -=1;
		}else if (bracketsString[i]===")") {}{
			oCur -=1;
		}
	}

		if (oPar===0 &&oCur===0 &&oBra===0) {
			balanced = true;
			return balanced;
		}else{
			balanced = false;
			return balanced
		}
	

};
