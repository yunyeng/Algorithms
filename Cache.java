import java.util.*;
class Cache {
	
	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	private int size;
	
	public Cache(int s){
		size = s;
		map = new HashMap<>();
	}
	
	private class Node{
		Node next;
		Node prev;
		int key;
		String value;
		
		public Node(int k, String v){
			key = k;
			value = v;
		}
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
	
	public void remove(int key){
		Node n = map.get(key);
		if(n == null)
			return;
		removeNode(n);
		map.remove(key);
	}
	
	public void removeNode(Node n){
		if(head == n)
			head = head.next;
		if(tail == n)
			tail = tail.prev;
		if(n.next != null)
			n.next.prev = n.prev;
		if(n.prev != null)
			n.prev.next = n.next;
	}
	
	public void set(int key, String value){
		remove(key);
		if(map.size() >= size)
			remove(tail.key);
		Node n = new Node(key, value);
		insertAtFront(n);
		map.put(key, n);
	}
	
	public String get(int key){
		Node n = map.get(key);
		if(n == null)
			return null;
		if(n != head){
			removeNode(n);
			insertAtFront(n);
		}
		return n.value;
	}

	
	public static void main(String[] args) {
		Cache c = new Cache(5);
		c.set(1, "Yunus");
		c.set(2, "Mustafa");
		c.set(3, "Emre");
		c.set(4, "Osman Jr");
		c.set(5, "Kamil");
		
		System.out.println(c.get(1));
		
		
		c.set(6, "Murtaza");
		
		System.out.println(c.get(1));
	}
}