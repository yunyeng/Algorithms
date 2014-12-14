function isUnique(str){
	var boolCheck = [];
	for(var i=0; i<str.length; i++){
		var val = str.charAt(i);
		if(boolCheck[val]){
			return false;
		}
		boolCheck[val] = true;
	}
	return true;
}

var str = 'qwertyuioplkjhgfdsazxcvbnm';
console.log(isUnique(str));

var str2 = 'qwertyuioplkjhgfdsazzxcvbnm';
console.log(isUnique(str2));