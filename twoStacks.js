var Stack = require('./Stack.js');
var s1 = new Stack();
var s2 = new Stack();

function enqueue(element){
	s1.push(element);
}
function dequeue(){
	if(s2.empty()){
		while(!s1.empty()){
			s2.push(s1.pop());
		}
	}
	return s2.pop();
}


enqueue("Ahmet");
enqueue("Mehmet");
enqueue("Ali");
enqueue("Yunus");
enqueue("Kamil");
enqueue("Osman");

console.log(dequeue());
console.log(dequeue());
console.log(dequeue());
console.log(dequeue());
console.log(dequeue());
console.log(dequeue());
console.log(dequeue());