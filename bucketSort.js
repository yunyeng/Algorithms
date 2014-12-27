function insertionSort(A){
	for(var i=0; i<A.length; i++){
		for(var j=i-1; j>=0 && A[j] > A[i]; j--){
			A[j+1] = A[j];
		}
		A[j+1] = A[i];
	}
}

function bucketSort(A){
	var B = [];
	var C = [];
	var n = A.length-1;
	for(var i=0; i<A.length; i++) B[i] = [];
	for(i=0; i<A.length; i++) B[Math.floor(n * A[i])].push(A[i]);
	for(i=0; i<A.length; i++) insertionSort(B[i]);
	for(i=0; i<A.length; i++) for(var j=0; j<B[i].length; j++) if(B[i][j]) C.push(B[i][j])
	return C;
}

var arr = [];
var sortedArr = [];
for(var i=0; i<10; i++){
	arr[i] = Math.random().toFixed(2);;
}
var sortedArr = bucketSort(arr)
//console.log(arr);
console.log(sortedArr);