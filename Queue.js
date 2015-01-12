function Queue(){
	this.dataStore = [];
	this.head = 0;
	this.tail = 0;
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.empty = empty;
	this.length = 0;
	this.toString = toString;
}
function enqueue(element){
	this.length++;
	this.dataStore[this.tail++] = element;
}
function dequeue(){
	if(!this.empty()) return this.dataStore[this.head++];
	else return false;
}
function front(){
	if(!this.empty()) return this.dataStore[this.head];
	else return false;
}
function back(){
	if(!this.empty()) return this.dataStore[this.tail-1];
	else return false;	
}
function empty(){
	if(this.length === 0) return true;
	else return false;
}
function toString(){
	if(!this.empty()){
		var result = "";
		for(var i=this.head; i<this.tail; i++){
			result += this.dataStore[i] + "\n";
		}
		return result;
	} else {
		return false;
	}
}