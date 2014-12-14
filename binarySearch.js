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

var arr = [0, 2, 4, 12, 21, 88, 101, 128, 144, 255];
console.log(binarySearch(arr, 252));