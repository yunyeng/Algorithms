function heap(a){
	this.dataStore = a;
	this.heapSize = 0;
	this.hSort = hSort;
	this.build = build;
	this.maxHeap = maxHeap;
	this.swap = swap;
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
function maxHeap(i){
	var r = 2*i + 2;
	var l = 2*i + 1;
	var largest = i;
	if(l <= this.heapSize && this.dataStore[l] > this.dataStore[i]) largest = l;
	if(r <= this.heapSize && this.dataStore[r] > this.dataStore[largest]) largest = r;
	if(i != largest){
		this.swap(i, largest);
		this.maxHeap(largest);	
	}
}
function build(){
	this.heapSize = this.length()-1;
	for(var i=Math.floor(this.length()/2); i>=0; i--){
		this.maxHeap(i);
	}
}
function hSort(A){
	this.build();
	for(var i=this.length()-1; i>0; i--){
		this.swap(0, i);
		this.heapSize = this.heapSize - 1;
		this.maxHeap(0);
	}
}

var h = new heap([5, 3, 17, 10, 84, 19, 6, 22, 9]);
h.hSort();
console.log(h.dataStore);