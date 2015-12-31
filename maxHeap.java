class maxHeap {
	
	private Node[] arr;
	private int size;
	private int max;
	
	class Node {
		private int data;
		public Node(int d){
			data = d;
		}
		public int get(){
			return data;
		}
		public void set(int d){
			data = d;
		}
	}
	
	public maxHeap(int s){
		max = s;
		size = 0;
		arr = new Node[s];
	}
	
	public boolean insert(int key){
		if(size == max)
			return false;
		arr[size] = new Node(key);
		trickleUp(size++);
		return true;
	}
	
	public void trickleUp(int index){
		Node bottom = arr[index];
		int parent = (index - 1) / 2;
		while(index > 0 && bottom.get() > arr[parent].get()){
			arr[index] = arr[parent];
			index  = parent;
			parent = (parent - 1) / 2;
		}
		arr[index] = bottom;
	}
	
	public Node delete(){
		Node root = arr[0];
		arr[0] = arr[--size];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		Node top = arr[index];
		int larger;
		while(index < size / 2){
			int left  = index * 2 + 1;
			int right = index * 2 + 2;
			if(right < size && arr[right].get() > arr[left].get())
				larger = right;
			else
				larger = left;
			if(arr[index].get() >= arr[larger].get())
				break;
			arr[index] = arr[larger];
			index = larger;
		}
		arr[index] = top;
	}
	
	public Node max(){
		return arr[0];
	}
	
	public void change(int index, int val){
		int oldVal = arr[index].get();
		arr[index] = new Node(val);
		if(oldVal < val)
			trickleUp(index);
		else
			trickleDown(index);
	}
	
	public static void main(String[] args) {
		maxHeap h = new maxHeap(8);
		h.insert(3);
		h.insert(21);
		h.insert(55);
		h.insert(1);
		h.insert(200);
		h.insert(512);
		
		System.out.println(h.max().get());
		
		h.delete();
		
		System.out.println(h.max().get());
		
		h.change(0, 54);
		
		System.out.println(h.max().get());
		
	}
}