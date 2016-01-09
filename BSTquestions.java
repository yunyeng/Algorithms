import java.util.ArrayList;
class BSTquestions {
	public static int size(BST.Node r){
		if(r == null)
			return 0;
		return size(r.left) + size(r.right) + 1;
	}
	
	public static int height(BST.Node r){
		if(r == null)
			return 0;
		return Math.max(height(r.left), height(r.right)) + 1;
	}
	
	public static void preOrder(BST.Node n){
		if(n != null){
			System.out.println(n.key);
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public static void inOrder(BST.Node n){
		if(n != null){
			inOrder(n.left);
			System.out.println(n.key);
			inOrder(n.right);
		}
	}
	
	public static void postOrder(BST.Node n){
		if(n != null){
			postOrder(n.left);
			postOrder(n.right);
			System.out.println(n.key);
		}
	}
	
	public static boolean rootToLeaf(BST.Node n, int sum, ArrayList<Integer> a){
		if(n == null) return false;
		if(n.left == null && n.right == null){
			if(n.key.compareTo(sum) == 0){
				a.add((int) n.key);
				return true;
			} else {
				return false;
			}
		}
		if(rootToLeaf(n.left, sum - (int) n.key, a)){
			a.add((int) n.key);
			return true;
		}
		if(rootToLeaf(n.right, sum - (int) n.key, a)){
			a.add((int) n.key);
			return true;
		}
		return false;
	}
	
	public static boolean isBST(BST.Node n, int min, int max){
		if(n == null) return true;
		if((int)n.key < min || (int)n.key > max) return false;
		return isBST(n.left, min, (int)n.key) && isBST(n.right, (int)n.key, max);
	}
	
	public static boolean sameTree(BST.Node a, BST.Node b){
		if(a != null && b != null){
			if((int)a.key != (int)b.key) return false;
			return sameTree(a.left, b.left) && sameTree(a.right, b.right);
		} else if(a == null && b != null){
			return false;
		} else if(a != null && b == null){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		BST<Integer> b = new BST<Integer>();
		b.insert(10);
		b.insert(15);
		b.insert(11);
		b.insert(1);
		b.insert(2);
		b.insert(5);
		b.insert(6);
		b.insert(8);
		b.insert(3);
		
		BST<Integer> c = new BST<Integer>();
		c.insert(10);
		c.insert(15);
		c.insert(11);
		c.insert(1);
		c.insert(2);
		c.insert(5);
		c.insert(6);
		c.insert(8);
		c.insert(3);
//		System.out.println(size(b.root));
//		System.out.println(height(b.root));
//		System.out.println(b.root.left.parent.key);
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		System.out.println(rootToLeaf(b.root, 36, a));
//		for(int i=0; i<a.size(); i++)
//			System.out.println(a.get(i));
//		System.out.println(isBST(b.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println(sameTree(b.root, c.root));
	}
}