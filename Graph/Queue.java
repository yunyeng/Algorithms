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
	int size;
	
	public Queue(){
		this.head.next = this.tail;
		this.tail.prev = this.head;
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean enqueue(Item key){
		Node n = new Node(key);
		this.tail.prev.next = n;
		n.prev = this.tail.prev;
		n.next = this.tail;
		this.tail.prev = n;
		size++;
		return true;
	}
	
	public Node dequeue(){
		Node temp = this.head.next;
		this.head.next = this.head.next.next;
		this.head.next.prev = this.head;
		size--;
		return temp;
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
	}
}