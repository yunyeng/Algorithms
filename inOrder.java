import java.util.ArrayDeque;
import java.util.Deque;

class inOrder {
	
	public static void inOrder(BST.Node r){
		if(r == null) return;
		Deque<BST.Node> s = new ArrayDeque<BST.Node>();
		while(r != null || !s.isEmpty()){
			if(r != null){
				s.push(r);
				r = r.left;
			} else {
				BST.Node n = s.pop();
				System.out.println(n.key);
				r = n.right;
			}
		}
	}
	
	public static void main(String[] args) {
		BST<Integer> b = new BST<Integer>();
		b.insert(10);
		b.insert(7);
		b.insert(15);
		b.insert(5);
		b.insert(12);
		b.insert(21);
		b.insert(6);
		b.insert(11);
		b.insert(24);
		inOrder(b.root);
	}
}