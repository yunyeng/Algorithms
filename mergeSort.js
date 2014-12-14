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
	for(i=0; k<=q; i++, k++){
		lowHalf[i] = array[k];
	}
	for(j=0; k<=r; j++, k++){
		highHalf[j] = array[k];
	}
	i = 0;
	j = 0;
	k = p;
	while(i < lowHalf.length && j < highHalf.length){
		if(lowHalf[i] < highHalf[j]){
			array[k] = lowHalf[i];
			i++;
		} else {
			array[k] = highHalf[j]
			j++;
		}
		k++;
	}
	while(i < lowHalf.length){
		array[k] = lowHalf[i];
		i++;
		k++;
	}
	while(j < highHalf.length){
		array[k] = highHalf[j];
		j++;
		k++;
	}
}

var arr = [77, -12, 21, 0, 1, 13, -2, 4, 19, 99, 500];
mergeSort(arr, 0, arr.length-1);
console.log(arr);