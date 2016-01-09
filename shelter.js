function Node(key, type){
	this.key = key;
	this.type = type;
	this.next = null;
	this.prev = null;
}
function Queue(){
	this.head = new Node("head", "any");
	this.tail = new Node("tail", "any");
	this.head.next = this.tail;
	this.tail.prev = this.head;
	this.enqueue = enqueue;
	this.dequeueAny = dequeueAny;
	this.dequeueDog = dequeueDog;
	this.dequeueCat = dequeueCat;
	this.front = front;
	this.back = back;
	this.empty = empty;
	this.length = 0;
	this.toString = toString;
}
function enqueue(key, type){
	var newNode = new Node(key, type);
	this.length++;
	this.tail.prev.next = newNode;
	newNode.prev = this.tail.prev;
	newNode.next = this.tail;
	this.tail.prev = newNode;
}
function dequeueAny(){
	if(!this.empty){
		var node = this.head.next;
		this.length--;
		this.head.next = this.head.next.next;
		this.head.next.prev = this.head;
		return node.key;
	}
	return false;
}
function dequeueDog(){
	var node = this.head.next;
	while(node.type != "Dog"){
		node = node.next;
	}
	node.prev.next = node.next;
	node.next.prev = node.prev;
	this.length--;
	return node;
}
function dequeueCat(){
	var node = this.head.next;
	while(node.type != "Cat"){
		node = node.next;
	}
	node.prev.next = node.next;
	node.next.prev = node.prev;
	this.length--;
	return node;
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


var q = new Queue();
q.enqueue("Lassie", "Dog");
q.enqueue("Whiskers", "Cat");
q.enqueue("Santana", "Cat");
q.enqueue("Orragim", "Cat");
q.enqueue("Kamanchi", "Dog");
q.enqueue("Barky", "Dog");

console.log(q.dequeueDog());
console.log(q.dequeueDog());