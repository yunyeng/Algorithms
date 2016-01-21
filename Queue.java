class Queue<Item>{
	
	class Node<Item>{
		Node next;
		Node prev;
		Item key;
		public Node(Item key){
			this.key = key;
		}
	}
	
	Node head;
	Node tail;
	int length;
	
	public Queue(){
		head = null;
		tail = null;
		length = 0;
	}
	
	public Item front(){
		return (Item) head.key;
	}
	
	public Item back(){
		return (Item) tail.key;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public Item enqueue(Item key){
		Node n = new Node(key);
		if(head == null){
			head = n;
			tail = head;
		} else {
			n.prev = tail.prev;
			tail.next = n;
			tail = n;
		}
		return (Item) n.key;
	}
	
	public Item dequeue(){
		if(!isEmpty()){
			Item temp = (Item) head.key;
			head = head.next;
//			head.next.prev = head;
			length--;
			return temp;
		}
		return null;
	}
	
	public void print(){
		Node n = this.head;
		n = n.next;
		while(n != tail){
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