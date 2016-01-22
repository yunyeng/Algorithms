class SimpleHeap {
	
	private int maxSize;
	private int size;
	private int[] arr;
	
	public SimpleHeap(int s){
		maxSize = s;
		size = 0;
		arr = new int[s];
	}
	
	public void addAll(int[] a){
		if(a.length <= maxSize){
			for(int i=0; i<a.length; i++)
				insert(a[i]);
		}
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == maxSize;
	}
	
	public int min(){
		return arr[0];
	}
	
	public int insert(int a){
		if(isFull())
			return -1;
		arr[size] = a;
		trickleUp(size++);
		return size;
	}
	
	public void trickleUp(int index){
		int bottom = arr[index];
		int parent = (index - 1) / 2;
		while(index > 0 && bottom < arr[parent]){
			arr[index] = arr[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		arr[index] = bottom;
	}
	
	public void trickleDown(int index){
		int top = arr[index];
		int left;
		int right;
		int smaller;
		while(index < size / 2){
			left = 2 * index + 1;
			right =  2 * index + 2;
			if(right < size && arr[left] > arr[right]){
				smaller = right;
			} else {
				smaller = left;
			}
			if(top <= arr[smaller])
				break;
			arr[index] = arr[smaller];
			index = smaller;
		}
		arr[index] = top;
	}
	
	public int delete(){
		int root = arr[0];
		arr[0] = arr[--size];
		trickleDown(0);
		return root;
	}
	
	public static void main(String[] args) {
		
	}
}