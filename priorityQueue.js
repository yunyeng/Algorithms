function Heap(a){
	this.dataStore = a;
	this.N = a.length-1;
	this.find = find;
	this.sort = sort;
	this.build = build;
	this.build2 = build2;
	this.maxHeapify = maxHeapify;
	this.swap = swap;
	this.heapMax = heapMax;
	this.extractMax = extractMax;
	this.increaseKey = increaseKey;
	this.insert = insert;
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
function heapMax(){
	return this.dataStore[0];
}
function extractMax(){
	if(this.N < 0) throw "Heap underflow!";
	var max = this.dataStore[0];
	this.dataStore[0] = this.find(this.N);
	this.N--;
	this.maxHeapify(0);
	return max;
}
function increaseKey(i, key){
	if(key < this.find(i)) throw "New key is smaller than current key.";
	this.dataStore[i] = key;
	while(i > 0 && this.find(parent(i)) > this.find(i)){
		this.swap(i, parent(i));
		i = parent(i);
	}
}
function insert(key){
	this.N++;
	this.dataStore[this.N] = Number.NEGATIVE_INFINITY;
	this.increaseKey(this.N, key);
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
function build2(){
	this.N = 0;
	for(var i=1; i<this.length();i++) this.insert(this.dataStore[i]);
}
function sort(A){
	this.build();
	for(var i=this.length()-1; i>=1; i--){
		this.swap(0, i);
		this.N--;
		this.maxHeapify(0);
	}
}

var h = new Heap([1,2,3,4,5,6]);
//h.insert(102)
h.build();
console.log(h.dataStore);
h.build2();
console.log(h.dataStore);