import java.util.Random;
import java.util.HashMap;
class Untitled {
	
	public static int cutRod(int n){
//		int[] prices = new int[n+1];
		int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
//		prices[0] = 0;
//		Random randomGenerator = new Random();
//		for(int i=1; i<=n; i++)
//			prices[i] = randomGenerator.nextInt(15) + 1;
		int[] h = new int[n+1];
		return cutRod(prices, n, h);
	}
	
	public static int cutRod(int[] p, int n, int[] h){
		if(n == 0) return 0;
		if(h[n] > 0) return h[n];
		int q = -9999999;
		for(int i=1; i<=n; i++){
			q = Math.max(q, p[i] + cutRod(p, n - i, h));
			h[n] = q;
		}
		return q;
	}
	
	public static void main(String[] args) {

		
		System.out.println(cutRod(4));
		
	}
}