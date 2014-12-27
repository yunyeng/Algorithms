function countingSort(A){
	// Assume the max value 0th element, then we can search starting from 1st
	var k = A[0];
	var C = [];
	var B = [];
	// Finding maximum value in input array starting from 1st value
	for(var i=1; i<A.length; i++) if(A[i] > k) k = A[i];
	// Creating new array to use as big as the max value k and initializing to 0
	for(i=0; i<=k; i++) C[i] = 0;
	// Incrementing all the values that exists in input array
	for(var j=0; j<A.length; j++) C[A[j]]++;
	// Adding i-1 elements to i values
	for(i=1; i<=k; i++) C[i] += C[i-1];
	// Creating the output array B using the input array A and array C
	for(j=0; j<A.length; j++){
		B[C[A[j]]-1] = A[j];
		C[A[j]]--;
	}
	// Returning the output array B, we could take this as parameter and sort it in place.
	return B;
}

var arr = [3, 1, 0, 2, 5, 8, 6, 10, 9, 7, 4, 2];
var sortedArr = countingSort(arr);
console.log(sortedArr);
