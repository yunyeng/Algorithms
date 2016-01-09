class HashTable {
	
	public Node[] arr;
	public int size;
	private int nItems;
	
	class Node{
		private int data;
		public Node(int d){
			data = d;
		}
		public int get(){
			return data;
		}
	}
	
	public HashTable(int s){
		size = s;
		arr = new Node[s];
		nItems = 0;
	}
	
	public void display(){
		for(int i=0; i<size; i++)
			System.out.print(arr[i] + ", ");
	}
	
	private int hash(int key){
		return key % size;
	}
	
	public int getPrime(int n){
		int i = n + 1;
		while(!isPrime(i)){
			i++;
		}
		return i;
	}
	
	public boolean isPrime(int n){
		for(int i=2; i*i<=n; i++)
			if(n % i == 0)
				return false;
		return true;
	}
	
	public void rehash(){
		int s = getPrime(size * 2);
		Node[] a = new Node[s];
		int oldSize = size;
		size = s;
		for(int i=0; i<oldSize; i++){
			if(arr[i] != null)
				a[hash(arr[i].get())] = arr[i];
		}
		arr = a;
	}
	
	private int hash2(String key){
		int s = size / 10;
		int i = 0;
		while(s > 0){i++; s/=10;}
		int k = i;
		int hashVal = 0;
		String nr = "";
		for(int j=0; j<key.length(); j++){
			if(key.charAt(j) != '-'){
				nr += key.charAt(j);
				k--;
			}
			if(k == 0){
				k = i;
				hashVal += Integer.parseInt(nr);
				nr = "";
			}
		}
		if(k > 0) hashVal += Integer.parseInt(nr);
		return hashVal % size;
	}
	
	public void insert(int key){
		float loadFactor = (float) nItems / size;
		if(loadFactor > 0.5) rehash();
		int hashKey = hash(key);
		while(arr[hashKey] != null){
			hashKey = (hashKey + 1) % size;
		}
		arr[hashKey] = new Node(key);
		nItems++;
	}
	
	public Node delete(int key){
		int hashKey = hash(key);
		Node temp = null;
		while(arr[hashKey] != null){
			if(arr[hashKey].get() == key){
				temp = arr[hashKey];
				arr[hashKey] = null;
				break;
			}
			hashKey = (hashKey + 1) % size;
		}
		nItems--;
		return temp;
	}
	
	public Node find(int key){
		int hashKey = hash(key);
		while(arr[hashKey] != null){
			if(arr[hashKey].get() == key){
				return arr[hashKey];
			}
			hashKey = (hashKey + 1) % size;
		}
		return null;
	}
	
	public static void main(String[] args) {
		HashTable h = new HashTable(13);
		h.insert(3);
		h.insert(21);
		h.insert(55);
		h.insert(100);
		h.insert(412);
		h.insert(331);
		h.insert(356);
		h.insert(561);
		System.out.println(h.size);
		System.out.println(h.find(561).get());
	}
}