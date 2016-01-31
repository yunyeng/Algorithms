import java.util.*;
class SmallestSubarray {
	
	private static class Subarray {
		int start;
		int end;
		public Subarray(){
			start = 0;
			end   = Integer.MAX_VALUE;
		}
	}
	
	public static Subarray smallestSequential(List<String> paragraph, List<String> keywords){
		HashMap<String, Integer> freqs = new HashMap<>();
		Subarray result = new Subarray();
		int left = 0, right = 0, index = 0;
		while(right < paragraph.size()){
			while(right < paragraph.size() && freqs.size() < keywords.size() && index < keywords.size()){
				if(keywords.get(index).equals(paragraph.get(right))){
					Integer count = freqs.get(paragraph.get(right));
					if(count == null)
						count = 0;
					freqs.put(paragraph.get(right), ++count);
					index++;
				}
				right++;
			}
			
			if(freqs.size() == keywords.size() && right - left - 1 < result.end - result.start){
				result.start = left;
				result.end   = right -1;
			}
			index = 0;
			while(left < right && freqs.size() == keywords.size() && index < keywords.size()){
				if(keywords.get(index).equals(paragraph.get(left))){
					Integer count = freqs.get(paragraph.get(left));
					freqs.put(paragraph.get(left), --count);
					if(count == 0){
						freqs.remove(paragraph.get(left));
						if(right - left -1 < result.end - result.start){
							result.start = left;
							result.end   = right -1;
						}
					}
					index++;
				}
				left++;	
			}
			index = 0;
		}
		return result;	
	}
	
	public static Subarray smallest(List<String> paragraph, Set<String> keywords){
		HashMap<String, Integer> freqs = new HashMap<>();
		Subarray result = new Subarray();
		int left = 0, right = 0;
		while(right < paragraph.size()){
			while(right < paragraph.size() && freqs.size() < keywords.size()){
				if(keywords.contains(paragraph.get(right))){
					Integer count = freqs.get(paragraph.get(right));
					if(count == null)
						count = 0;
					freqs.put(paragraph.get(right), ++count);
				}
				right++;
			}
			
			if(freqs.size() == keywords.size() && right - left - 1 < result.end - result.start){
				result.start = left;
				result.end   = right -1;
			}
			
			while(left < right && freqs.size() == keywords.size()){
				if(keywords.contains(paragraph.get(left))){
					Integer count = freqs.get(paragraph.get(left));
					freqs.put(paragraph.get(left), --count);
					if(count == 0){
						freqs.remove(paragraph.get(left));
						if(right - left -1 < result.end - result.start){
							result.start = left;
							result.end   = right -1;
						}
					}
				}
				left++;	
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<String> paragraph = new ArrayList<>();
//		Collections.addAll(paragraph, "My", "Paramount", "object", "in", "this", "struggle", "is", "to", "save", "the", "union", ",and", "is", "not", "either", "to", "save", "or", "to", "destroy", "slavery.");
//		Set<String> keywords = new HashSet<>();
//		keywords.add("save");
//		keywords.add("union");
		
		Collections.addAll(paragraph, "apple", "banana", "cat", "apple");
		List<String> keywords = new ArrayList<>();
		keywords.add("banana");
		keywords.add("apple");
		
//		Subarray res = smallest(paragraph, keywords);
		Subarray res = smallestSequential(paragraph, keywords);
		System.out.println(res.start + ", " + res.end);

	}
}