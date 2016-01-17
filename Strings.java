import java.util.Arrays;
import java.util.*;
class Strings {
	
	public static String convert(String input, int b1, int b2){
		boolean isNegative = false;
		int i = 0;
		int divider = 1;
		int based1 = 0;
		if(input.charAt(0) == '-'){
			isNegative = true;
			i = 1;
		}
		for(int j=input.length()-1; j>=i; j--){
			based1 += ((int) (input.charAt(j) - '0')) * divider;
			divider *= b1;
		}
		StringBuilder output = new StringBuilder();
		while(based1 > 0){
			int remainder = based1 % b2;
			output.append((char) (remainder >= 10 ? 'A' + (remainder - 10) : '0' + remainder));
			based1 /= b2;
		}
		return output.reverse().toString();
	}

	public static int spreadsheet(String s){
		int num = 0;
		for(int i=0; i<s.length(); i++)
			num = (num * 26) + (s.charAt(i) - 'A' + 1);
		return num;
	}
	
	public static String[] lookAndSay(int n){
		String[] output = new String[n];
		output[0] = "1";
		output[1] = "11";
		int count;
		char c;
		for(int i=2; i<n; i++){
			output[i] = new String();
			c = 'a';
			count = 0;
			for(int j=output[i-1].length() - 1; j>0; j--){
				c = output[i-1].charAt(j);
				count++;
				if(c != output[i-1].charAt(j-1)){
					output[i] += Integer.toString(count) + c;
					count = 0;
				}
			}
			if(output[i-1].charAt(1) != output[i-1].charAt(0))
				output[i] += Integer.toString(1) + output[i-1].charAt(0);
			output[i] += Integer.toString(count) + c;		
			
		}
		return output;
	}
	
	public static String repAndRem(char[] sChar){
		int j = 0;
		int aCount = 0;
		for(char c : sChar){
			if(c != 'b'){
				sChar[j++] = c;
			}
			if(c == 'a')
				aCount++;
		}
		sChar = Arrays.copyOf(sChar, j+aCount);
		int k = j - 1;
		j = sChar.length - 1;
		while(k >= 0){
			if(sChar[k] == 'a'){
				sChar[j--] = 'd';
				sChar[j--] = 'd';
			} else {
				sChar[j--] = sChar[k];
			}
			k--;
		}
				
		return new String(sChar);
	}
	
	public static ArrayList<String> phoneNumbers(String s){
		ArrayList<String> output = new ArrayList<>();
		String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		char[] number = new char[s.length()];
		helper(s, 0, number, output, keypad);
		return output;
	}
	
	public static void helper(String s, int digit, char[] num, ArrayList<String> output, String[] keypad){
		if(digit == s.length()){
			output.add(new String(num));
		} else {
			for(int i=0; i<keypad[s.charAt(digit) - '0'].length(); i++){
				char c = keypad[s.charAt(digit) - '0'].charAt(i);
				num[digit] = c;
				helper(s, digit + 1, num, output, keypad);
			}
		}
	}
	
	public static String reverseWords(String s){
		int n = s.length()-1;
		int i, j = n, k = n + 1;
		for(i = n; i >= 0; i--, j--){
			if(s.charAt(i) == ' ' || i == 0){
				if(i > 0) j++;
				while(j < k){
					s += s.charAt(j++);
				}
				j = i;
				k = i;
				s += ' ';
//				continue;
			}
		}
		return s.substring(n+1, s.length());
	}
	
	public static boolean isPalindrome(String s){
		int i = 0;
		int j = s.length() - 1;
		s = s.toLowerCase();
		while(i < j){
			while(!Character.isLetterOrDigit(s.charAt(i))){
				i++;	
			}
			while(!Character.isLetterOrDigit(s.charAt(j))){
				j--;	
			}
			char first = s.charAt(i);
			char last  = s.charAt(j);
			if(first != last){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
		
	public static void main(String[] args) {
//		System.out.print(spreadsheet("AB"))
//		char[] s = new char[8];
//		s[0] = 'a';
//		s[1] = 'c';
//		s[2] = 'a';
//		s[3] = 'a';
//		System.out.print(repAndRem(s));
//		System.out.println(isPalindrome("Ray a Ray"));
//		String s = "Alice likes Bob";
//		System.out.println(	reverseWords(s));
//		ArrayList<String> s = phoneNumbers("2276696");
//		for(int i=0; i<s.size(); i++){
//			System.out.println(s.get(i));
//		}
		String[] sequences = lookAndSay(8);
		for(int i=0; i<sequences.length; i++)
			System.out.println(sequences[i]);
	}
}