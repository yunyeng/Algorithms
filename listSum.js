var LLists = require('./linkedLists.js');

var list1 = new LLists();
var list2 = new LLists();
var newList = new LLists();

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