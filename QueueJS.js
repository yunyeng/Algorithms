function Queue(){
	this.dataStore = [];
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
	this.dataStore.push(element);
}
function dequeue(){
	this.length--;
	if(!this.empty()) return this.dataStore.shift();
	else return false;
}
function front(){
	if(!this.empty()) return this.dataStore[0];
	else return false;
}
function back(){
	if(!this.empty()) return this.dataStore[this.length-1];
	else return false;	
}
function empty(){
	if(this.length === 0) return true;
	else return false;
}
function toString(){
	if(!this.empty()){
		var result = "";
		for(var i=0; i<this.length; i++){
			result += this.dataStore[i] + "\n";
		}
		return result;
	} else {
		return false;
	}
}
