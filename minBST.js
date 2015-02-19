var BST = require('./BST');

function minHeight(b, arr, min, max){
	if(min <= max){
		mid = Math.floor((min + max)/2);
		b.insert(arr[mid]);
		minHeight(arr, min, mid-1);
		minHeight(arr, mid+1, max);	
	}
}

var b = new BST();
var orderedArr = [3, 5, 6, 10, 21, 33, 45, 46, 50, 60, 72, 98, 201, 300];
minHeight(b, orderedArr, 0, orderedArr.length-1);