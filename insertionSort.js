var insert = function(array, rightIndex, value) {
	for(var j = rightIndex; j >= 0 && array[j] > value; j--){
		array[j+1] = array[j];
	}
	array[j + 1] = value; 
};

var insertionSort = function(array) {
	for(var i=1; i<array.length; i++){
        insert(array, i-1, array[i]);
    }
};



function swap(array, firstIndex, secondIndex){
	var temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
}
function binarySearch(array, target){
	var min = 0;
	var max = array.length-1;
	var guess;
	while(min <= max){
		guess = Math.floor((min + max) / 2);
		if(array[guess] > target){
			max = guess - 1;
		} else if(array[guess] < target){
			min = guess + 1;
		} else {
			return guess;
		}
	}
	return -1;
}







var arr = [11, -21, 91, 1, 0, 15, 22, 99, 400, -125, 32];

insertionSort(arr);

console.log("Array after inserting:  " + arr);

