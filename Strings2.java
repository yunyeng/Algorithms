import java.io.*;
class Untitled {
	
	public static int romanValues(char c){
		switch(c){
			case 'M':
				return 1000;
			case 'D':
				return 500;
			case 'C':
				return 100;
			case 'L':
				return 50;
			case 'X':
				return 10;
			case 'V':
				return 5;
			case 'I':
				return 1;
		}
		return -1;
	}
	
	public static int romanToLatin(String num){
		int i;
		int result = romanValues(num.charAt(num.length()-1));
		for(i=num.length()-2; i>=0; i--){
			char c = num.charAt(i);
			char c2 = num.charAt(i+1);
			if(romanValues(c) < romanValues(c2))
				result -= romanValues(c);
			else
				result += romanValues(c);
		}
		return result;
	}
	
	public static String compress(String s){
		String res = "";
		int i;
		for(i=0; i<s.length(); i++){
			int count = 1;
			while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
				i++;
				count++;
			}
			res += Integer.toString(count);
			res += s.charAt(i);
		}
		return res;
	}
	
	public static String decompress(String s){
		String res = "";
		int i;
		for(i=0; i<s.length()-1; i+=2){
			int k = Character.getNumericValue(s.charAt(i));
			for(int j=0; j<k; j++)
				res += s.charAt(i+1);
		}
		return res;
	}
	
	public static int occurence(String s, String t){
		int i, k, j = 0;
		for(i=0; i<t.length(); i++){
			k = i;
			while(j < s.length() && t.charAt(i) == s.charAt(j)){
				i++;
				j++;
			}
			if(j == s.length()){
				return k;
			} else{
				j = 0;
				i = k;
			}
		}
		return -1;
	}
	
	public static int rabinKarp(String t, String s){
		if(s.length() > t.length())
			return -1;
		int kBase = 26, kMod = 997, tHash = 0, sHash = 0, powerS = 1;
		for(int i=0; i<s.length(); i++){
			powerS = i > 0 ? powerS * kBase % kMod : 1;
			tHash = (tHash * kBase + t.charAt(i)) % kMod;
			sHash = (sHash * kBase + s.charAt(i)) % kMod;
		}
		for(int i=s.length(); i<t.length(); i++){
			if(tHash == sHash && t.substring(i-s.length(), i).equals(s))
				return i-s.length();
			tHash -= (t.charAt(i-s.length()) * powerS) % kMod;
			if(tHash < 0)
				tHash += kMod;
			tHash = (tHash * kBase + t.charAt(i)) % kMod;
		}
		if(tHash == sHash && t.substring(t.length() - s.length()).equals(s))
			return t.length() - s.length();
		return -1;
	}
	
	public static String tail(String filename, int num) throws IOException{
		RandomAccessFile filePtr = new RandomAccessFile(filename, "r");
		long size = filePtr.length(), count = 0;
		StringBuilder res = new StringBuilder();
		for(long i= size - 1; i != -1; i--){
			filePtr.seek(i);
//			int readByte = ;
			char c = (char)filePtr.readByte();
			if(c == '\n'){
				count++;
				if(count > num)
					break;
			}
			res.append(c);
		}
		filePtr.close();
		return res.reverse().toString();
	}
	
	public static String snakeString(String s){
		String result = "";
		for(int i=1; i<s.length(); i+=4)
			result += s.charAt(i);
		for(int i=0; i<s.length(); i+=2)
			result += s.charAt(i);
		for(int i=3; i<s.length(); i+=4)
			result += s.charAt(i);			return result;
	}
	
	public static void main(String[] args) {
//		System.out.println(decompress(compress("aaaabcccaa")));
		
//		try{
//			System.out.println(tail("readme.txt", 6));
//		} catch(IOException e) {
//			System.err.println("Caught IOException: " + e.getMessage());
//		}

		System.out.print(rabinKarp("There are three linear time string matching algorithms.", "time"));
		
	}
}