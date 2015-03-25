var BST = require("./BST");
var b = new BST();
var arr = [3, 5, 1, -11, -99, 100, 3, 4, 12, 98, 76, -124, 54, 45, 88, 33, 22, 11, 0];
for(var i=0; i<arr.length; i++)	b.insert(arr[i]);


function findAncestor(b, k1, k2){
	var n = b.root;
	while(n != null){
		if(n.key >= k1 && n.key <= k2){
			return n.key;
		} else if(n.key <= k1 && n.key >= k2){
			return n.key;
		} else if(n.key <= k1 && n.key <= k2){
			n = n.right;
		} else if(n.key >= k1 && n.key >= k2){
			n = n.left;
		}
	}
	return n.key;
}

console.log(findAncestor(b, 54, 11));