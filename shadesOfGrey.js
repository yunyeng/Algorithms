String.prototype.replaceAt = function(index, character) {
	character = character.toString();
	return this.substr(0, index) + character + this.substr(index+character.length);
}

function shadesOfGrey(n){
	var arr = [];
	var col = ['A', 'B', 'C', 'D', 'E', 'F'];
	if(n < 0) return arr;
	var color = '#000000';
	var a = 0;
	var b = 0;
	for(var i=0; i<10; i++){
		for(var j=0; j<10; j++){
			color = color.replaceAt(1, i);
			color = color.replaceAt(2, j);
			color = color.replaceAt(3, i);
			color = color.replaceAt(4, j);
			color = color.replaceAt(5, i);
			color = color.replaceAt(6, j);
			arr.push(color);
		}
	}
	for(var i=0; i<col.length; i++){
		for(var j=0; j<col.length; j++){
			if(i === col.length-1 && j === col.length-1) break;
			color = color.replaceAt(1, col[i]);
			color = color.replaceAt(2, col[j]);
			color = color.replaceAt(3, col[i]);
			color = color.replaceAt(4, col[j]);
			color = color.replaceAt(5, col[i]);
			color = color.replaceAt(6, col[j]);
			arr.push(color);
		}
	}
	for(var i=0; i<10; i++){
		for(var j=0; j<col.length; j++){
			color = color.replaceAt(1, i);
			color = color.replaceAt(2, col[j]);
			color = color.replaceAt(3, i);
			color = color.replaceAt(4, col[j]);
			color = color.replaceAt(5, i);
			color = color.replaceAt(6, col[j]);
			arr.push(color);
		}
	}
	for(var i=0; i<col.length; i++){
		for(var j=0; j<10; j++){
			color = color.replaceAt(1, col[i]);
			color = color.replaceAt(2, j);
			color = color.replaceAt(3, col[i]);
			color = color.replaceAt(4, j);
			color = color.replaceAt(5, col[i]);
			color = color.replaceAt(6, j);
			arr.push(color);
		}
	}
	return arr;
}


console.log(shadesOfGrey(254));