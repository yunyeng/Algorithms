import java.util.*;
class llistprob {
	
	public static void fun(LLists.Node head){
		LLists.Node temp = null;
		LLists.Node current = head;

		while (current != null)
		{
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		if(temp != null)
			head = temp.prev;
	}
	
	public static void postOrder(BST.Node r){
//		Deque<BST.Node> s1 = new ArrayDeque<BST.Node>();
//		Deque<BST.Node> s2 = new ArrayDeque<BST.Node>();
		Stack<BST.Node> s1 = new Stack<BST.Node>();
		Stack<BST.Node> s2 = new Stack<BST.Node>();
		s1.push(r);
		while(!s1.empty()){
//			BST.Node n = s1.pop();
			s2.push(s1.top());
			if(s1.top().left != null)
				s1.push(s1.top().left);
			if(s1.top().right != null)
				s1.push(s1.top().right);
			s1.pop();
		}
		
		while(!s2.empty()){
			System.out.println(s2.pop().key);
		}
		
	}

	
	public static void main(String[] args) {
		
		BST<Integer> b = new BST<Integer>();
		b.insert(2);
		b.insert(-1);
		b.insert(11);
		b.insert(0);
		b.insert(-2);
		b.insert(1);
		b.insert(10);
		b.insert(16);
		
		System.out.println(b.root.left.right.right.key);
		
	}
}