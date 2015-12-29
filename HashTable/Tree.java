class Tree {
	
	Node root;
	
	class Node {
		int data;
		Node right;
		Node left;
		public Node(int d){
			data = d;
		}
	}
	
	public Node find(int d){
		Node r = root;
		while(r.data != d){
			if(r.data > d)
				r = r.left;
			else
				r = r.right;
			if(r == null)
				break;
		}
		return r;
	}
	
	public void insert(int d){
		if(root == null)
			root = new Node(d);
		else
			insertIt(root, new Node(d));
	}
	
	public void insertIt(Node r, Node n){
		if(r.data > n.data){
			if(r.left == null)
				r.left = n;
			else
				insertIt(r.left, n);
		} else {
			if(r.right == null)
				r.right = n;
			else
				insertIt(r.right, n);
		}
	}
	
	public Node min(Node r){
		if(r.left == null)
			return r;
		else
			return min(r.left);
	}
	
	public Node max(Node r){
		if(r.right == null)
			return r;
		else
			return max(r.right);
	}
	
	public Node successor(Node r){
		return min(r.right);
	}
	
	public Node precessor(Node r){
		return max(r.left);
	}
	
	public void delete(int d){
		Node r = root;
		Node p = r;
		while(r.data != d){
			p = r;
			if(d < r.data){
				r = r.left;
			} else if(d > r.data) {
				r = r.right;
			}
			if(r == null)
				break;
		}
		if(r != null){
			if(r.right == null && r.left == null){
				if(r == root){
					root = null;
				} else {	
					if(p.right == r)	p.right = null;
					else             	p.left  = null;
				}
			} else if(r.right == null){
				if(r == root){
					root = r.left;
				} else {	
					if(p.right == r)	p.right = r.left;
					else				 	p.left  = r.left;
				}
			} else if(r.left == null){
				if(r == root){
					root = r.right;
				} else {
					if(p.right == r)	p.right = r.right;
					else					p.left  = r.right;
				}
			} else {
				Node s  = r.right;
				Node sp = s;
				while(s.left != null){
					sp = s;
					s = s.left;
				}
				if(s.right == null)
					sp.left = null;
				else
					sp.left = s.right;
				s.right = r.right;
				s.left  = r.left;
				if(p.right == r)	p.right = s;
				else   				p.left  = s;
			}
		}
	}
	
	public void preOrder(Node r){
		if(r != null){
			System.out.println(r.data);
			preOrder(r.left);
			preOrder(r.right);
		}
	}
	
	public void inOrder(Node r){
		if(r != null){
			inOrder(r.left);
			System.out.println(r.data);
			inOrder(r.right);
		}
	}
	
	public void postOrder(Node r){
		if(r != null){
			postOrder(r.left);
			postOrder(r.right);
			System.out.println(r.data);
		}
	}
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(63);
		t.insert(27);
		t.insert(80);
		t.insert(13);
		t.insert(51);
		t.insert(70);
		t.insert(92);
		t.insert(26);
		t.insert(33);
		t.insert(58);
		t.insert(82);
		t.insert(57);
		t.insert(60);
		
//		t.delete(51);
//		System.out.print(t.root.left.right.right.data);
	}
}