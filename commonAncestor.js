var BST = require('./BST');
var b = new BST();
b.insert(3);
b.insert(1);
b.insert(5);
b.insert(9);
b.insert(4);
b.insert(8);
b.insert(21);
b.insert(7);
b.insert(30);

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

var node1 = b.search(b.root, 4);
var node2 = b.search(b.root, 7)
//console.log(node2);
console.log(commonAncestor(node1, node2));