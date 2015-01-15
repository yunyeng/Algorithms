function Stack(){
	this.dataStore = [];
	this.top = 0;
	this.push = push;
	this.pop = pop;
	this.peek = peek;
	this.isEmpty = isEmpty;
}
function push(element){
	var s = new Stack();
	while(this.peek() > element) s.dataStore[s.top++] = this.pop();
	this.dataStore[this.top++] = element;
	while(!s.isEmpty()) this.dataStore[this.top++] = s.dataStore[--s.top];
}
function pop(){
	return this.dataStore[--this.top];
}
function peek(){
	return this.dataStore[this.top-1];
}
function isEmpty(){
	if(this.top === 0) return true;
	else return false;
}

var s = new Stack();
s.push(19);
s.push(1);
s.push(3);
s.push(2);
s.push(25);
s.push(11);
s.push(18);
s.push(7);
s.push(4);
s.push(9);


console.log(s.dataStore);