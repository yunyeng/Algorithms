function swap(array, firstIndex, secondIndex){
	var temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
}
function indexOfMinimum(array, startIndex){
	var minValue = array[startIndex];
	var minIndex = startIndex;
	for(var i=minIndex; i<array.length; ++i){
		if(array[i] < minValue){
			minValue = array[i];
			minIndex = i;
		}
	}
	return minIndex;
}
function selectionSort(array){
	for(var i=0; i<array.length; ++i){
		var min = indexOfMinimum(array, i);
		swap(array, i, min);
	}
}

var array = [1, -99, 12, 27, 96, 47, 2, 33, 31, 999, -16, 21, 55];

selectionSort(array);

function binarySearch(array, target){
	var min = 0;
	var max = array.length - 1;
	var mid;
	while(min <= max){
		mid = Math.floor((max + min) / 2);
		if(array[mid] < target){
			min = mid + 1;
		} else if(array[mid] > target){
			max = mid - 1;
		} else {
			return mid;
		}
	}
	return -1;
}

console.log(array);
console.log(binarySearch(array, 55));