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
	
	public static boolean isOrdered(BST.Node n1, BST.Node n2, BST.Node middle){
		if(n1 == middle || n2 == middle)
			return false;
		return (isAncestor(n1, middle) && isAncestor(middle, n2)) || (isAncestor(n2, middle) && isAncestor(middle, n1));
	}
	
	public static boolean isAncestor(BST.Node parent, BST.Node child){
		if(parent == null)
			return false;
		if(parent == child)
			return true;
		if((int) parent.key > (int) child.key)
			return isAncestor(parent.left, child);
		else
			return isAncestor(parent.right, child);
	}
	
	public static List<Integer> interval(BST b, int min, int max){
		List<Integer> result = new ArrayList<>();
		interval(b.root, min, max, result);
		return result;
	}
	
	public static void interval(BST.Node n, int min, int max, List<Integer> result){
		if(n == null)
			return;
		if((int) n.key < min){
			interval(n.right, min, max, result);
		} else if((int) n.key > max){
			interval(n.left, min, max, result);
		} else {
			interval(n.left, min, max, result);
			result.add((int) n.key);
			interval(n.right, min, max, result);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(5);
		arr.add(9);
		arr.add(12);
		arr.add(21);
		arr.add(40);
//		BinarySearchTree bst = new BinarySearchTree();
//		bst.root = bst.build(arr, 0, arr.size()-1);
//		System.out.println(bst.root.right.right.key);
		BST<Integer> b = new BST<>();
		b.root = b.newNode(19);
		BST.Node n1 = b.newNode(7);
		BST.Node n2 = b.newNode(43);
		BST.Node n3 = b.newNode(3);
		BST.Node n4 = b.newNode(11);
		BST.Node n5 = b.newNode(23);
		BST.Node n6 = b.newNode(47);
		BST.Node n7 = b.newNode(2);
		BST.Node n8 = b.newNode(5);
		BST.Node n9 = b.newNode(17);
		BST.Node n10 = b.newNode(37);
		BST.Node n11 = b.newNode(53);
		BST.Node n12 = b.newNode(13);
		BST.Node n13 = b.newNode(29);
		BST.Node n14 = b.newNode(41);
		BST.Node n15 = b.newNode(31);
		n13.right = n15;
		n10.left = n13;
		n10.right = n14;
		n5.right = n10;
		n6.right = n11;
		n2.left = n5;
		n2.right = n6;
		n9.left = n12;
		n4.right = n9;
		n1.right = n4;
		n3.left = n7;
		n3.right = n8;
		n1.left = n3;
		b.root.left = n1;
		b.root.right = n2;
//		System.out.println(isOrdered(n12, n1, n13));
		List<Integer> res = interval(b, 18, 40);
		for(Integer r : res)
			System.out.print(r + " ");
	}
}