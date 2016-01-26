import java.util.*;
class LetterAndMagazine {
	
	public static boolean isPossible(String letter, String magazine){
		HashMap<Character, Integer> h = new HashMap<>();
		for(int i=0; i<letter.length(); i++){
			if(h.get(letter.charAt(i)) == null)
				h.put(letter.charAt(i), 1);
			else
				h.put(letter.charAt(i), h.get(letter.charAt(i)) + 1);
		}
		for(int i=0; i<magazine.length(); i++){
			if(h.get(magazine.charAt(i)) == null)
				continue;
			h.put(magazine.charAt(i), h.get(magazine.charAt(i)) - 1);
			if(h.get(magazine.charAt(i)) == 0){
				h.remove(magazine.charAt(i));
				if(h.isEmpty())
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String l = "Halil Pazarlama";
		String m = "Halil Pazarlama, Halil Pazarlama, Halil Pazarlama Kapinizdaaaaaaaaa";
		System.out.println(isPossible(l, m));
	}
}