import java.util.*;
class HashTableau {
	
	private LinkedList<Integer>[] table;
	private int size;
	private int maxSize;
	
	public HashTableau(int s){
		size = 0;
		maxSize = s;
		table = new LinkedList[s];
		for(int i=0; i<s; i++)
			table[i] = new LinkedList<>();
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == maxSize;
	}
	
	private int hash(String s){
		int hash = s.charAt(0) - 96;
		for(int i=1; i<s.length(); i++){
			int letter = s.charAt(i) - 96;
			hash = (hash * 27 + letter) % maxSize;
		}
		return hash;
	}
	
	public void insert(String key, int val){
		if(isFull())
			return;
		int index = hash(key);
		table[index].add(val);
	}
	
	public int remove(String key){
		if(isEmpty())
			return 0;
		int index = hash(key);
		table[index].remove()
	}
	
	public static void main(String[] args) {
		
	}
}