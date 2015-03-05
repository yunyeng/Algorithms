function isAscending(arr){
	for(var i=1; i<arr.length; i++){
		if(arr[i-1] >= arr[i]){
			return false;
		}
	}
	return true;
}
function isDescending(arr){
	for(var i=1; i<arr.length; i++){
		if(arr[i-1] <= arr[i]){
			return false;
		}
	}
	return true;
}
function isAscDesc(arr){
	for(var i=0; i<arr.length; i++){
		if(arr[i] >= arr[i+1]){
			break;
		}
	}
	for(var j=i; i<arr.length-1; i++){
		if(arr[i] <= arr[i+1]){
			return false;
		}
	}
	return true;
}
function isDescAsc(arr){
	for(var i=0; i<arr.length; i++){
		if(arr[i] <= arr[i+1]){
			break;
		}
	}
	for(var j=i; i<arr.length-1; i++){
		if(arr[i] >= arr[i+1]){
			return false;
		}
	}
	return true;
}
function pattern(arr){
	if(isAscending(arr)){
		return 'Ascending';
	} else if(isDescending(arr)){
		return 'Descending';
	} else if(isAscDesc(arr)){
		return 'Ascending, Descending';
	} else if(isDescAsc(arr)){
		return 'Descending, Ascending';
	}
	return 'No pattern found';
}

var arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var arr2 = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
var arr3 = [1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1];
var arr4 = [10, 9, 8, 7, 6, 12, 21, 32, 45, 52];

console.log(pattern(arr1));
console.log(pattern(arr2));
console.log(pattern(arr3));
console.log(pattern(arr4));