class Heaps {
	
	public Node[] arr;
	private int size;
	private int max;
	
	class Node{
		private int data;
		public Node(int d){
			data = d;
		}
		public void set(int d){
			data = d;
		}
		public int get(){
			return data;
		}
	}
	
	public Heaps(int s){
		max = s;
		size = 0;
		arr = new Node[s];
	}
	
	public boolean insert(int key){
		if(size == max)
			return false;
		arr[size] = new Node(key);
		trickleUp(size);
		size++;
		return true;
	}
	
	public Node delete(){
		Node temp = arr[0];
		arr[0] = arr[--size];
		trickleDown(0);
		return temp;
	}
	
	public void trickleDown(int index){
		Node top = arr[index];
		int larger;
		while(index < size / 2){
			int left  = 2 * index + 1;
			int right = 2 * index + 2;
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
	
	public void trickleUp(int index){
		Node bottom = arr[index];
		int parent = (index - 1) / 2;
		while(index > 0 && bottom.get() > arr[parent].get()){
			arr[index] = arr[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		arr[index] = bottom;
	}
	
	public Node max(){
		return arr[0];
	}
	
	public static void main(String[] args) {
		Heaps h = new Heaps(8);
		h.insert(25);
		h.insert(33);
		h.insert(50);
		h.insert(12);
		h.insert(1);
		h.insert(5);
		h.insert(92);
		h.insert(500);
		
		System.out.println(h.max().get());
		
		h.delete();
		
		System.out.println(h.max().get());
		
	}
}