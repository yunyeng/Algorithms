class ListNode {
	
	class Node {
		int key;
		Node next;
		public Node(int key){
			this.key = key;
		}
	}
	Node head = null;
	int length = 0;
	
	public boolean insert(int x){
		Node n = this.head;
		this.length++;
		if(n == null){
			this.head = new Node(x);
			return true;
		}
		while(n.next != null){
			n = n.next;
		}
		n.next = new Node(x);
		return true;
	}
	
	public void print(){
		Node n = this.head;
		while(n != null){
			System.out.println(n.key);
			n = n.next;
		}
	}
	
	public boolean remove(int key){
		Node n = this.head;
		if(n.key == key){
			this.head = n.next;
			return true;
		} else {
			while(n != null){
				if(n.next.key == key){
					n.next = n.next.next;
					return true;
				}
				n = n.next;
			}	
		}
		return false;
	}
	
	public boolean reverse(){
		Node n = null;
		while(this.head != null){
			Node next = this.head.next;
			
		}
	}
	
	
	public static void main(String[] args) {
		ListNode l = new ListNode();
		l.insert(3);
		l.insert(2);
		l.insert(9);
		l.insert(12);
		l.insert(13);
		l.insert(41);
		l.insert(1);
		l.insert(21);
		l.print();
		System.out.println("---------------------");
		l.remove(12);
		l.print();
	}
}