class treeDiameter {
	
	public static int diameter(BST.Node b){
		 /* base case where tree is empty */
		   if (tree == 0)
		     return 0;
		 
		  /* get the height of left and right sub-trees */
		  int lheight = b.height(tree->left);
		  int rheight = b.height(tree->right);
		 
		  /* get the diameter of left and right sub-trees */
		  int ldiameter = diameter(tree->left);
		  int rdiameter = diameter(tree->right);
		return diameter;
	}
	
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(3);
		b.insert(40);
		b.insert(12);
		b.insert(21);
		b.insert(5);
		b.insert(18);
		b.insert(0);
		b.insert(14);
		System.out.println(diameter(b.root));
	}
}