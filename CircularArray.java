import java.util.*;
class CircularArray<Item> {
	
	public ArrayList<Item> list = new ArrayList<Item>();
	public int size = 0;
	
	/*
	public ArrayList<Item> CircularArray(){
		return list;
	}
	*/
	
	public void add(Item i){
		list.add(i);
		size++;
	}
	
	public void remove(Item i){
		list.remove(i);
		size--;
	}
	
	public void rotate(int x){
		for(int i=0; i<x; i++)
			rotateByOne();
	}
	
	private void rotateByOne(){
		int i;
		Item temp = list.get(size-1);
		for(i=size-1; i>0; i--)
			list.set(i, list.get(i-1));
		list.set(i, temp);
	}
	
	public void show(){
		for(int i=0; i<size; i++)
			System.out.print(list.get(i) + ", ");
	}
	
	public static void main(String[] args) {
		CircularArray<Integer> c = new CircularArray<Integer>();
		c.add(2);
		c.add(5);
		c.add(12);
		c.add(1);
		c.add(8);
		c.add(24);
		c.add(0);
		
		c.rotate(2);
		
		//c.show();
		
		ArrayList circularArray = c.list;
		
		for(Object i : circularArray){
			System.out.println(i);
		}
		
	}
}