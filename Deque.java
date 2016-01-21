import java.util.*;
class Deque<Item>{
	
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
	
	public Deque(){
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	
	public void enqueueFront(Item key){
		Node node = new Node(key);
		this.head.next.prev = node;
		node.next = this.head.next;
		this.head.next = node;
		node.prev = this.head;
		length++;
	}
	
	public void enqueueBack(Item key){
		Node node = new Node(key);
		this.tail.prev.next = node;
		node.prev = this.tail.prev;
		node.next = this.tail;
		this.tail.prev = node;
		length++;
	}
	
	public Item dequeueFront(){
		Node node = this.head.next;
		this.head.next = this.head.next.next;
		this.head.next.prev = this.head;
		length--;
		return (Item) node.key;
	}
	
	public Item dequeueBack(){
		Node node = this.tail.prev;
		this.tail.prev = this.tail.prev.prev;
		this.tail.prev.next = this.tail;
		length--;	
		return (Item) node.key;
	}
	
	public Item peekFront(){
		return (Item) this.head.next.key;
	}
	
	public Item peekBack(){
		return (Item) this.tail.prev.key;
	}
	
	public boolean isEmpty(){
		return this.head.next == this.tail;
	}
	
	public static void main(String[] args) {
		
		
	}
}