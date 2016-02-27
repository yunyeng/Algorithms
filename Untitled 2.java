class Untitled {
	
	public static int step(int n, int k){
		int[] memo = new int[n+1];
		return step(n, k, memo);
	}
	public static int step(int n, int k, int[] memo){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		if(memo[n] > 0)
			return memo[n];
		int res = 0;
		for(int i=1; i<=k; i++)
			res += step(n-i, k, memo);
		memo[n] = res;
		return memo[n];
	}
	
	public static void main(String[] args) {
		System.out.println(step(100, 6));
	}
}