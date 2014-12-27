function countingSort(A){
	var k = Number.NEGATIVE_INFINITY;
	var C = [];
	var B = [];
	// Finding maximum value in input array
	for(var i=0; i<A.length; i++) if(A[i] > k) k = A[i];
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
	return B;
}

var arr = [3, 1, 0, 2, 5, 8, 6, 10, 9, 7, 4, 2];
var sortedArr = countingSort(arr);
console.log(sortedArr);
