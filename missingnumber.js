// Missing number

function find(arr){
	var total = (arr.length+1) * (arr.length+2) / 2;
	for(var i=0; i<arr.length; i++){
		total -= arr[i];
	}
	return total;
}

console.log(find([1, 2, 3, 5, 6, 7, 8, 9, 10]));