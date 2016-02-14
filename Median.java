class Median {
	
	public static double getMedian(int[] a, int[] b, int n, int aLeft, int bLeft){
		if(n == 1){
			return (double) a[aLeft] + b[bLeft] / 2.0;
		}
		if(n == 2){
			return (double) (Math.max(a[aLeft], b[bLeft]) + Math.min(a[aLeft+1], b[bLeft+1])) / 2.0;
		}
		return -1.0;
	}
	
	public static double sortedSameLength(int[] a, int[] b){
		int n = a.length;
		int aLeft = 0, bLeft = 0;
		if(n <= 2)
			return getMedian(a, b, n, aLeft, bLeft);
		while(n > 2){
			double m1 = n % 2 == 0 ? (double) (a[n/2 + aLeft] + a[n/2 + aLeft-1]) / 2.0 : (double) a[n/2 + aLeft];
			double m2 = n % 2 == 0 ? (double) (b[n/2 + bLeft] + b[n/2 + bLeft-1]) / 2.0 : (double) b[n/2 + bLeft];			if(m1 == m2){
				return m1;
			} else if(m1 > m2) {
				bLeft = n % 2 == 0 ? bLeft + n/2 - 1 : bLeft + n/2;
			} else {
				aLeft = n % 2 == 0 ? aLeft + n/2 - 1 : aLeft + n/2;
			}
			n = n % 2 == 0 ? n-n/2+1 : n-n/2;
		}
		return getMedian(a, b, n, aLeft, bLeft);
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3, 8, 24, 30, 50000};
		int[] b = {5, 65, 73, 92, 128, 130};
		System.out.println(sortedSameLength(a, b));
	}
}