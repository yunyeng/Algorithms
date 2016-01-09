import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
class levelOrder {
	
	public static void levelOrder(BST.Node r){
		if(r == null) return;
		Queue<BST.Node> queue = new LinkedList<BST.Node>();
		queue.add(r);
		while(!queue.isEmpty()){
			BST.Node n = queue.remove();
			if(n.left != null)
				queue.add(n.left);
			if(n.right != null)
				queue.add(n.right);
			System.out.println(n.key);
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
		
		levelOrder(b.root);
		
	}
}