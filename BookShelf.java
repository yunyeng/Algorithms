import java.util.*;
class BookShelf {
	
	private Stack<String> LRU;
	private HashMap<String, Double> books;
	private int size;
	
	public BookShelf(){
		LRU = new Stack<>();
		books = new HashMap<>();
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public int lookup(String b){
		
	}
	
	public boolean insert(String b, double p){
		if(books.get(b) == null)
			books.put(b, p);
		LRU.push(b);
		return true;
	}
	
	public boolean remove(){
		
	}
	
	public static void main(String[] args) {
		
	}
}