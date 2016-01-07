function rotate(image){
	var n = image.length;
	for(var out=0; out<Math.floor(n/2); out++){
		for(var ins=out; ins<n-out-1; ins++){
			var top = image[out][ins];
			image[out][ins] = image[n-ins-1][out];
			image[n-ins-1][out] = image[n-out-1][n-ins-1];
			image[n-out-1][n-ins-1] = image[ins][n-out-1];
			image[ins][n-out-1] = top;
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