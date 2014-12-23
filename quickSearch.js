function swap(array, firstIndex, secondIndex){
	var temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
}
function partition(array, p, r){	
	var q = p;
	var j;
	for(j = p; j < r; j++){
		if(array[j] <= array[r]){
			swap(array, j, q);
			q++;
		}
	}
	swap(array, r, q);
	return q;
}
function quickSort(array, p ,r){
	if(p < r){
		var q = partition(array, p, r);
		quickSort(array, p, q-1);
		quickSort(array, q+1, r);
	}
}
function binarySearch(array, target){
	var min = 0;
	var max = array.length - 1;
	///////////////////////////
	quickSort(array, min, max);
	///////////////////////////
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

var arr = [31, 69, 200, 0, -1, -9, 1000000, 99, 12, 33];
console.log(binarySearch(arr,33));