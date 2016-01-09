var arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14];
var arr2 = [10, 15, 20, 0, 5];
var arr3 = [50, 5, 20, 30, 40];

function binaryRotate(arr, target, min, max){
	var mid = Math.floor((min+max)/2);
	if(target == arr[mid]) return mid;
	if(min > max) return -1;
	if(arr[min] < arr[mid]){
		if(target >= arr[min] && target <= arr[mid]){
			return binaryRotate(arr, target, min, mid-1);
		} else {
			return binaryRotate(arr, target, mid+1, max);
		}
	} else if(arr[min] > arr[mid]){
		if(target >= arr[mid] && target <= arr[max]){
			return binaryRotate(arr, target, mid+1, max);
		} else {
			return binaryRotate(arr, target, min, mid-1);
		}
	} else {
		if(arr[mid] != arr[max]){
			return binaryRotate(arr, target, mid+1, max);
		} else {
			var result = binaryRotate(arr, target, min, mid-1);
			if(result == -1){
				return binaryRotate(arr, target, mid+1, max);
			} else {
				return result;
			}
		}
	}
	return -1;
}

console.log(binaryRotate(arr3, 40, 0, arr.length-1));