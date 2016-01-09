import java.util.*;
class KnapSack {	
	
	public static int knapSack(int[] arr, int target, int index){
		if(index < 0){
			return 0;
		} else {
			if(arr[index] > target){
				return knapSack(arr, target, index-1);
			} else {
				int left = knapSack(arr, target, index-1);
				int took = knapSack(arr, target-arr[index], index-1);
				return Math.max(left, took);
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr  = {11, 8, 7, 6, 5};
		int target = 20;
		
		knapSack(arr, target, arr.length-1);
		
	}
}