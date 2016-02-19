import java.util.*;
class kSmallest {
	
	public static class MaxHeap {
		int size;
		int maxSize;
		int[] arr;
		public MaxHeap(int s){
			size = 0;
			maxSize = s;
			arr = new int[s];
		}
		public boolean isEmpty(){
			return size == 0;
		}
		public boolean isFull(){
			return size == maxSize;
		}
		public int max(){
			return arr[0];
		}
		public boolean insert(int a){
			if(isFull())
				return false;
			arr[size] = a;
			moveUp(size++);
			return true;
		}
		public void moveUp(int index){
			int parent = (index-1) / 2;
			int bottom = arr[index];
			while(index > 0 && arr[parent] < bottom){
				arr[index] = arr[parent];
				index = parent;
				parent = (parent-1) / 2;
			}
			arr[index] = bottom;
		}
		public void update(int a){
			arr[0] = a;
			moveDown(0);
		}
		public void moveDown(int index){
			int top = arr[index];
			int larger;
			while(index < size / 2){
				int left = index*2 + 1;
				int right = index*2 + 2;
				if(right < size && arr[right] > arr[left]){
					larger = right;
				} else {
					larger = left;
				}
				if(top >= arr[larger])
					break;
				arr[index] = arr[larger];
				index = larger;
			}
			arr[index] = top;
		}
	}
	
	public static int[] kSmallest(int[] arr, int k){
		MaxHeap m = new MaxHeap(k);
		for(int i=0; i<k; i++)
			m.insert(arr[i]);
		for(int i=k; i<arr.length; i++)
			if(arr[i] < m.max())
				m.update(arr[i]);
		return m.arr;
	}
	
	public static String longestEqualSubarray(String s){
		int count = 0;
		int[] ind = new int[2];
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			if(Character.isLetter(s.charAt(i))){
				count++;
			} else if(Character.isDigit(s.charAt(i))){
				count--;
			}
			if(map.get(count) != null){
				if(i - map.get(count) > max){
					max = i - map.get(count);
					ind[0] = map.get(count);
					ind[1] = i;
				}
			} else {
				map.put(count, i);	
			}
		}
		String a = "";
		for(int i = ind[0]+1; i<= ind[1]; i++)
			a += s.charAt(i);
			
		return a;
	}
	
	public static int missingNum(List<BitInteger> arr){
		return missingNum(arr, 0);
	}
	public static int missingNum(List<BitInteger> arr, int column){
		if(column >= BitInteger.MAX_SIZE)
			return 0;
		
		List<BitInteger> zeroBits = new ArrayList<>(arr.size()/2);
		List<BitInteger> oneBits  = new ArrayList<>(arr.size()/2);
		
		for(BitInteger t : arr){
			if(t.fetch(column) == 0)
				zeroBits.add(t);
			else
				oneBits.add(t);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 0, 12, 21, 99, 5, 4, -13, 44, 54, 65, -20, 23, 78, 92};
		int[] small = kSmallest(arr, 3);
//		for(int a : small)
//			System.out.print(a + " ");
			
		System.out.println(longestEqualSubarray("a1aaaa1aa1a1aa1aaa1a1aa1aa1aa1"));
	}
}