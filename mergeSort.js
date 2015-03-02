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
	var i = 0;
	var j = 0;
	while(k <= q)	lowHalf[i++] = array[k++];
	while(k <= r)	highHalf[j++] = array[k++];
	i = 0;
	j = 0;
	k = p;
	while(i < lowHalf.length && j < highHalf.length)
		if(lowHalf[i] < highHalf[j])	array[k++] = lowHalf[i++];
		else	array[k++] = highHalf[j++]
	while(i < lowHalf.length)	array[k++] = lowHalf[i++];
	while(j < highHalf.length)	array[k++] = highHalf[j++];
}

var arr = [77, -12, 21, 0, 1, 13, -2, 4, 19, 99, 500];
mergeSort(arr, 0, arr.length-1);
console.log(arr);