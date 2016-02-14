class asdasdasd {
	
//	public static LLists.Node reverse(LLists.Node h){
//		if(h == null || h.next == null)
//			return h;
//		LLists.Node newHead = reverse(h.next);
//		h.next.next = h;
//		h.next = null;
//		return newHead;
//	}
	
	public static LLists.Node reverse(LLists.Node n){
		LLists.Node current = n, prev = null;
		while(current != null){
			LLists.Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LLists<Integer> l = new LLists<>();
		l.insert(3);
		l.insert(5);
		l.insert(8);
		l.insert(21);
		l.insert(100);
		l.insert(200);
		System.out.println(l.show());
		l.head = reverse(l.head);
		LLists.Node n = l.head;
		while(n != null){
			System.out.print(n.key + ", ");
			n = n.next;
		}
	}
}