import java.util.*;
class Sets<Item> {
	
	private ArrayList<Item> set = new ArrayList<Item>();
	public int size = 0;
	
	public boolean add(Item data){
		if(!set.contains(data)){
			set.add(data);
			size++;
			return true;
		}
		return false;
	}
	public boolean remove(Item data){
		if(set.contains(data)){
			set.remove(data);
			size--;
			return true;
		}
		return false;
	}
	public boolean contains(Item element){
		for(int i=0; i<size; i++){
			if(set.get(i) == element){
				return true;
			}
		}
		return false;
	}
	public Item get(int index){
		return set.get(index);
	}

	public boolean subset(Sets set2){
		if(size > set2.size){
			return false;
		}
		for(int i=0; i<size; i++){
			if(!set2.contains(get(i))){
				return false;
			}
		}
		return true;
	}
	public Sets<Item> union(Sets set2){
		Sets<Item> union = new Sets<Item>();
		for(int i=0; i<size; i++){
			union.add(get(i));
		}
		for(int i=0; i<set2.size; i++){
			if(!union.contains((Item) set2.get(i))) union.add((Item) set2.get(i));
		}
		return union;
	}
	
	public Sets<Item> intersect(Sets set2){
		Sets<Item> intersect = new Sets<Item>();
		for(int i=0; i<size; i++){
			if(set2.contains((Item) get(i))) intersect.add((Item) get(i));
		}
		return intersect;
	}
	public Sets<Item> difference(Sets set2){
		Sets<Item> difference = new Sets<Item>();
		for(int i=0; i<size; i++){
			if(!set2.contains((Item) get(i))) difference.add((Item) get(i));
		}
		return difference;
	}
	public void show(){
		for(int i=0; i<size; i++){
			System.out.print(get(i) + ", ");
		}
	}
	
	public static void main(String[] args) {
		
		Sets<Integer> set1 = new Sets<Integer>();
		Sets<Integer> set2 = new Sets<Integer>();
		
		set1.add(1);
		set1.add(3);
		set1.add(8);
		set1.add(12);
		set1.add(5);
		set1.add(4);
		set1.add(99);
		set1.add(100);
		
		set2.add(3);
		set2.add(1);
		set2.add(12);
		set2.add(99);
		set2.add(98);
		
		Sets<Integer> union = set1.union(set2);
		Sets<Integer> intersect = set1.intersect(set2);
		Sets<Integer> difference = set2.difference(set1);
		
		intersect.show();
	}
}