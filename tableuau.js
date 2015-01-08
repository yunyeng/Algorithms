function tableau(a, m, n){
	this.m = m;
	this.n = n;
	if(a.length < m*n){
		for(var i=a.length; i<m*n; i++) a[i] = Number.POSITIVE_INFINITY;
	}
	this.dataStore = a;
	this.N = a.length-1;
	this.size = a.length-1;
	this.find = find;
	this.sort = sort;
	this.build = build;
	this.maxHeapify = maxHeapify;
	this.swap = swap;
	this.length = length;
	this.empty = empty;
	this.full = full;
	this.show = show;
	this.extractMin = extractMin;
	this.insert = insert;
}
function length(){
	return this.dataStore.length;
}
function swap(firstIndex, secondIndex){
	var temp = this.dataStore[firstIndex];
	this.dataStore[firstIndex] = this.dataStore[secondIndex];
	this.dataStore[secondIndex] = temp;
}
function left(i){
	return 2*i + 1;
}
function right(i){
	return 2*i + 2;	
}
function parent(i){
	return Math.floor(i/2);
}
function find(i){
	return this.dataStore[i];
}
function maxHeapify(i){
	var r = right(i);
	var l = left(i);
	var largest = i;
	if(l <= this.N && this.find(l) > this.find(i)) largest = l;
	if(r <= this.N && this.find(r) > this.find(largest)) largest = r;
	if(i != largest){
		this.swap(i, largest);
		this.maxHeapify(largest);
	}
}
function build(){
	for(var i=Math.floor((this.length()-1)/2); i>=0; i--) this.maxHeapify(i);
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
function empty(){
	if(this.find(0) == Number.POSITIVE_INFINITY) return true;
	else return false;
}
function full(){
	if(this.find(this.m*this.n-1) < Number.POSITIVE_INFINITY) return true;
	else return false;
}
function show(){
	var result = "";
	var j = 1;
	for(var i=0; i<this.length(); i++){
		if(i % (this.m) == 0) result += "\n";
		result += this.find(i) + " ";
	}		
	return result;
}
function extractMin(){
	if(this.N < 0) throw "Heap underflow!";
	var min = this.dataStore[0];
	this.dataStore[0] = Number.POSITIVE_INFINITY;
	this.N--;
	this.sort();
	return min;
}
function insert(i, key){
	if(!this.full() && this.find(i) == Number.POSITIVE_INFINITY){
		this.dataStore[i] = key;
		this.sort();
	}
}
var h = new tableau([9, 16, 3, 2, 4, 8, 5, 14, 12], 4, 4);
h.sort();
console.log(h.dataStore);
console.log(h.empty());
console.log(h.full());
console.log(h.show());

console.log(h.extractMin());
console.log(h.show());

h.insert(15, 99);

console.log(h.show());
