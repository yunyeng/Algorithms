class LLists<Item> {
	
	class Node<Item> {
		public Item key;
		public Node next;
//		public Node prev;
		public Node(Item key){
			this.key = key;
		}
	}
	
	Node head;
	Node tail;
	int length = 0;
	
	public LLists(){
		head = null;
		tail = null;
	}
	
	public LLists.Node newNode(){
		return new Node(null);
	}
	
	public void insert(Item key){
		Node newNode = new Node(key);
		if(head == null){
			head = newNode;
		} else if(tail == null){
			tail = newNode;
			head.next = tail;
//			tail.prev = head;
		} else {
			tail.next = newNode;
//			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public Node find(Item key){
		Node node = this.head;
		while(node.key != key){
			node = node.next;
			if(node == null)
				break;
		}
		return node;
	}
	
	public void insertAfter(Item key, Item after){
		Node currNode = this.find(after);
		Node newNode = new Node(key);
//		currNode.next.prev = newNode;
		newNode.next = currNode.next;
		currNode.next = newNode;
//		newNode.prev = currNode;
	}
	
	public void insertBegin(Item key){
		Node newNode = new Node(key);
//		head.prev = newNode;
		newNode.next = head;
		head = newNode;
	}
	
	public void insertEnd(Item key){
		Node newNode = new Node(key);		tail.next = newNode;
//		newNode.prev = tail.prev;
		tail = newNode;
	}
	
	public void remove(Item key){
		Node node = this.find(key);
		node.key = node.next.key;
		node.next = node.next.next;
//		node.prev.next = node.next;
//		node.next.prev = node.prev;
//		node.next = null;
//		node.prev = null;
	}
	
//	public void removeEnd(){
//		Node node = tail;
////		node.prev.next = null;
////		tail = node.prev;
//	}
	
	public void removeBegin(){
		Node node = head;
//		node.next.prev = null;
		head = node.next;
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
	}
	
}