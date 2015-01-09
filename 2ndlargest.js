//Write a function to find the 2nd largest element in a binary search tree

var BST = require('./BST.js');
var b = new BST();

for(var i=0; i<100; i++) b.insert(Math.floor(Math.random() * 100));

b.inOrder(b.root);

console.log("--------------------");

var max = b.maximum(b.root);
var preMax = b.predecessor(max);

console.log(preMax.key);