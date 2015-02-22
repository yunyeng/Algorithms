function multiply(a, b){
	var result = 0;
	for(var i=0; i<Math.abs(b); i++){
			result += Math.abs(a);
	}
	if(a < 0 || b < 0) result  = subtract(result, result+result);
	return result;
}
function subtract(a, b){
	for(var i=0; i<Math.abs(b); i++){
		if(b < 0) a+=1;
		else a+=(-1);
	}
	return a;
}
function divide(a, b){
	var result = 0;
	a = Math.abs(a);
	b = Math.abs(b);
	for(var i=b; i<=a; i+=b){
		result++;
	}
	return result;
}

console.log(multiply(12, -12));

console.log(subtract(-7, -2));

console.log(divide(40, 6))