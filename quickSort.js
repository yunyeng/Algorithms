function swap(array, firstIndex, secondIndex){
	var temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
}
function quickSort(array, p, r){
	if(p < r){
		var q = partition(array, p, r);
		quickSort(array, p, q-1);
		quickSort(array, p+1, r);
	}
}
function partition(array, p, r){
	var q = p;
	for(var j=p; j<r; j++){
		if(array[j] <= array[r]){
			swap(array, j, q);
			q++;
		}
	}
	swap(array, r, q);
	return q;
}

var arr = [882, -91, 14, 0, 21, -18, 91, 42, 19, 3, -3];
quickSort(arr, 0, arr.length-1);
console.log(arr);