function Node(key){
	this.key = key;
	this.parent = null;
	this.left = null;
	this.right = null;
}
function BST(){
	this.root = null;
	this.length = 0;
	this.height = 0;
	this.search = search;
	this.insert = insert;
	this.transplant = transplant;
	this.remove = remove;
	this.successor = successor;
	this.predecessor = predecessor;
	this.maximum = maximum;
	this.minimum = minimum;
	this.preOrder = preOrder;
	this.inOrder = inOrder;
	this.postOrder = postOrder;
}
function search(x, key){
	if(x == null || key == x.key) return x;
	if(key < x.key)	return this.search(x.left, key);
	else				return this.search(x.right, key);
}
function minimum(x){
	while(x.left != null) x = x.left;
	return x;
}
function maximum(x){
	while(x.right != null) x = x.right;
	return x;
}
function successor(x){
	if(x.right != null) return this.minimum(x.right);
	var p = x.parent;
	while(p != null && x == p.right){
		x = p;
		p = p.parent;
	}
	return p;
}
function preOrder(x){
	if(x != null){
		console.log(x.key);
		this.preOrder(x.left);
		this.preOrder(x.right);
	}
}
function inOrder(x){
	if(x != null){
		this.inOrder(x.left);
		console.log(x.key);
		this.inOrder(x.right);
	}
}
function postOrder(x){
	if(x != null){
		this.postOrder(x.left);
		this.postOrder(x.right);
		console.log(x.key);
	}
}
function predecessor(x){
	if(x.left != null) return maximum(x.left);
	var p = x.parent;
	while(p != null && p > x){
		p = p.parent;
	}
	return p;
}
function insert(key){
	var newNode = new Node(key);
	if(this.root == null){
		this.root = newNode;
	} else {
		var x = this.root;
		var y = null;
		while(x != null){
			y = x;
			if(key < x.key)	x = x.left;
			else	x = x.right;
		}
		newNode.parent = y;
		if(y == null) 		 this.root = newNode;
		else if(key < y.key) y.left = newNode;
		else					 y.right = newNode;
	}
	this.length++;
}
function transplant(u, v){
	if(u.parent == null) 		 this.root = v;
	else if(u == u.parent.left) u.parent.left = v;
	else 							 u.parent.right = v;
	if(v != null) 				 v.parent = u.parent;
}
function remove(key){
	var node = this.search(key);
	if(node.left == null){ 			this.transplant(node, node.right); }
	else if(node.right == null){	this.transplant(node, node.left); }
	else {
		var y = this.minimum(node.right);
		if(y.parent != node){
			this.transplant(y, y.right);
			y.right = node.right;
			y.right.parent = y;
		}
		this.transplant(node, y);
		y.left = node.left;
		y.left.parent = y;
	}
}


module.exports = BST;