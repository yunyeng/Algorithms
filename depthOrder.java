import java.util.Arrays;
import java.util.*;
class Untitled {
	
	public static List<LinkedList<BST.Node>> depthOrder(BST.Node r){
		List<LinkedList<BST.Node>> result = new ArrayList<>();
		LinkedList<BST.Node> q = new LinkedList<>();
		q.add(r);
		while(!q.isEmpty()){
			result.add(new LinkedList<>(q));
			LinkedList<BST.Node> p = q;
			q = new LinkedList<>();
			while(!p.isEmpty()){
				BST.Node n = p.removeFirst();
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
		}
		return result;
	}
	
	public static int[]	 twoSum(int[] arr, int target){
			HashMap<Integer, Integer> h = new HashMap<>();
			int[] res = new int[2];
			res[0] = -1;
			res[1] = -1;
			for(int i=0; i<arr.length; i++){
				if(h.get(target-arr[i]) != null){
					res[0] = i;
					res[1] = h.get(target-arr[i]);
					break;
				}
				h.put(arr[i], i);
			}
			return res;
		}
		
	public static int binarySearch(int[] arr, int min, int max, int target){
		if(min > max)
			return -1;
		int mid = (min + max) / 2;
		if(target == arr[mid]){
			return mid;
		} else if(target > arr[mid]){
			return binarySearch(arr, mid+1, max, target);
		} else {
			return binarySearch(arr, min, mid-1, target);
		}
	}
	
	public static List<String> permutationDups(String s){
		List<String> output = new ArrayList<>();
		char[] input = s.toCharArray();
		HashMap<String, Boolean> h = new HashMap<>();
		permutationDups(input, output, 0, h);
		return output;
	}
	public static void permutationDups(char[] input, List<String> output, int i, HashMap<String, Boolean> h){
		if(i == input.length-1){
			output.add(new String(input));
			h.put(new String(input), true);
			return;
		}
		for(int j=i; j<input.length; j++){
			swap(input, i, j);
			if(h.get(new String(input)) == null){
				permutationDups(input, output, i+1, h);
				swap(input, i, j);
			} else {
				swap(input, i, j);	
			}
		}
	}
	public static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		BST<Integer> b = new BST<>();
		b.insert(5);
		b.insert(7);
		b.insert(3);
		b.insert(1);
		b.insert(4);
		b.insert(9);
		b.insert(6);
		List<LinkedList<BST.Node>> res = depthOrder(b.root);
		
//		int[] arr = {1, 3, 5, 12, 4, 8, 0, 25, 33, 10};
//		int[] result = twoSum(arr, 28);
//		System.out.print(result[0] + " - " + result[1]);
		
//		int[] arr = {3, 5, 8, 12, 21, 55, 98, 102, 215, 300, 350, 500};
//		System.out.println(binarySearch(arr, 0, arr.length-1, 99));
		
		List<String> output = permutationDups("unu");
		for(String s : output)
			System.out.println(s);
		
//		for(LinkedList<BST.Node> l : res){
//			for(BST.Node n : l){
//				System.out.print(n.key + " ");
//			}	
//			System.out.println();
//		}
	}
}