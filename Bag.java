import java.util.ArrayList;
public class Bag<Item> {
	
	private int size = 0;
	private ArrayList<Item> arr = new ArrayList<Item>();
	
	public void add(Item item){
		arr.add(item);
		size++;
	}
	
	public boolean isEmpty(){
		if(size == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		Bag<Integer> bag = new Bag<Integer>();
		bag.add(3);
		bag.add(5);
		bag.add(8);
		bag.add(10);
		System.out.println(bag.size());
	}
}