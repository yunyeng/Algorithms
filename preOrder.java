import java.util.ArrayDeque;
import java.util.Deque;
class preOrder {
	
	public static void preOrder(BST.Node r){
		if(r == null) return;
		Deque<BST.Node> s1 = new ArrayDeque<BST.Node>(); 
		s1.push(r);
		while(!s1.isEmpty()){
			BST.Node n = s1.pop();
			System.out.println(n.key);
			if(n.right != null){
				s1.push(n.right);
			}
			if(n.left != null){
				s1.push(n.left);
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
		b.insert(20);
		b.preOrder(b.root);
	}
}