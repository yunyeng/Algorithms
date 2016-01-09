var BST = require('./BST');
var binarySearch = require('./binarySearch');

var tree = new BST();
var arr = [-21, -12, 1, 5, 21, 33, 38, 41, 55, 72, 101, 125, 136, 137, 140];

var mid = Math.floor(arr.length / 2);
//console.log(mid);




var i = mid + 1;
counter = 1;

var min = 0;
var max = arr.length-1;
var mid;

while(i > 0 && i < arr.length){
	mid = Math.floor((min + max) / 2);
	tree.insert(arr[mid]);
	if(i % 2 == 0){
		min = mid + 1;
		max = 
	} else {
		max = mid - 1;
	}
	
}
