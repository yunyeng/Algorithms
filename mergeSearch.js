function mergeSort(array, p, r){
	if(p < r){
		var q = Math.floor((p + r) / 2);
		mergeSort(array, p, q);
		mergeSort(array, q+1, r);
		merge(array, p, q, r);
	}
}
function merge(array, p, q, r){
	var lowHalf = [];
	var highHalf = [];
	var k = p;
	var i;
	var j;
	for(i=0; k <= q; i++, k++){
		lowHalf[i] = array[k];
	}
	for(j=0; k<= r; j++, k++){
		highHalf[j] = array[k];
	}
	k = p;
	i = 0;
	j = 0;
	while(i<lowHalf.length && j<highHalf.length){
		if(lowHalf[i] < highHalf[j]){
			array[k] = lowHalf[i];
			i++;
		} else {
			array[k] = highHalf[j];
			j++;
		}
		k++;
	}
	while(i<lowHalf.length){
		array[k] = lowHalf[i];
		i++;
		k++;
	}
	while(j<highHalf.length){
		array[k] = highHalf[j];
		j++;
		k++;
	}
}
function binarySearch(array, target){
	mergeSort(array, 0, array.length-1);
	var min = 0;
	var max = array.length - 1;
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

var arr = [-12, 21, 55, -99, 89, 124, 1, 0, 18, 101, 55, -32, 31, 69];
console.log(arr);
console.log(binarySearch(arr, 89));
console.log(binarySearch(arr, 1));
console.log(binarySearch(arr, -31));