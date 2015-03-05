//Q2. given a string, find the length of longest string where no character repeats twice?
import java.util.*;
class LongestString {
	public static String find(String s){
		ArrayList<Character> arr = new ArrayList<Character>();
		int i;
		for(i=0; i<s.length(); i++){
			if(arr.contains(s.charAt(i))){
				break;
			}
			arr.add(s.charAt(i));
		}
		return s.substring(0, i);
	}
	public static void main(String[] args) {
		System.out.print(find("asdfghjklzaxcvbn"));
	}
}