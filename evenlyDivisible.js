function isDivisible(num, n){
	for(var i=1; i<=n; i++){
		if(num % i !== 0){
			return false;
		}
	}
	return true;
}


for(var i=2520; i<999999999999; i++){
	if(isDivisible(i, 20)){
		console.log(i);
		break;
	}
}

console.log(isDivisible(2520, 10));