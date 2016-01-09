class QueueTest {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(16);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(21);
		q.enqueue(88);
		q.enqueue(-121);
		q.enqueue(4);
		System.out.println(q.show());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q.show());
	}
}