class Diameter {
	
	public static int height(BST.Node node) {
		if(node == null) return -1;
		int hl = height(node.left);
		int hr = height(node.right);
		return Math.max(hl, hr) + 1;
	}
	
	public static int diameter(BST b){
		return height(b.root.left) + height(b.root.right) + 2;
	}
	
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(3);
		b.insert(1);
		b.insert(21);
		b.insert(44);
		b.insert(1);
		b.insert(19);
		b.insert(5);
		b.insert(99);
		b.insert(30);
		b.insert(10);
		b.insert(100);
		System.out.println(diameter(b));
	}
}