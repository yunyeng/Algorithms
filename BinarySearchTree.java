import java.util.*;
class BinarySearchTree {
	
	public Node root;
	
	public class Node {
		int key;
		Node left;
		Node right;
		public Node(int k, Node l, Node r){
			key = k;
			left = l;
			right = r;
		}
	}
	
	public Node build(List<Integer> sorted, int min, int max){
		if(min > max)
			return null;
		int mid = (min + max) / 2;
		return new Node(sorted.get(mid), build(sorted, min, mid-1), build(sorted, mid+1, max));
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(5);
		arr.add(9);
		arr.add(12);
		arr.add(21);
		arr.add(40);
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.build(arr, 0, arr.size()-1);
		System.out.println(bst.root.right.right.left.key);
	}
}