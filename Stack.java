class Stack<Item> {

	class Node<Item>{
		Item key;
		Node next;
		Node prev;
		public Node(Item key){
			this.key = key;
		}
	}
	
	Node<Integer> head = new Node<Integer>(0);
	Node<Integer> tail = new Node<Integer>(0);
	int length = 0;
	
	public Stack(){
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	
	public void push(Item key){
		Node node = new Node(key);
		node.prev = this.tail.prev;
		this.tail.prev.next = node;
		this.tail.prev = node;
		node.next = this.tail;
		this.length++;
	}
	
	public Node pop(){
		Node node = this.tail.prev;
		this.tail.prev = this.tail.prev.prev;
		this.tail.prev.next = this.tail;
		this.length--;
		return node;
	}
	
	public Node peek(){
		return this.tail.prev;
	}
	
	public boolean empty(){
		return this.head.next == this.tail;
	}

}