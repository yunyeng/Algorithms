import java.util.*;
class Radix {
	public static void main(String[] args) {
		
		LinkedList[] lists = new LinkedList[10];
		
		for(int i=0; i<10; i++){
			lists[i] = new LinkedList<Integer>();
		}
		
		int[] arr = {421, 240, 35, 532, 305, 430, 124};
		
		for(int i=0; i<arr.length; i++)
			lists[arr[i] % 10].add(arr[i]);
		for(int i=0; i<10; i++)
			lists[i] = new LinkedList<Integer>();
		for(int i=0; i<arr.length; i++)
			lists[(arr[i] / 10) % 10].add(arr[i]);
		for(int i=0; i<10; i++)
			lists[i] = new LinkedList<Integer>();
		for(int i=0; i<arr.length; i++)
			lists[(arr[i] / 100) % 10].add(arr[i]);
		int j = 0;
		int k = 0;
		for(int i=0; i<10; i++){
			while(!lists[i].isEmpty()){
//				System.out.println(lists[i].removeFirst());
				arr[j++] = (int) lists[i].removeFirst();
			}
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
	}
}