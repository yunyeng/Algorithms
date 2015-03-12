import java.util.*;
class AnagramSort {
	
	public static void sortAnagram(String[] arr){
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for(int i=0; i<arr.length; i++){
			char[] charArray = arr[i].toCharArray();
			Arrays.sort(charArray);
			String a = new String(charArray);
			if(hm.containsKey(a)){
				hm.get(a).add(arr[i]);	
			} else {
				hm.put(a, new ArrayList<String>());
				hm.get(a).add(arr[i]);	
			}
		}
		int j = 0;
		for(Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				arr[j] = entry.getValue().get(i);
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		String[] arr = {"god", "abc", "dog", "cab", "man"};
		sortAnagram(arr);
		for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
		
	}
}