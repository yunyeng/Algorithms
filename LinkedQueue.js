function Node(key){
	this.key = key;
	this.next = null;
	this.prev = null;
}
function Queue(){
	this.head = new Node("head");
	this.tail = new Node("tail");
	this.head.next = this.tail;
	this.tail.prev = this.head;
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.empty = empty;
	this.length = 0;
	this.toString = toString;
}
function enqueue(key){
	var newNode = new Node(key);
	this.length++;
	this.tail.prev.next = newNode;
	newNode.prev = this.tail.prev;
	newNode.next = this.tail;
	this.tail.prev = newNode;
}
function dequeue(){
	if(!this.empty){
		var node = this.head.next;
		this.head.next = this.head.next.next;
		this.head.next.prev = this.head;
		return node.key;
	}
	return false;
}
function front(){
	if(!this.empty()) return this.head.next;
	return false;
}
function back(){
	if(!this.empty()) return this.tail.prev;
	return false;
}
function empty(){
	if(this.head.next == this.tail) return true;
	else return false;
}
function toString(){
	if(!this.empty()){
		var currNode = this.head.next;
		var result = "";
		while(currNode.next != null){
			result += currNode.key + "\n";
			currNode = currNode.next;
		}
		return result;
	}
	return false;
}

module.exports = Queue;