var Queue = require('./LinkedQueue');
var Stack = require('./Stack');
var q = new Queue();
var s = new Stack();

var arr = [3, 1, 4, 25, 8, 32, 9, 0, 10, 5, 44, 33, 12];

//13.416666666666666

function avg(arr, j){
	var sum = 0;
	for(var i=0; i<arr.length; i++) if(arr[i] != arr[j]) sum += arr[i]/arr.length;	return Math.floor(sum);
}
function whichOne(arr, num){
	for(var i=0; i<arr.length; i++){
		if(avg(arr, i) == num){
			 return arr[i];
		}
	}
	return false;
}

console.log(whichOne(arr, 13));