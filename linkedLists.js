function Node(key){
	this.key = key;
	this.next = null;
	this.prev = null;
}
function LLists(){
	this.head = new Node("head");
	this.length = 0;
	this.insert = insert;
	this.insertAfter = insertAfter;
	this.find = find;
	this.remove = remove;
	this.show = show;
}
function insert(key){
	var newNode = new Node(key);
	var currNode = this.head;
	this.length++;
	while(currNode.next != null){
		currNode = currNode.next;
	}
	newNode.next = currNode.next;
	currNode.next = newNode;
	newNode.prev = currNode;
}
function insertAfter(key, after){
	var newNode = new Node(key);
	var currNode = this.find(after);
	this.length++;
	newNode.next = currNode.next;
	currNode.next = newNode;
	newNode.prev = currNode;
}
function find(key){
	var node = this.head;
	while(node.key != key){
		node = node.next;
	}
	return node;
}
function remove(key){
	var node = this.find(key);
	if(!(node.next == null)){
		node.prev.next = node.next;
		node.next.prev = node.previous;
		node.next = null;
		node.prev = null;
	}
}
function show(){
	var node = this.head.next;
	var result = "";
	while(node != null){
		result += node.key;
		if(node.next != null) result += " -> ";
		node = node.next;
	}
	return result;
}

module.exports = LLists;