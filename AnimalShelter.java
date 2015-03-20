class AnimalShelter {
	
	class Node{
		Node next = null;
		Node prev = null;
		String type;
		String key;
		public Node(String k, String t){
			this.key = k;
			this.type = t;
		}
	}
	
	public Node head;
	public Node tail;
	
	public AnimalShelter(){
		this.head = new Node(null, null);
		this.tail = new Node(null, null);
		head.next = tail;
		tail.prev = head;
	}
	
	public void enqueue(String key, String type){
		Node n = new Node(key, type);
		tail.prev.next = n;
		n.prev = tail.prev;
		tail.prev = n;
		n.next = tail;
	}
	
	public Node dequeueAny(){
		if(head.next != tail){
			Node n = head.next;
			head.next = n.next;
			n.next.prev = head;
			return n;	
		}
		return null;
	}
	
	public Node dequeueDog(){
		if(head.next != tail){
			Node n = head.next;
			while(n.type != "dog"){
				n = n.next;
			}
			return n;
		}
		return null;
	}
	
	public Node dequeueCat(){
		if(head.next != tail){
			Node n = head.next;
			while(n.type != "cat"){
				n = n.next;
			}
			return n;
		}
		return null;
	}
	
	public static void main(String[] args) {
		AnimalShelter anm = new AnimalShelter();
		anm.enqueue("Cesar", "dog");
		anm.enqueue("Klitoris", "cat");
		anm.enqueue("Penis", "cat");
		anm.enqueue("Assa", "dog");
		anm.enqueue("Gregory", "dog");
		anm.enqueue("Norman", "dog");
		anm.enqueue("Hexus", "cat");
		anm.enqueue("Farsi", "dog");
		anm.enqueue("Bogso", "cat");
		anm.enqueue("Cucu", "dog");
		anm.enqueue("Arap", "cat");
		anm.enqueue("Zigir", "dog");
		System.out.println(anm.dequeueAny().key);
		System.out.println(anm.dequeueCat().key);
		System.out.println(anm.dequeueDog().key);
	}
}