class HT {
	
	class Node {
		String key;
		String val;
		public Node(String k, String v){
			key = k;
			val = v;
		}
	}
	
	private LLists<Node>[] arr;
	private int size;
	
	public HT(int s){
		size = s;
		arr = new LLists[s];
		for(int i=0; i<s; i++)
			arr[i] = new LLists<>();
	}
	
	public int hash(String key){
		int hashVal = key.charAt(0) - 96;
		for(int i=1; i<key.length(); i++){
			int letter = key.charAt(i) - 96;
			hashVal = (hashVal * 27 + letter) % size;
		}
		return hashVal;
	}
	
	public void insert(Node item){
		arr[hash(item.key)].insert(item);
	}
	
	public void delete(Node item){
		LLists l = arr[hash(item.key)];
		arr[hash(item.key)].remove(item);
	}
	
	public Node find(String key){
		
	}
	
	
	public static void main(String[] args) {
		HT h = new HT(10);
	}
}