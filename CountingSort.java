class CountingSort {
	
	public static int[] sort(int[] A){
		int[] B = new int[A.length];
		int k = A[0];
		for(int i=1; i<A.length; i++) if(k < A[i]) k = A[i];
		int[] C = new int[k+1];
		for(int j=0; j<=k; j++) C[j] = 0;
		for(int i=0; i<A.length; i++) C[A[i]]++;
		for(int j=1; j<=k; j++) C[j] += C[j-1];
		for(int i=0; i<A.length; i++){
			B[C[A[i]]-1] = A[i];
			C[A[i]]--;
		}
		return C;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 2, 9, 4, 8, 6, 7};
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
		arr = sort(arr);
		System.out.println();
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
	}
}