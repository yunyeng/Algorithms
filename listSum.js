function Node(key){
	this.key = key;
	this.next = null;
	this.prev = null;
}
function LList(){
	this.head = new Node("head");
	this.insert = insert;
	this.length = 0;
	this.show = show;
}
function insert(key){
	var node = new Node(key);
	var currNode = this.head;
	while(currNode.next != null){
		currNode = currNode.next;
		this.length++;
	}
	currNode.next = node;
}
function show(){
	var node = this.head.next;
	var result = "";
	while(node != null){
		result += node.key;
		if(node.next != null) result += " -> ";
		node = node.next;
	}
	return result;
}

var list1 = new LList();
var list2 = new LList();
var newList = new LList();

list1.insert(7);
list1.insert(1);
list1.insert(6);
list1.insert(5);

list2.insert(9);
list2.insert(1);
list2.insert(2);

var node1 = list1.head.next;
var node2 = list2.head.next;
var sum = 0;
var excess = 0;
while(node1 != null || node2 != null){
	if(node1 == null)		sum = node2.key;
	else if(node2 == null) sum = node1.key;
	else 						sum = node1.key + node2.key;
	if(excess > 0){
		sum += excess;
		excess = 0;
	}
	if(sum > 9){
		excess++;
		sum -= 10;
	}
	newList.insert(sum);
	if((node1.next == null || node2.next == null) && excess > 0) newList.insert(excess);
	if(node1 != null) node1 = node1.next;
	if(node2 != null) node2 = node2.next;
}

console.log(newList.show());