class HTable {
	
	private int size;
	private Tree[] arr;
	
	class Node{
		private int data;
		public Node(int d){
			data = d;
		}
		public int get(){
			return data;
		}
	}
	
	public HTable(int s){
		size = s;
		arr = new Tree[s];
		for(int i=0; i<size; i++)
			arr[i] = new Tree();
	}
	
	public int hash(int key){
		return key % size;
	}
	
	public void insert(int key){
		int hashVal = hash(key);
		arr[hashVal].insert(key);
	}
	
	public Tree.Node find(int key){
		int hashVal = hash(key);
		return arr[hashVal].find(key);
	}
	
	public void delete(int key){
		int hashVal = hash(key);
		arr[hashVal].delete(key);
	}
	
	public static void main(String[] args) {
		HTable h = new HTable(13);
		h.insert(28);
		h.insert(2);
		h.insert(41);
	}
}