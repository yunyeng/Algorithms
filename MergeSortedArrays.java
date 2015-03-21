class MergeSortedArrays {
	
	public static void merge(int[] a, int[] b){
		int aLength = a.length-1;
		int lastB = b.length-1;
		int lastA = a.length - lastB - 2;
		while(lastA >= 0 && lastB >= 0){
			if(a[lastA] > b[lastB]){
				a[aLength] = a[lastA];
				lastA--;
			} else {
				a[aLength] = b[lastB];
				lastB--;
			}
			aLength--;
		}
	}
	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		a[4] = 12;
		a[5] = 20;
		int[] b = {4, 19, 21, 92};
		merge(a, b);
		for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
	}
}