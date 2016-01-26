import java.util.*;
import java.io.*;
import java.util.Arrays;
class OnlineMedian {
	
	public final int CAPACITY = 32;
	
	public void compute(InputStream sequence){
		MinHeap minh = new MinHeap(CAPACITY);
		MaxHeap maxh = new MaxHeap(CAPACITY);
		Scanner s = new Scanner(sequence);
		while(s.hasNextInt()){
			int x = s.nextInt();
			if(minh.isEmpty()){
				minh.insert(x);
			} else {
				if(x >= minh.min())
					minh.insert(x);
				else
					maxh.insert(x);
			}
			if(minh.size() > maxh.size() + 1)
				maxh.insert(minh.delete());
			else if(maxh.size() > minh.size())
				minh.insert(maxh.delete());
			System.out.println(minh.size() == maxh.size() ? 0.5 * (minh.min() + maxh.max()) : minh.min());
		}
	}
	
	public static void swap(char[] a, int f, int s){
		char temp = a[f];
		a[f] = a[s];
		a[s] = temp;
	}
	
	public static boolean isPermutation(String a, String b){
		if(a.length() != b.length())
			return false;
		char[] a1 = a.toLowerCase().toCharArray();
		char[] b1 = b.toLowerCase().toCharArray();
		Arrays.sort(a1);
		Arrays.sort(b1);
		a = new String(a1);
		b = new String(b1);
		return a.equals(b);
	}
	
	public static String compress(String s){
		String res = "";
		int count;
		for(int i=0; i<s.length()-1; i++){
			count = 1;
			while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
				count++;
				i++;
			}
			res += s.charAt(i) + Integer.toString(count);
		}
		return res;
	}
	
	public static String reverse(String s){
		char[] chars = s.toCharArray();
		int i=0, j=chars.length-1;
		while(i < j)
			swap(chars, i++, j--);
		return new String(chars);
	}
	
	public static void main(String[] args) {
//		System.out.print(reverse("Kamilmisin?"));
//		String a = "Kamil";
//		String b = "Mikal";
//		System.out.println(isPermutation(a, b));
		System.out.println(compress("aabcccccaaad"));

	}
}