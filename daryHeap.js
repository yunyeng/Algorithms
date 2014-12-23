function daryHeap(a, d){
	this.dataStore = a;
	this.d = d;
	this.N = a.length-1;
	this.find = find;
	this.parent = parent;
	this.child = child;
	this.sort = sort;
	this.build = build;
	this.maxHeapify = maxHeapify;
	this.swap = swap;
	this.erase = erase;
	this.length = length;
}
function length(){
	return this.dataStore.length;
}
function swap(firstIndex, secondIndex){
	var temp = this.dataStore[firstIndex];
	this.dataStore[firstIndex] = this.dataStore[secondIndex];
	this.dataStore[secondIndex] = temp;
}
function parent(i){
	return Math.ceil((i-this.d)/this.d);
}
function child(i, j){
	return i * this.d + 1 + j;
}
function find(i){
	return this.dataStore[i];
}
function maxHeapify(i){
	var largest = i;
	for(var j=0; j<this.d; j++){
		var child = this.child(i, j);
		if(child <= this.N && this.find(child) > this.find(i)) largest = child;
	}
	if(i != largest){
		this.swap(i, largest);
		this.maxHeapify(largest);
	}
}
function build(){
	for(var i=Math.floor((this.length()-1)/this.d); i>=0; i--) this.maxHeapify(i);
}
function sort(A){
	this.build();
	for(var i=this.length()-1; i>=1; i--){
		this.swap(0, i);
		this.N--;
		this.maxHeapify(0);
	}
}
function erase(i){
	if(this.N < 0) throw "heap underflow";
	this.dataStore[i] = this.dataStore[this.N];
	this.N--;
	this.maxHeapify(i);
}

var h = new daryHeap([5, 3, 17, 10, 84, 19, 6, 22, 9]);
//h.sort();
console.log(h.dataStore);
h.erase(1);
//h.sort();
console.log(h.dataStore);