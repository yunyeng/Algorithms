import java.util.*;
class QueueWithMax<Item> {
	
	public Queue<Integer> q;
	public Deque<Integer> d;
	
	public QueueWithMax(){
		q = new Queue<>();
		d = new Deque<>();
	}
	
	public void enqueue(int i){
		q.enqueue(i);
		while(!d.isEmpty() && (int) d.peekBack() <= i){
			d.dequeueBack();
		}
		d.enqueueBack(i);
	}
	
	public int dequeue(){
		int i = (int) q.dequeue();
		if(i == (int) d.peekFront()){
			d.dequeueFront();
		}
		return i;
	}
	
	public int max(){
		return (int) d.peekFront();
	}
	
	public static void main(String[] args) {
		QueueWithMax qm = new QueueWithMax();
		qm.enqueue(5);
		qm.enqueue(2);
		qm.enqueue(3);
		qm.enqueue(99);
		qm.enqueue(20);
		qm.enqueue(8);
		qm.enqueue(4);
		qm.enqueue(54);
		qm.enqueue(1);
		qm.enqueue(0);
		qm.enqueue(-2);
		qm.enqueue(1);
		qm.enqueue(54);
		qm.enqueue(-2);
		
		System.out.println(qm.max());
		
		System.out.println(qm.dequeue());
		System.out.println(qm.dequeue());
		System.out.println(qm.dequeue());
		System.out.println(qm.dequeue());
		System.out.println(qm.dequeue());
		
		System.out.println(qm.max());

		System.out.println(qm.dequeue());
		System.out.println(qm.max());
		
	}
}