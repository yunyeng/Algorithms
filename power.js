function power(a, b){
	var result = 1
	if(b < 0)
		for(var i=0; i<Math.abs(b); i++)
			result /= a
	else
		for(var i=0; i<b; i++)
			result *= a
	return result
}

console.log(power(2, 20));