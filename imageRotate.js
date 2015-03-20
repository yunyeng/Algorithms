function rotate(image){
	var n = image.length;
	for(var layer=0; layer<Math.floor(n/2); layer++){
		var first = layer;
		var last = n - layer - 1;
		for(var i=first; i<last; i++){
			var offset = i - first;
			var top = image[first][i];
			image[first][i] = image[last-offset][first];
			image[last-offset][first] = image[last][last-offset];
			image[last][last-offset] = image[i][last];
			image[i][last] = top;
		}
	}
}

var image = [["abcd", "efgh", "ijkl", "mnop"],
				["qrst", "uvwx", "yz12", "3456"],
				["7890", "~!@#", "$%^&", "*()_"],
				["+=-`", "¡™£¢", "∞§¶•", "ªº–≠"]];
				
var image2 = [["a", "b", "c", "d"],["e", "f", "g", "h"], ["i", "j", "k", "l"], ["m", "n", "o", "p"]];
rotate(image);
console.log(image);