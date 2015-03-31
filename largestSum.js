// You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum

var input = [2, -8, 3, -2, 4, -10];

function largestSum(arr){
	var result = 0;
	for(var i=0; i<arr.length-1; i++){
		if((arr[i] + arr[i+1]) > 0){
			result += arr[i];
		} else if((arr[i] + arr[i-1]) > 0){
			result += arr[i];
		}
	}
	return result;
}

// More Robust Solution
function getMaxSum(arr){
	var maxSum = 0;
	var sum = 0;
	for(var i=0; i<arr.length; i++){
		sum += arr[i];
		if(sum > maxSum){
			maxSum = sum;
		} else if(sum < 0){
			sum = 0;
		}
	}
	return maxSum;
}

console.log(largestSum(input));
console.log(getMaxSum(input));