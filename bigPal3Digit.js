function isPalindrome(str){
	for(var i=0; i<str.length; i++) if(str[i] != str[str.length-1-i]) return false;
	return true;
}
function maxVal(arr){
	var val = arr[0];
	for(var i=1; i<arr.length; i++){
		if(arr[i] > val){
			val = arr[i];
		}
	}
	return val;
}
function largestPalindrome(){
    var results = [];    
    for(var i =999; i>=100; i--){
        for(var j = 999; j>=100; j--){
            var multip = j*i;
            if(isPalindrome(String(multip))){
                results.push(multip);
            }
        }
    }
    return maxVal(results);
}

console.log(largestPalindrome());
