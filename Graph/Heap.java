class Heap {
	
	private Edge[] heapArray;
	private int n;
	private int size;
	
	
	public Heap(int s){
		n = s;
		size = 0;
		heapArray = new Edge[s];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public Edge peekN(int n){
		return heapArray[n];
	}
	
	public int find(int ind){
		for(int i=0; i<size; i++)
			if(heapArray[i].dest == ind)
				return i;
		return -1;
	}
	
	public int size(){
		return size;
	}
	
	public boolean insert(Edge e){
		if(size == n)
			return false;
		heapArray[size] = e;
		trickleUp(size++);
		return true;
	}
	
	public void trickleUp(int index){
		Edge temp = heapArray[index];
		int parent = (index - 1) / 2;
		while(index > 0 && temp.weight < heapArray[parent].weight){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = temp;
	}
	
	public Edge remove(){
		Edge top = heapArray[0];
		heapArray[0] = heapArray[--size];
		trickleDown(0);
		return top;
	}
	
	public Edge remove(int n){
		Edge top = heapArray[n];
		heapArray[n] = heapArray[--size];
		trickleDown(n);
		return top;
	}
	
	public void trickleDown(int index){
		Edge temp = heapArray[index];
		int smaller;
		while(index < size / 2){
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			if(right < size && heapArray[right].weight < heapArray[left].weight)
				smaller = right;
			else
				smaller = left;
			if(heapArray[index].weight <= heapArray[smaller].weight)
				break;
			heapArray[index] = heapArray[smaller];
			index = smaller;
		}
		heapArray[index] = temp;
	}
	
	public static void main(String[] args) {
		
	}
}