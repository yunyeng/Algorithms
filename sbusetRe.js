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
//----------------------------------------//
b2.insert(4);
b2.insert(8);
b2.insert(21);
b2.insert(7);

function pasOrder(node, basket){
	if(node != null){
		basket.push(node.key);
		pasOrder(node.left);
		pasOrder(node.right);
	}
}


function isSubset(b2){
	
}


//console.log(b1.isSubset(b2));

//b1.preOrder(b1.root);
//console.log();
//b2.preOrder(b2.root);

var basket = [];
pasOrder(b1.root, basket);
console.log(basket);

