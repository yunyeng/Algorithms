import java.util.*;
class countOfSmallerRight {
	
	public Node root;
	public int size;
	
	class Node {
		int val;
		int sum;
		Node left;
		Node right;
		public Node(int v, int s){
			val = v;
			sum = s;
			left = null;
			right = null;
		}
	}
	
	public Node insert(int v){
		Node n = new Node(v, 0);
		if(root == null){
			root = n;
			return root;
		} else {
			size++;
			return insertNode(root, n);
		}
	}
	
	public Node insertNode(Node r, Node n){
		if(n.val < r.val){
			r.sum++;
			if(r.left == null){
				r.left = n;
				return n;
			} else {
				return insertNode(r.left, n);
			}
		} else {
			n.sum++;
			if(r.right == null){
				r.right = n;
				return n;
			} else {
				return insertNode(r.right, n);
			}
		}
	}
	
	public Node find(int v){
		Node r = root;
		while(r != null){
			if(r.val == v){
				return r;
			} else if(r.val > v){
				r = r.left;
			} else {
				r = r.right;
			}
		}
		return r;
	}
	
	public int[] getNewList(int[] arr){
		int[] a = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--){
			Node n = insert(arr[i]);
			a[i] = n.sum;
		}
		return a;
	}
	
	public static void missing2(int[] arr, int n){
		int j = 1;
		for(int i=0; i<n; i++){
			if(i >= arr.length){
				System.out.println(j);
			} else if(arr[i] != j){
				System.out.println(j);
				j = arr[i];
				n--;
			}
			j++;
		}
	}
	
	public static void main(String[] args) {
		countOfSmallerRight c = new countOfSmallerRight();
//		int[] a = {5, 2, 6, 1};
		int[] a = {2, 3, 5, 6, 7, 8, 9, 10};
		missing2(a, 10);
//		int[] arr = c.getNewList(a);
//		for(int i=0; i<arr.length; i++)
//			System.out.print(arr[i] + " ");
	}
}