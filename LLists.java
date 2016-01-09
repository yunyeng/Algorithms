class LLists<Item> {
	
	class Node<Item> {
		public Item key;
		public Node next;
		public Node prev;
		public Node(Item key){
			this.key = key;
		}
	}
	
	Node<Integer> head = new Node<Integer>(0);
	Node<Integer> tail = new Node<Integer>(0);
	int length = 0;
	
	public LLists(){
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	
	public void insert(Item key){
		Node newNode = new Node(key);
		this.tail.prev.next = newNode;
		newNode.prev = this.tail.prev;
		this.tail.prev = newNode;
		newNode.next = this.tail;
	}
	
	public Node find(Item key){
		Node node = this.head;
		while(node.key != key){
			node = node.next;
		}
		return node;
	}
	
	public void insertAfter(Item key, Item after){
		Node currNode = this.find(after);
		Node newNode = new Node(key);
		currNode.next.prev = newNode;
		newNode.next = currNode.next;
		currNode.next = newNode;
		newNode.prev = currNode;
	}
	
	public void remove(Item key){
		Node node = this.find(key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
	}
	
	public String show(){
		String result = "";
		Node node = this.head.next;
		while(node != this.tail){
			result += node.key + ", ";
			node = node.next;
		}
		return result;
	}
	
	public static void main(String[] args){
		LLists ll = new LLists();
		ll.insert("Bok");
		ll.insert("Cis");
		ll.insert("Sidik");
		ll.insert("Kaka");
		System.out.println(ll.head.next.next.key);
	}
	
}