/* A circus designing a tower routine consisting of people standing atop one another's shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.*/


function swap(array, firstIndex, secondIndex){
	var temp = array[firstIndex];
	array[firstIndex] = array[secondIndex];
	array[secondIndex] = temp;
}
function quickSort(array, p, r){
	if(p < r){
		var q = partition(array, p, r);
		quickSort(array, p, q-1);
		quickSort(array, p+1, r);
	}
}
function partition(array, p, r){
	var q = p;
	for(var j=p; j<r; j++){
		if(array[j] <= array[r]){
			swap(array, j, q);
			q++;
		}
	}
	swap(array, r, q);
	return q;
}

var arr = [[65, 100], [70, 150], [56, 90], [75, 190], [60, 95], [68, 110]];

function tower(arr){
	var newArr = {};
	for(var i=0; i<arr.length; i++){
		newArr[arr[i][0]] = arr[i][0] + arr[i][1];
	}
	quickSort(newArr);
	i = 0;
	for (var key in newArr) {
	   var obj = newArr[key];
	   arr[i] = [key,obj-key];
		i++;
	}
}

tower(arr);
console.log(arr);