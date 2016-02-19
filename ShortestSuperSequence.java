import java.util.*;
class ShortestSuperSequence {
	
	public class Range{
		private int start;
		private int end;
		public Range(int s, int e){
			start = s;
			end   = e;
		}
		public int length(){
			return end - start + 1;
		}
		public int getStart(){
			return start;
		}
		public int getEnd(){
			return end;
		}
		public boolean shorterThan(Range other){
			return length() < other.length();
		}
	}
	
	public static int[] shortestSupersequence(int[] arr, int[] elements){
		List<Queue<Integer>> locations = getLocationsForElements(arr, elements);
		if(locations == null)
			return null;
		return getShortestClosure(locations);
	}
	
	public static List<Queue<Integer>> getLocationsForElements(int[] arr, int[] elements){
		List<Queue<Integer>> locations = new ArrayList<>();
		for(int i=0; i<elements.length; i++){
			Queue<Integer> q = getLocations(arr, elements[i]);
			locations.add(q);
		}
		return locations;
	}
	
	public static Queue<Integer> getLocations(int[] arr, int element){
		Queue<Integer> q = new Queue<>();
		for(int i=0; i<arr.length; i++)
			if(arr[i] == element)
				q.enqueue(i);
		return q;
	}
	
	public static int[] getShortestClosure(List<Queue<Integer>> locations){
		int[] res = new int[2];
		res[0] = 0; res[1] = 100;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Queue<Integer> minQueue = null;
		while(true){
			for(int i=0; i<locations.size(); i++){
				Queue<Integer> q = locations.get(i);
				if(q.isEmpty()){
					locations.remove(i);
					break;
				}
//				System.out.println(q.front());
				if(q.front() < min){
					min = q.front();
					minQueue = q;
				}
				if(q.front() > max){
					max = q.front();
				}
				minQueue.dequeue();
			}
			if((max - min) < (res[1] - res[0])){
				System.out.println(max + " - " + min);
				res[1] = max;
				res[0] = min;
			}
			if(locations.size() < 3)
				return res;
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 7, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
		int[] a   = {1, 5, 9};
		int[] res = shortestSupersequence(arr, a);
		for(int r : res)
			System.out.println(r);
	}
}