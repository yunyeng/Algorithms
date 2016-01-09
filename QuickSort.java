class QuickSort {
	
	public static void swap(int[] arr, int first, int second){
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	public static int partition(int[] arr, int p, int r){		int q = p;
		for(int j=p; j<r; j++){
			if(arr[j] <= arr[r]){
				swap(arr, j, q);
				q++;
			}
		}
		swap(arr, q, r);
		return q;
	}
	
	public static void quickSort(int[] arr, int p, int r){
		if(p < r){
			int q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {14, -99, 21, 0, 1, 5, 100, 999, -999, 81, 4, 2, 25};
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
		
		quickSort(arr, 0, arr.length-1);
		System.out.println();
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
		
	}
}