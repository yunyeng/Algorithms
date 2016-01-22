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
	
	public static void main(String[] args) {
		int[] arr = {3, 8, 12, 16, 7, 2, 13, 10, 4, 15, 11, 9, 6, 14};
//		System.out.println(factorial(23));
//		missing2(arr);
		twoSum(arr, 20);
	}
}