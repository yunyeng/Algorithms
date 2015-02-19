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
b2.insert(9);
b2.insert(8);
b2.insert(7);
b2.insert(21);
b2.insert(30);

function equals(array1, array2) {
	if (!array1 || !array2)	return false;
	if (array1.length != array2.length)	return false;
	for (var i=0; i < array1.length; i++)		if (array1[i] != array2[i]) return false;
	return true;
}   

function inOrder(node, basket){
	if(node != null){
		basket.push(node.key);
		inOrder(node.left, basket);
		inOrder(node.right, basket);
	}
}

function isSubset(littleOne, bigOne){
	var smallBasket = [];
	var basket = [];
	inOrder(littleOne.root, smallBasket);
	var bigStart = bigOne.search(bigOne.root, smallBasket[0]);
	if(bigStart == null) return false;
	inOrder(bigStart, basket);
	console.log(basket);
	console.log("----------");
	console.log(smallBasket);
	return equals(basket, smallBasket);
}

console.log(isSubset(b2, b1));
