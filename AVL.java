import java.util.*;
class AVL <T extends Comparable<T>>{
	
	class Node{
		T key;
		Node parent = null;
		Node right = null;
		Node left = null;
		int height;
		public Node(T key){
			this.key = key;
		}
	}
	
	Node root = null;
	int length = 0;
	int height = 0;
	
	public Node get(T key){
		Node x = this.root;
		while (x != null){
			int cmp = key.compareTo(x.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else return x;
		}
		return null;
	}
	
	public void insert(T value){
		Node node = new Node(value);
		if(this.root == null){
			this.root = node;
			this.length++;
		} else {
			insertNode(this.root, node);
		}
	}
	
	public void insertNode(Node current, Node node){
		int cmp = node.key.compareTo(current.key);
		if(cmp < 0){
			if(current.left == null){
				current.left = node;
				this.length++;
			} else {
				insertNode(current.left, node);
			}
		} else {
			if(current.right == null){
				current.right = node;
				this.length++;
			} else {
				insertNode(current.right, node);
			}
		}
		checkBalance(current);
	}
	
	public Node leftRotation(Node node){
		if(node.right != null){
			Node rightNode = node.right;
			node.right = rightNode.left;
			rightNode.left = node;
			return rightNode;
		}
		return null;
	}
	public Node rightRotation(Node node){
		if(node.left != null){
			Node leftNode = node.left;
			node.left = leftNode.right;
			leftNode.right = node;
			return leftNode;
		}
		return null;
	}
	
	public int height(Node node){
		if (node == null)
			return 0;
		else
			return Math.max(height(node.left), height(node.right)) + 1;
	}

	public Node checkBalance(Node current){
		/*
		if(current.left == null && current.right == null)
			current.height = -1;
		else
			current.height = Math.max(height(current.left), height(current.right)) + 1;
		*/
		if(height(current.left) - height(current.right) > 1){
			if(height(current.left.left) - height(current.left.right) > 0){
				return rightRotation(current);
			} else {
				Node left = rightRotation(current);
				return leftRotation(left);
			}
		} else if(height(current.left) - height(current.right) < -1){
			if(height(current.right.left) - height(current.right.right) < 0){
				return leftRotation(current);
			} else {
				Node right = leftRotation(current);
				return rightRotation(right);
			}
		}
		return null;
	}
	
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		AVL<Integer> a = new AVL<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(8);
		a.insert(9);
		a.insert(10);
		a.insert(11);
		
		//System.out.println(a.root.right.key);
		
		//System.out.println(a.height(a.root.right.right.right));
		
		//System.out.println(a.height(a.root));
		
		//System.out.println(a.root.left.left.key);
		
		a.inOrder(a.root);
		
		//System.out.println(a.root.left.left.left.left.key);
		
	}
}