class Queue<Item>{
	
	class Node<Item>{
		Node next;
		Node prev;
		Item key;
		public Node(Item key){
			this.key = key;
		}
	}
	
	Node<String> head = new Node<String>("head");
	Node<String> tail = new Node<String>("tail");
	
	public Queue(){
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	
	public boolean enqueue(Item key){
		Node n = new Node(key);
		this.tail.prev.next = n;
		n.prev = this.tail.prev;
		n.next = this.tail;
		this.tail.prev = n;
		return true;
	}
	
	public boolean dequeue(){
		if(this.head.next != this.tail){
			this.head.next = this.head.next.next;
			this.head.next.prev = this.head;
			return true;
		}
		return false;
	}
	
	public void print(){
		Node n = this.head;
		n = n.next;
		while(n != this.tail){
			System.out.print(n.key + ", ");
			n = n.next;
		}
		System.out.print("\n");
	}
		
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(3);
		q.enqueue(21);
		q.enqueue(15);
		q.enqueue(0);
		q.enqueue(101);
		q.enqueue(8);
		
		q.print();
		q.dequeue();
		q.print();
	}
}