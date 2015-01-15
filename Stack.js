function Stack(){
	this.dataStore = [];
	this.top = 0;
	this.push = push;
	this.pop = pop;
	this.peek = peek;
	this.toString = toString;
	this.length = length;
	this.empty = empty;
}
function push(element){	
	this.dataStore[this.top++] = element;
}
function pop(){
	if(!this.empty()) return this.dataStore[--this.top];
	return false;
}
function peek(){
	if(!this.empty()) return this.dataStore[this.top-1];
	return false;
}
function toString(){
	var result = "";
	for(var i=0; i<this.dataStore.length; i++){
		result += this.dataStore[i] + "\n";
	}
	return result;
}
function length(){
	return this.top;
}
function empty(){
	if(this.top == 0) return true;
	else return false;
}

module.exports = Stack;