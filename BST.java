import java.util.*;
class BST <T extends Comparable<T>>{
	
	public class Node {
		T key;
		Node parent = null;
		Node right = null;
		Node left = null;
		public Node(T key){
			this.key = key;
		}
	}
	
	Node root = null;
	int length = 0;
	int height = 0;
	T lastPrinted;
	
	public int height(Node node) {
		if(node == null) return -1;
		int hl = height(node.left);
		int hr = height(node.right);
		int h = 1 + Math.max(hl, hr);
		return h;
	}
	
	public void insert(T key){
		Node n = new Node(key);
		if(this.root == null){
			root = n;
		} else {
			insertNode(this.root, n);
		}
		this.length++;
	}
	
	public void insertNode(Node current, Node node){
		int cmp = node.key.compareTo(current.key);
		if(cmp < 0){
			if(current.left == null){
				current.left = node;
				node.parent = current;
			} else {
				insertNode(current.left, node);
			}
		} else {
			if(current.right == null){
				current.right = node;
				node.parent = current;
			} else {
				insertNode(current.right, node);
			}
		}
	}
	
	public Node findNode(T key){
		Node n = this.root;
		while(n.key != key){
			int cmp = key.compareTo(n.key);
			if(cmp < 0){
				n = n.left;
			} else if(cmp > 0){
				n = n.right;
			}
		}
		return n;
	}
	
	public Node minimum(Node x){
		while(x.left != null) x = x.left;
		return x;
	}
	public Node maximum(Node x){
		while(x.right != null) x = x.right;
		return x;
	}
	public Node successor(Node x){
		if(x.right != null) return this.minimum(x.right);
		Node p = x.parent;
		while(p != null && x == p.right){
			x = p;
			p = p.parent;
		}
		return p;
	}
	public Node predecessor(Node x){
		if(x.left != null) return this.maximum(x.left);
		Node p = x.parent;
		while(p != null && x == p.left){
			x = p;
			p = p.parent;
		}
		return p;
	}
	
	public boolean contains(Node r, T key){
		if(r == null) return false;
		int cmp = key.compareTo(r.key);
		if(r.key == key) return true;
		else if(cmp < 0) return contains(r.left, key);
		else             return contains(r.right, key);
	}
	
	public boolean remove(T key){
		Node nodeToRemove = this.findNode(key);
		if(nodeToRemove == null) return false;
		Node parent = nodeToRemove.parent;
		if(this.length == 1){
			this.root = null;
		} else if(nodeToRemove.left == null && nodeToRemove.right == null){
			int cmp = nodeToRemove.key.compareTo(parent.key);
			if(cmp < 0){
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if(nodeToRemove.left == null && nodeToRemove.right != null){
			int cmp = nodeToRemove.key.compareTo(parent.key);
			if(cmp < 0){
				parent.left = nodeToRemove.right;
				nodeToRemove.right.parent = parent;
			} else {
				parent.right = nodeToRemove.right;
				nodeToRemove.right.parent = parent;
			}
		} else if(nodeToRemove.left != null && nodeToRemove.right == null){
			int cmp = nodeToRemove.key.compareTo(parent.key);
			if(cmp < 0){
				parent.left = nodeToRemove.left;
				nodeToRemove.left.parent = parent;
			} else {
				parent.right = nodeToRemove.left;
				nodeToRemove.left.parent = parent;
			}
		} else {
			Node largest = nodeToRemove.left;
			while(largest.right != null){
				largest = largest.right;
			}
			largest.parent.right = null;
			nodeToRemove.key = largest.key;
			nodeToRemove.parent = largest.parent;
		}
		this.length--;
		return true;
	}
	
	public T findMin(){
		Node r = this.root;
		while(r.left != null){
			r = r.left;
		}
		return r.key;
	}
	
	public T findMax(){
		Node r = this.root;
		while(r.right != null){
			r = r.right;
		}
		return r.key;
	}
	
	public void preOrder(Node r){
		if(r != null){
			System.out.println(r.key);
			preOrder(r.left);
			preOrder(r.right);
		}
	}
	
	public void inOrder(Node r){
		if(r != null){
			inOrder(r.left);
			System.out.println(r.key);
			inOrder(r.right);
		}
	}
	
	public void postOrder(Node r){
		if(r != null){
			postOrder(r.left);
			postOrder(r.right);
			System.out.println(r.key);
		}
	}
	
	
	public void breadthFirst(Node r){
		Queue<Node> Q = new LinkedList<Node>();
		while(r != null){
			System.out.println(r.key);
			if(r.left != null)	Q.add(r.left);
			if(r.right != null)	Q.add(r.right);
			if(!Q.isEmpty())	r = Q.remove();
			else            r = null;
		}
	}
	
	public void leftRotation(Node node){
		Node rightNode = node.right;
		node.right = rightNode.left;
		rightNode.left = node;
	}
	
	public void rightRotation(Node node){
		Node leftNode = node.left;
		node.left = leftNode.right;
		leftNode.right = node;
	}
	
	public boolean checkBinary(Node n){
		if(n != null){
			checkBinary(n.left);
			if(lastPrinted != null && n.key.compareTo(lastPrinted) <= 0) return false;
			lastPrinted = n.key;
			checkBinary(n.right);
			return true;
		}
		return false;
	}
	
	public void minHeight(ArrayList<T> arr, int min, int max){
		if(min <= max){
			int mid = (min + max)/2;
			insert(arr.get(mid));
			minHeight(arr, min, mid-1);
			minHeight(arr, mid+1, max);
		}
	}
	
	public static void main(String[] args) {
		/*
		b.insert(3);
		b.insert(5);
		b.insert(7);
		b.insert(1);
		b.insert(8);
		b.insert(12);
		*/
		
		ArrayList<Integer> hop = new ArrayList<Integer>() {{
			add(3);
			add(5);
			add(6);
			add(10);
			add(21);
			add(33);
			add(45);
			add(46);
			add(50);
			add(60);
			add(72);
			add(98);
			add(201);
			add(300);
		}};
		//3, 5, 6, 10, 21, 33, 45, 46, 50, 60, 72, 98, 201, 300
		//int[] hop = {};
		BST<Integer> b = new BST<Integer>();
		
		b.minHeight(hop, 0, hop.size()-1);
		
		//System.out.println(b.findMax());
		
		//b.inOrder(b.root);
		//System.out.println(b.isBinary());
		
		//System.out.println(b.predecessor(b.root.right.right).key);
		
		//b.collect(b.root, ar);
		
		
		//System.out.println(b.root.right.right.right.right.key);
		
		//System.out.println(b.height(b.root));
		
		//b.breadthFirst(b.root);
		
		//System.out.println(b.root.right.right.right.parent.key);
		//System.out.println(b.contains(b.root, 4));
		
		//System.out.println(b.findNode(5).right.key);
		//System.out.println(b.length);
		//b.remove(8);
		//System.out.println(b.root.right.right.right.key);
		//System.out.println(b.length);
	}
}