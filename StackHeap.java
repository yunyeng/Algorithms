class StackHeap {
	
	int size;
	int maxSize;
	Node[] arr;
	
	class Node {
		int val;
		int key;
		public Node(int v, int k){
			val = v;
			key = k;
		}
	}
	
	public StackHeap(int s){
		maxSize = s;
		size = 0;
		arr = new Node[s];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == maxSize;
	}
	
	public boolean push(int v){
		if(!isFull()){
			Node n = new Node(v, size+1);
			insert(n);
			return true;
		}
		return false;
	}
	
	public int pop(){
		if(isEmpty())
			return -1;
		return delete();
	}
	
	public int peek(){
		if(isEmpty())
			return -1;
		return max();
	}
	
	public boolean insert(Node n){
		if(isFull())
			return false;
		arr[size] = n;
		trickleUp(size++);
		return true;
	}
	
	public void trickleUp(int index){
		Node bottom = arr[index];
		int parent = (index - 1) / 2;
		while(index > 0 && bottom.key > arr[parent].key){
			arr[index] = arr[parent];
			index = parent;
			parent = (parent-1) / 2;
		}
		arr[index] = bottom;
	}
	
	public int max(){
		return arr[0].val;
	}
	
	public int delete(){
		Node top = arr[0];
		arr[0] = arr[--size];
		trickleDown(0);
		return top.val;
	}
	
	public void trickleDown(int index){
		Node top = arr[0];
		int left, right, larger;
		while(index < size / 2){
			left = 2 * index + 1;
			right = 2 * index + 2;
			if(right < size && arr[left].key < arr[right].key)
				larger = right;
			else
				larger = left;
			if(arr[index].key > arr[larger].key)
				break;
			arr[index] = arr[larger];
			index = larger;
		}
		arr[index] = top;
	}
	
	public static void main(String[] args) {
		StackHeap sh = new StackHeap(10);
		sh.push(10);
		sh.push(2);
		sh.push(3);
		sh.push(7);
		sh.push(1);
		sh.push(0);
		sh.push(54);
		System.out.println(sh.peek());
		sh.pop();
		System.out.println(sh.peek());
		sh.pop();
		System.out.println(sh.peek());
	}
}