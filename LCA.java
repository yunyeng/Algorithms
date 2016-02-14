class Untitled {
	
	public static BST.Node LCA(BST.Node r, BST.Node n1, BST.Node n2){
		if(!isAncestor(r, n1) || !isAncestor(r, n2))
			return null;
		if(isAncestor(r.left, n1) && isAncestor(r.left, n2))
			return LCA(r.left, n1, n2);
		else if(isAncestor(r.right, n1) && isAncestor(r.right, n2))
			return LCA(r.right, n1, n2);
		else
			return r;
	}
	
	public static boolean isAncestor(BST.Node r, BST.Node n){
		if(r == null)
			return false;
		if(r == n)
			return true;
		return isAncestor(r.left, n) || isAncestor(r.right, n);
	}
	
	public static void main(String[] args) {
		BST b = new BST();
		BST.Node n1 = b.newNode(3);
		n1.left = b.newNode(5);
		n1.right = b.newNode(2);
		n1.right.right = b.newNode(0);
		n1.right.left = b.newNode(14);
		n1.right.left.right = b.newNode(4);
		n1.left.left = b.newNode(21);
		n1.left.right = b.newNode(18);
		n1.left.left.left = b.newNode(4);
		n1.left.left.left.left = b.newNode(99);
		n1.left.right.left = b.newNode(1);
		n1.left.right.right = b.newNode(7);
		
		System.out.println(LCA(n1, n1.left.right.left, n1.left.left.left.left).key);
	}
}