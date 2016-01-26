import java.util.Arrays;
import java.util.*;
class MissingNumbers {
	
	public static long factorial(int n){
		long result = 1;
		int i = 1;
		while(i <= n){
			result *= i;
			i++;
		}
		return result;
	}
	
	public static void twoSum(int[] a, int sum){
		Arrays.sort(a);
		int i = 0, j = a.length-1;
		
		while(i < j){
			if(a[i] + a[j] == sum){
				System.out.print(a[i] + ", " + a[j]);
				break;
			} else if(a[i] + a[j] > sum){
				j--;
			} else {
				i++;
			}
		}
	}
	
	public static void twoSum2(int[] a, int sum){
		HashMap<Integer, Integer> h = new HashMap<>();
		for(int i=0; i<a.length; i++)
			h.put(a[i], a[i]);
		for(int i=0; i<a.length; i++)
			if(h.get(sum - a[i]) != null)
				System.out.print(h.get(sum - a[i]) + " " + a[i]);
	}
	
	public static boolean isAnagram(String a, String b){
		if(a.length() != b.length())
			return false;
		int[] chars = new int[256];
		a = a.toLowerCase();
		b = b.toLowerCase();
		for(int i=0; i<a.length(); i++)
			chars[a.charAt(i)] = 1;
		for(int i=0; i<b.length(); i++)
			if(chars[b.charAt(i)] == 0)
				return false;
		return true;
	}
	
	public static void missing2(int[] a){
		int N = a.length + 2;
		long sum  = 0;
		long prod = 1;
		long realProd = factorial(N);
		long realSum  = (N * (N + 1)) / 2;
		for(int i=0; i<a.length; i++){
			sum += a[i];
			prod *= a[i];
		}
		
		prod = realProd / prod;
		sum  = realSum - sum;
		 
		double x = (double) sum / 2 + (double) Math.sqrt(sum * sum - 4 * prod) / 2;
		double y = (double) sum / 2 - (double) Math.sqrt(sum * sum - 4 * prod) / 2;
		System.out.print((int) x + ", " + (int) y);
	}
	
	public static void removeDups(char[] s){
		int i=0, j=1;
		int k = 1;
		while(j < s.length){
			if(s[i] != s[j]) {
				s[++i] = s[j];
			}
			j++;
		}
	}
	
	public static int findMin(int[] arr, int min, int max){
		if(min > max)
			return -1;
		int mid = (min + max) / 2;
		if(mid > 0 && arr[mid-1] > arr[mid])
			return mid;
		int left  = findMin(arr, min, mid-1);
		int right = findMin(arr, mid+1, max);
		return left == -1 ? right : left;
	}
	
	public static int findMin(int[] arr){
		int min = 0;
		int max = arr.length-1;
		int mid;
		while(min < max){
			mid = (min + max) / 2;
			if(arr[mid] > arr[max]){
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}
				
	public static char firstNonRepeat(String s){
		HashMap<Character, Integer> h = new HashMap<>();
		for(int i=0; i<s.length(); i++)
			if(h.get(s.charAt(i)) != null)
				h.put(s.charAt(i), h.get(s.charAt(i))+1);
			else
				h.put(s.charAt(i), 1);
				
		for(int i=0; i<s.length(); i++)
			if(h.get(s.charAt(i)) == 1)
				return s.charAt(i);
			
		return ' ';
	}
	
	public static int squareRoot(int k){
		long min = 0, max = k, mid, squared;
		while(min <= max){
			mid = (min + max) / 2;
			squared = mid * mid;
			if(squared > k)
				max = mid - 1;
			else
				min = mid + 1;
		}
		return (int) min - 1;
	}
	
	public static long fact(int n){
		long result = 1;
		int i = 1;
		while(i <= n){
			result *= i;
			i++;	
		}
		return result;
	}
	
	public static int duplicateMissing(int[] arr){
		long realSum = 0, sum = 0, prod = 1, realProd = 1;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			if(arr[i] > 0)
				prod *= arr[i];
		}
		realSum = arr.length * (arr.length - 1) / 2;
		realProd = fact(arr.length-1);
		for(int i=0; i<arr.length; i++){
			if(arr[i] != 0){
				long division = prod / arr[i];
				long differ   = sum - arr[i];
				if((realProd / division) == (realSum - differ))
					return (int) realSum - (int) differ;
			}
		}
		return -1;
	}
	
	public static boolean isPalindromable(String s){
		HashMap<Character, Boolean> h = new HashMap<>();
		int count = 0;
		int n = s.length();
		for(int i=0; i<n; i++){
			if(h.get(s.charAt(i)) != null)
				count++;
			else
				h.put(s.charAt(i), true);
		}
		if(n % 2 == 0 && count == n / 2)
			return true;
		else if(n % 2 != 0 && count == (n-1) / 2)
			return true;
		return false;
	}
	
	public static boolean findMatrix(int[][] matrix, int num){
		int row = 0;
		int col = matrix[0].length-1;
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == num)
				return true;
			else if(matrix[row][col] > num)
				col--;
			else
				row++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 8, 12, 16, 7, 2, 13, 10, 4, 15, 11, 9, 6, 14};
//		System.out.println(factorial(23));
//		missing2(arr);
//		twoSum(arr, 20);

		int[] nums = {370, 378, 478, 550, 631, 765, 912, 1024, 2048, 3076, 4020, 5000, 103, 203, 220, 234, 279, 368};
		
//		int[] numbers = {0, 2, 1, 3, 4, 5, 6, 5, 8, 9, 10};
//		System.out.print(duplicateMissing(numbers));

		int[][] grid = {
			{3, 5, 7, 8},
			{12, 21, 33, 41},
			{54, 55, 59, 62},
			{66, 70, 80, 90}
		};
		
//		System.out.println(findMatrix(grid, 54));

		System.out.println(isPalindromable("edsfied"));

//		System.out.println(findMin(nums, 0, nums.length-1));
//		System.out.println(fact(3));
//		System.out.println(findMin(nums));

//		System.out.println(isAnagram("Jenny", "NNyej"));

//		System.out.print(firstNonRepeat("aaaaaasssaskas"));

//		char[] s = {'y','a','r','r','r','a','g','i','m'};
//		removeDups(s);
//		System.out.print(String.valueOf(s));
	}
}