class SimpleStack {
	
	private int[] arr;
	private int size;
	public int maxSize;
	
	public SimpleStack(int s){
		maxSize = s;
		size = 0;
		arr = new int[s];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void reScale(){
		double factor = (double) size / maxSize;
		if(factor > 0.75){
			int[] newArr = new int[2 * maxSize];
			for(int i=0; i<size; i++)
				newArr[i] = arr[i];
			arr = newArr;
			maxSize *= 2;
		}
	}
	
	public void push(int a){
		arr[size++] = a;
		reScale();
	}
	
	public int peek(){
		if(!isEmpty())
			return arr[size - 1];
		else
			return -1;
	}
	
	public int pop(){
		if(!isEmpty())
			return arr[--size];
		else
			return -1;
	}
	
	public static void main(String[] args) {
		SimpleStack s = new SimpleStack(10);
	}
}