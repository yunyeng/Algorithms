function Heap(a){
	this.dataStore = a;
	this.N = a.length-1;
	this.find = find;
	this.sort = sort;
	this.build = build;
	this.maxHeapify = maxHeapify;
	this.swap = swap;
	this.erase = erase;
	this.length = length;
	this.show = show;
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
function show(){
	var result = "";
	for(var i=0; i<=this.N; i++){
		result += this.dataStore[i] + "\n";
	}
	return result;
}

var h = new Heap([5, 3, 17, 10, 84, 19, 6, 22, 9]);
//h.sort();
console.log(h.dataStore);
h.erase(1);
//h.sort();
console.log(h.dataStore);