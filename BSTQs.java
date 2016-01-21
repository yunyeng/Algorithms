import java.util.*;
class BSTQs {
	
	public static ArrayList<String> a = new ArrayList<>();
	
	public static boolean isBalanced(BST.Node n){
		if(n == null)
			return true;
		if(Math.abs(height(n.left) - height(n.right)) > 1)
			return false;
		return isBalanced(n.left) && isBalanced(n.right);
	}
	
	public static int height(BST.Node n){
		if(n == null)
			return 0;
		else
			return Math.max(height(n.left), height(n.right)) + 1;
	}
	
	public static boolean isAncestor(BST.Node ancestor, BST.Node n){
		if(ancestor == null)
			return false;
		if(ancestor == n)
			return true;
		return isAncestor(ancestor.left, n) || isAncestor(ancestor.right, n);
	}
	
	public static int sumToNode(BST.Node r, BST.Node n, int sum){
		if(r == null)
			return -1;
		if(r == n)
			return sum + (int) n.key;
		int leftSide = sumToNode(r.left, n, sum + (int) r.key);
		int rightSide = sumToNode(r.right, n, sum + (int) r.key);
		if(leftSide != -1)
			return leftSide;
		else
			return rightSide;
	}
	
	public static BST.Node LCA(BST.Node r, BST.Node n1, BST.Node n2){
		BST.Node n = r;
		if(!isAncestor(n, n1) || !isAncestor(n, n2))
			return null;
		BST.Node p;
		while(true){
			p = n;
			if(isAncestor(n.left, n1) && isAncestor(n.left, n2)){
				n = n.left;
			} else if(isAncestor(n.right, n1) && isAncestor(n.right, n2)){
				n = n.right;
			} else {
				break;
			}
		}
		return n;
	}
	
//	public static ArrayList<String> binaryNums(BST.Node n){
//		ArrayList<String> a = new ArrayList<>();
//		binaryNums(n, a, )
//		return a;
//	}
	
	public static void binaryNums(BST.Node n, String s){
		if(n == null)
			return;
		if(n.left == null && n.right == null){
			s += n.key;	
			a.add(s);
		}
		
		binaryNums(n.left, s + "" + n.key);
		binaryNums(n.right, s + "" + n.key);
	}
	
	public static int pathSum(BST.Node r, BST.Node n, int i){
		if(r == null)
			return 0;
		if(r == n)
			return i + (int) r.key;
		return Math.max(pathSum(r.left, n, i + (int) r.key), pathSum(r.right, n, i + (int) r.key));
	}
	
	public static boolean sumToPath(BST.Node r, int i){
		if(r == null)
			return false;
		if(i - (int) r.key < 0)
			return false;
		if(i - (int) r.key == 0){
			return true;
		}
		return sumToPath(r.left, i - (int) r.key) || sumToPath(r.right, i - (int) r.key);
	}
	
	public static BST.Node kthOrder(BST.Node n, int k){
		if(n == null)
			return null;
		if(n.left == null && k == n.size + 1)
			return n;
		if(n.left == null && k != n.size + 1)
			return null;
		if(n.left.size + 1 < k)
			return kthOrder(n.left, k - n.left.size -1);
		else if(n.left.size + 1 == k)
			return n;
		else 
			return kthOrder(n.right, k);
	}
	
	public static boolean isSymmetric(BST.Node l, BST.Node r){
		if(l == null && r == null)
			return true;
		else if(l != null && r != null){
			if(l.key != r.key)
				return false;
			if(isSymmetric(l.left, r.right) && !isSymmetric(l.right, r.left))
				return false;
			if(!isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left))
				return false;
			return true;
		}
		return false;
	}
	
	public static BST.Node successor(BST.Node n){
		if(n.right == null){
			if(n == n.parent.left){
				return n.parent;
			} else {
				while(n != n.parent.left)
					n = n.parent;
				return n.parent;
			}
		} else {
			return findMostLeft(n.right);
		}
	}
	
	public static BST.Node findMostLeft(BST.Node n){
		if(n.left == null)
			return n;
		return findMostLeft(n.left);
	}
	
	public static void inOrder(BST.Node n){
		if(n != null){
			inOrder(n.left);
			System.out.print(n.key+" ");
			inOrder(n.right);
		}
	}
	
	public static void inOrderLoop(BST.Node r){
		BST.Node prev = null;
		BST.Node n = r;
		while(n != null){
			BST.Node next;
			if(n.parent == prev){
				if(n.left != null){
					next = n.left;
				} else {
					System.out.print(n.key + " ");
					if(n.right != null)
						next = n.right;
					else
						next = n.parent;
				}
			} else if(n.left == prev){
				System.out.print(n.key + " ");
				if(n.right != null)
					next = n.right;
				else
					next = n.parent;
			} else {
				next = n.parent;
			}
			prev = n;
			n = next;
		}
	}
	
	public static void exterior(BST.Node r){
		System.out.print(r.key + " ");
		leftOuter(r.left);
		leaves(r);
		rightOuter(r.right);
	}
	public static void leaves(BST.Node n){
		if(n != null){
			if(n.left == null && n.right == null)
				System.out.print(n.key + " ");
			leaves(n.left);
			leaves(n.right);
		}
	}
	public static void leftOuter(BST.Node n){
		if(n.left != null){
			System.out.print(n.key + " ");
			leftOuter(n.left);
		}
	}
	public static void rightOuter(BST.Node n){
		if(n.right != null){
			System.out.print(n.key + " ");
			rightOuter(n.right);
		}
	}
	
