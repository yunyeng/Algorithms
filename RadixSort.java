class RadixSort {
	
	public static void sort(int[] a){
		int i;
		int m = a[0];
		int exp = 1;
		int n = a.length;
		int[] b = new int[n];
		for (i = 1; i < n; i++)
			if (a[i] > m)
				m = a[i];
			while (m / exp > 0){
				int[] bucket = new int[n];
				for (i=0; i<n; i++)	bucket[(a[i] / exp) % n]++;
				for (i=1; i<n; i++)	bucket[i] += bucket[i-1];
				for (i=n-1; i>=0; i--) b[--bucket[(a[i] / exp) % n]] = a[i];
				for (i = 0; i<n; i++)	a[i] = b[i];
				exp *= n;
			}
	}    
	
	public static void main(String[] args) {
		int[] arr = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567, 9999, 8998};
		sort(arr);
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
	}
}