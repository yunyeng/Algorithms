import java.util.*;
import java.io.*;
class longestUniqueSubarray {
	
	public static int longestBook(String[] arr){
		HashMap<String, Integer> recent = new HashMap<>();
		int longest = 0, result = 0;
		for(int i=0; i<arr.length; i++){
			Integer dup = recent.put(arr[i], i);
			if(dup != null && dup >= longest){
				result = Math.max(result, i - longest);
				longest = dup+1;
			}
		}
		result = Math.max(result, arr.length - longest);
		return result;
	}
	
	public static int contained(List<Integer> arr){
		HashMap<Integer, Boolean> h = new HashMap<>();
		int max = 0, count = 1;
		for(int i=0; i<arr.size(); i++)
			h.put(arr.get(i), true);
		for(int i=0; i<arr.size(); i++){
			if(h.get(arr.get(i)) != null){
				int j = arr.get(i) + 1;
				while(h.get(j) != null){
					count++;
					h.remove(j);
					j++;
				}
				j = arr.get(i) - 1;
				while(h.get(j) != null){
					count++;
					h.remove(j);
					j--;
				}
				h.remove(arr.get(i));
				max = Math.max(max, count);
				count = 1;
			}
		}
		return max;
	}
	
	public static int containedRange(List<Integer> arr){
		Set<Integer> unprocessed = new HashSet<>(arr);
		int max = 0;
		while(!unprocessed.isEmpty()){
			int a = unprocessed.iterator().next();
			unprocessed.remove(a);
			int lowerBound = a - 1;
			while(unprocessed.contains(lowerBound)){
				unprocessed.remove(lowerBound);
				--lowerBound;
			}
			int upperBound = a + 1;
			while(unprocessed.contains(upperBound)){
				unprocessed.remove(upperBound);
				++upperBound;
			}
			max = Math.max(max, upperBound - lowerBound - 1);
		}
		return max;
	}
	
	public static int longest(String[] arr){
		HashMap<String, Integer> h = new HashMap<>();
		int max = 0, same = 0;
		for(int i=0; i<arr.length; i++){
			Integer exist = h.get(arr[i]);
			h.put(arr[i], i);
			if(exist != null && exist >= same){
				max = Math.max(max, i - same);
				same = exist + 1;
			}
		}
		max = Math.max(max, arr.length - same);
		return max;
	}
	
	public static String highScore(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		HashMap<String, PriorityQueue<Integer>> h = new HashMap<>();
		try {
			while(true){
				String name   = (String) ois.readObject();
				Integer score = (Integer) ois.readObject();
				PriorityQueue<Integer> mh = h.get(name);
				if(mh == null){
					mh = new PriorityQueue<>(3);
					mh.add(score);
				} else {
					if(mh.peek() < score){
						if(mh.size() >= 3)
							mh.remove();
						mh.add(score);
					}
				}
				h.put(name, mh);
			}
		} catch(EOFException e){ }
		String res = "";
		int max = 0;
		for(Map.Entry<String, PriorityQueue<Integer>> scores : h.entrySet()){
			if(scores.getValue().size() == 3){
				int sum = getSum(scores.getValue());
				if(sum > max){
					max = sum;
					res = scores.getKey();
				}
			}
		}
		return res;
	}
	
	public static int getSum(PriorityQueue<Integer> mh){
		return mh.remove() + mh.remove() + mh.remove();
	}
		
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(-2);
		arr.add(7);
		arr.add(9);
//		arr.add(8);
		arr.add(1);
		arr.add(2);
		arr.add(0);
		arr.add(-1);
		arr.add(5);
		arr.add(10);
		arr.add(11);
		arr.add(12);
		arr.add(13);
		arr.add(14);
		System.out.println(contained(arr));
		System.out.println(containedRange(arr));
		
		//               0    1    2    3    4    5    6    7    8    9    10   11   12   13   14
//		String[] arr = {"a", "e", "c", "a", "b", "d", "a", "r", "a", "a", "s", "k", "s", "p", "e"};
//		System.out.println(longest(arr));
//		System.out.println(	longestBook(arr));
	}
}