function rotate(image){
	var ROWS = image.length;
	var COLS = image[0].length;
	for(var row=0; row<Math.floor(ROWS/2); row++){
		for(var col=row; col<COLS-row-1; col++){
			var top = image[row][col];
			image[row][col] = image[ROWS-col-1][row];
			image[ROWS-col-1][row] = image[ROWS-row-1][ROWS-col-1];
			image[ROWS-row-1][ROWS-col-1] = image[col][ROWS-row-1];
			image[col][ROWS-row-1] = top;
		}
	}
}

var image = [["abcd", "efgh", "ijkl", "mnop"],
				["qrst", "uvwx", "yz12", "3456"],
				["7890", "~!@#", "$%^&", "*()_"],
				["+=-`", "¡™£¢", "∞§¶•", "ªº–≠"]];
				
var image2 = [["a", "b", "c", "d"],["e", "f", "g", "h"], ["i", "j", "k", "l"], ["m", "n", "o", "p"]];
rotate(image2);
console.log(image2);