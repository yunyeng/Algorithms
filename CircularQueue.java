class CircularQueue {
	
	private int head;
	private int tail;
	private int size;
	private int maxSize;
	private int[] arr;
	
	public CircularQueue(int s){
		maxSize = s;
		arr = new int[s];
		size = 0;
		head = 0;
		tail = 0;
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public void enqueue(int a){
		if(tail + 1 == head)
			return;
		arr[tail] = a;
		tail = (tail + 1) % maxSize;
		size++;
	}
	
	public int front(){
		if(isEmpty())
			return -1;
		return arr[head];
	}
	
	public int back(){
		if(isEmpty())
			return -1;
		return arr[tail-1];
	}
	
	public int dequeue(){
		if(isEmpty())
			return -1;
		int q = arr[head];
		head = (head + 1) % maxSize;
		size--;
		return q;
	}
	
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(10);
		cq.enqueue(5);
		cq.enqueue(4);
		cq.enqueue(3);
		cq.enqueue(2);
		cq.enqueue(1);
		cq.dequeue();
		System.out.println(cq.front());
		System.out.println(cq.back());
	}
}