//	public static double GetSquareRoot(double n, double low, double high) {
//	    double errorMargin = 0.001;        
//	    double sqrt = (low + high) / 2;
//	    double diff = sqrt*sqrt - n;
//	    if ( diff > errorMargin)
//	        return GetSquareRoot(n, low, sqrt);
//	    if ( -diff > errorMargin)
//	        return GetSquareRoot(n, sqrt, high);
//	    return sqrt;
//	}
	
//	public static BST.Node nextLevelPerfect(BST.Node r, BST.Node n){
//		BST.Node node = r;
//		while(node != n){
//			
//		}
//	}
//	
	public static void main(String[] args) {
		BST<Integer> b = new BST<>();
		BST.Node n = b.newNode(12, 7);
		BST.Node n2 = b.newNode(21, 9);
		BST.Node n3 = b.newNode(33, 3);
		BST.Node n4 = b.newNode(41, 3);
		BST.Node n5 = b.newNode(50, 5);
		BST.Node n6 = b.newNode(100, 3);
		
		BST.Node n7 = b.newNode(12, 1);
		BST.Node n8 = b.newNode(24, 1);
		BST.Node n9 = b.newNode(45, 2);
		BST.Node n10 = b.newNode(31, 4);
		BST.Node n11 = b.newNode(24, 2);
		BST.Node n12 = b.newNode(19, 1);
		BST.Node n13 = b.newNode(54, 2);
		BST.Node n14 = b.newNode(21, 1);
		BST.Node n15 = b.newNode(211, 1);
		BST.Node n16 = b.newNode(33, 1);
		
		b.root = b.newNode(4, 17);
		b.root.left = n;
		b.root.right = n2;
		n.left = n3;
		n.right = n4;
		n.parent = b.root;
		n2.parent = b.root;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n3.right = n8;
		n3.parent = n;
		n4.parent = n;
		n4.right = n9;
		n5.right = n10;
		n5.parent = n2;
		n6.parent = n2;
		n7.parent = n3;
		n8.parent = n3;
		n9.parent = n4;
		n12.parent = n9;
		n10.parent = n5;
		n13.parent = n10;
		n14.parent = n10;
		n16.parent = n13;
		n11.parent = n6;
		n15.parent = n11;
		n6.right = n11;
		n9.left = n12;
		n10.left = n13;
		n10.right = n14;
		n11.right = n15;
		n13.right = n16;
		
		System.out.print(sumToNode(b.root, n9, 0));	
		
//		System.out.println(inOrder);
//		inOrder(b.root);
//		System.out.println();
//		inOrderLoop(b.root);

//		exterior(b.root);

//		System.out.println(GetSquareRoot(99.990, 99.989, 99.991));
		
//		System.out.println(pathSum(b.root, n8, 0));
//		System.out.println(sumToPath(b.root, 360));
//		System.out.println(kthOrder(b.root, 9).key);
//		String s = "";
////		s += b.root.key;
//		binaryNums(b.root, s);
//		for(int i=0; i<a.size(); i++)
//			System.out.println(a.get(i));
		
//		b.insert(314);
//		b.insert(200);
//		b.insert(400);
//		b.insert(100);
//		b.insert(350);
//		b.insert(500);
//		b.insert(90);
//		b.insert(120);
//		b.insert(450);
//		b.insert(600);
//		b.insert(440);
//		b.insert(430);
//		System.out.println(LCA(b.root, b.root.right.left, b.root.right.right.left.left.left).key);
	}
}