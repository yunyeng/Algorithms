function Stacks(){
	this.top = 0;
	this.topMin = 0;
	this.topMax = 0;
	this.dataStore = [];
	this.minData = [];
	this.maxData = [];
	this.push = push;
	this.pop = pop;
	this.peek = peek;
	this.length = length;
	this.toString = toString;
	this.min = min;
	this.max = max;
}
function push(data){
	this.dataStore[this.top++] = data;
	if(this.topMin == 0 || data < this.minData[this.topMin-1]) this.minData[this.topMin++] = data;
	if(this.topMax == 0 || data > this.maxData[this.topMax-1]) this.maxData[this.topMax++] = data;
}
function pop(){
	if(this.minData[this.topMin-1] == this.peek()) --this.topMin;
	if(this.maxData[this.topMax-1] == this.peek()) --this.topMax;
	return this.dataStore[--this.top];
}
function peek(){
	return this.dataStore[this.top-1];
}
function length(){
	return this.top;
}
function toString(){
	var result = "";
	for(var i=0; i<this.dataStore.length; ++i){
		result += this.dataStore[i] + "\n";
	}
	return result;
}
function min(){
	return this.minData[this.topMin-1];
}
function max(){
	return this.maxData[this.topMax-1];
}

var a = new Stacks();
a.push(3);
a.push(4);
a.push(-1);
a.push(12);
a.push(61);
a.push(21);
a.push(-99);
a.push(5);
a.push(100);
a.push(4);
a.push(-201);
console.log(a.min());
a.pop();
console.log(a.min());
console.log(a.max());
a.pop();
a.pop();
console.log(a.max());