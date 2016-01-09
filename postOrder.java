import java.util.ArrayDeque;
import java.util.Deque;
class postOrder {
	
	public static void postOrder(BST.Node r){
		if(r == null) return;
		Deque<BST.Node> s1 = new ArrayDeque<BST.Node>();
		Deque<BST.Node> s2 = new ArrayDeque<BST.Node>();
		s1.push(r);
		while(!s1.isEmpty()){
			BST.Node n = s1.pop();
			s2.push(n);
			if(n.left != null)
				s1.push(n.left);
			if(n.right != null)
				s1.push(n.right);
		}
		while(!s2.isEmpty()){
			System.out.println(s2.pop().key);
		}
	}
	
	public static void main(String[] args) {
		BST<Integer> b = new BST<Integer>();
		b.insert(2);
		b.insert(-1);
		b.insert(11);
		b.insert(-2);
		b.insert(0);
		b.insert(10);
		b.insert(16);
		b.insert(1);
		
		postOrder(b.root);
		
		
	}
}