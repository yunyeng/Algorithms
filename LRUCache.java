import java.util.*;
class LRUCache {
	
	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	private int size;
	
	public LRUCache(int s){
		size = s;
		map = new HashMap<>();
	}
	
	class Node {
		private int key;
		private String value;
		Node next;
		Node prev;
		public Node(int k, String v){
			key = k;
			value = v;
		}
	}
	
	public void insert(int key, String value){
		remove(key);
		if(map.size() >= size)
			remove(tail.key);
			
		Node n = new Node(key, value);
		insertAtFront(n);
		map.put(key, n);
	}
	
	public void remove(int key){
		Node n = map.get(key);
		if(n == null)
			return;
		removeNode(n);
		map.remove(key);
	}
	
	public String get(int key){
		Node n = map.get(key);
		if(n == null)
			return null;
		removeNode(n);
		insertAtFront(n);
		return n.value;
	}
	
	public void removeNode(Node n){
		if(n.next != null)
			n.next.prev = n.prev;
		if(n.prev != null)
			n.prev.next = n.next;
	}
	
	public void insertAtFront(Node n){
		if(head == null){
			head = n;
			tail = n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
	}
	
	public static void main(String[] args) {
		
	}
}