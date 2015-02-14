var Stack = require('./Stack.js');
var inbox = new Stack();
var outbox = new Stack();

function enqueue(element){
	inbox.push(element);
}
function dequeue(){
	if(outbox.empty()){
		while(!inbox.empty()){
			outbox.push(inbox.pop());
		}
	}
	return outbox.pop();
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