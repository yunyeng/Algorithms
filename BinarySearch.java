class BinarySearch {
	
	private static int min;
	private static int mid;
	private static int max;
	
	public static int search(int[] arr, int target){
		min = 0;
		max = arr.length-1;
		while(min <= max){
			mid = (min + max) / 2;
			if(arr[mid] > target)	max = mid - 1;
			else if(arr[mid] < target) min = mid + 1;
			else	return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {-41, -16, 0, 3, 21, 33, 45, 77, 100, 300, 812};
		System.out.println(search(arr, 813));
	}
}