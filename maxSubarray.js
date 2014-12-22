function crossingMaxSubarray(arr, lo, mid, hi){
	var sum = 0;
	var leftSum = Number.NEGATIVE_INFINITY;
	var left;
	for(var i=mid; i>=0; i--){
		sum += arr[i];
		if(sum > leftSum){
			leftSum = sum;
			left = i;
		}
	}
	sum = 0;
	var rightSum = Number.NEGATIVE_INFINITY;
	var right;
	for(j=mid+1; j<=hi; j++){
		sum += arr[j];
		if(sum > rightSum){
			rightSum = sum;
			right = j;
		}
	}
	return [left, right, leftSum + rightSum];
}
function maxSubarray(arr, lo, hi){
	if(lo == hi){
		return [lo, hi, arr[lo]];
	} else {
		var mid = Math.floor((lo + hi) / 2);
		var leftLeft = maxSubarray(arr, lo, mid)[0];
		var leftRight = maxSubarray(arr, lo, mid)[1];
		var leftSum = maxSubarray(arr, lo, mid)[2];
		var rightLeft = maxSubarray(arr, mid+1, hi)[0];
		var rightRight = maxSubarray(arr, mid+1, hi)[1];
		var rightSum = maxSubarray(arr, mid+1, hi)[2];
		var crossLeft = crossingMaxSubarray(arr, lo, mid, hi)[0];
		var crossRight = crossingMaxSubarray(arr, lo, mid, hi)[1];
		var crossSum = crossingMaxSubarray(arr, lo, mid, hi)[2];
		if(leftSum > rightSum && leftSum > crossSum){
			return [leftLeft, leftRight, leftSum];
		} else if(rightSum > leftSum && rightSum > crossSum){
			return [rightLeft, rightRight, rightSum];
		} else {
			return [crossLeft, crossRight, crossSum];
		}
	}
}


var arr = [31, -41, 59, 26, -53, 58, 97, -93, -23, 84];
var arr2 = [13, -10, 25, 15, -34, 21, 58, 12];
console.log(maxSubarray(arr2, 0, arr2.length-1));