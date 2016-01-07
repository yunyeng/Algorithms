class RotatedArray {
	
	public static int binaryRotate(int[] arr, int target, int min, int max){
		int mid = (min+max)/2;
		if(target == arr[mid]) return mid;
		if(min > max) return -1;
		if(arr[min] < arr[mid]){
			if(target >= arr[min] && target <= arr[mid]){
				return binaryRotate(arr, target, min, mid-1);
			} else {
				return binaryRotate(arr, target, mid+1, max);
			}
		} else if(arr[min] > arr[mid]){
			if(target >= arr[mid] && target <= arr[max]){
				return binaryRotate(arr, target, mid+1, max);
			} else {
				return binaryRotate(arr, target, min, mid-1);
			}
		} else {
			if(arr[mid] != arr[max]){
				return binaryRotate(arr, target, mid+1, max);
			} else {
				int result = binaryRotate(arr, target, min, mid-1);
				if(result == -1){
					return binaryRotate(arr, target, mid+1, max);
				} else {
					return result;
				}
			}
		}
	}
	
	public static void leftRotate(int[] arr, int d){
	  for(int i=0; i < d; i++)
	    leftRotatebyOne(arr);
	}
	public static void leftRotatebyOne(int[] arr){
		int i;
		int temp = arr[0];
		for(i=0; i<arr.length-1; i++)
			arr[i] = arr[i+1];
	  arr[i] = temp;
	}
	public static void printArray(int[] arr){
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		leftRotate(arr, 2);
		printArray(arr);
		System.out.println(binaryRotate(arr, 5, 0, arr.length-1));
	}
}