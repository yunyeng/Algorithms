var BST = require('./BST');
var b1 = new BST();
var b2 = new BST();
b1.insert(3);
b1.insert(1);
b1.insert(5);
b1.insert(9);
b1.insert(4);
b1.insert(8);
b1.insert(21);
b1.insert(7);
b1.insert(30);

function commonAncestor(node1, node2){
	var n1 = node1;
	var n2 = node2;
	while(n1 != null){
		n1 = n1.parent;
		while(n2 != null){
			if(n1 === n2) return n1.key;
			n2 = n2.parent;
		}
		n2 = node2;
	}
	return false;
}

var node1 = b1.search(b1.root, 4);
var node2 = b1.search(b1.root, 7)
//console.log(node2);
console.log(commonAncestor(node1, node2));