import java.util.*;
public class SmallerThanRight {
	Node root;
	class Node{
		int key;
		int great;
		Node left;
		Node right;
		public Node(int k){
			key = k;
			great = 0;
		}
	}
	public void insert(int key){
		Node n = new Node(key);
		if(root == null){
			root = n;
		} else {
			Node r = root;
			while(r != null){
				if(key >= r.key){
					if(r.right == null){
						r.right = n;
						break;
					} else {
						r = r.right;
					}
				} else {
					r.great++;
					if(r.left == null){
						r.left = n;
						break;
					} else {
						r = r.left;
					}
				}
			}
		}
	}
	
	public int get(Node n, int key){
		if(n.key == key){
			return n.great;
		} else if(n.key > key){
			return get(n.left, key);
		} else {
			return n.great + 1 + get(n.right, key);
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> counts = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			counts.add(0);
		}
		for(int i=nums.length-1; i>=0; i--){
			insert(nums[i]);
			counts.set(i, get(root, nums[i]));
		}
		return counts;
	}
	
	public static void main(String[] args){
		SmallerThanRight str = new SmallerThanRight();
		int[] arr = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		List<Integer> counts = str.countSmaller(arr);
		for(int c : counts)
			System.out.print(c + ", ");
			
		//Expected: [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
	}
}