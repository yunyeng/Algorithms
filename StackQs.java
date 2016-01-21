import java.util.*;
class StackQs {
	
	public static boolean parenthesisMatch(String str){
		Stack<Character> s = new Stack<>();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c == '(' || c == '{' || c == '['){
				s.push(c);
			} else {
				if(s.isEmpty())
					return false;
				char first = (char) s.pop().key;
				if(first == '[' && c != ']')
					return false;
				else if(first == '{' && c != '}')
					return false;
				else if(first == '(' && c != ')')
					return false;
			}
		}
		return s.isEmpty();
	}
	
	public static int evaluate(String s){
		Stack<Integer> results = new Stack<>();
		String[] symbols = s.split(",");
		for(String symbol : symbols){
			if(symbol.length() == 1 && "+-*/".contains(symbol)){
				int y = (int) results.pop().key;
				int x = (int) results.pop().key;
				if(symbol.charAt(0) == '+'){
					results.push(x + y);
				} else if(symbol.charAt(0) == '-'){
					results.push(x - y);
				} else if(symbol.charAt(0) == '*'){
					results.push(x * y);
				} else if(symbol.charAt(0) == '/'){
					results.push(x / y);
				}
			} else {
				results.push(Integer.parseInt(symbol));
			}
		}
		return (int) results.pop().key;
	}
	
	public static String cleanPathname(String str){
		Stack<String> s = new Stack<>();
		String[] paths = str.split("/");
		if(paths[0].equals("/")) s.push("/");
		for(String path : paths){
			if(path.equals("..")){
				s.pop();
			} else if(path.equals(".") || path.equals("")){
				continue;
			} else {
				s.push(path);
			}
		}
		String result = "";
		Stack.Node n = s.head();
		while(n != s.tail()){
			result += n.key + "/";
			n = n.next;
		}
		return result;
	}
	
	public static void sortStack(Stack<Integer> s, int n){
		if(n > 1){
			for(int i=0; i<n; i++){
				int last = (int) s.pop().key;
				sortStack(s, n-1);
				int first = (int) s.pop().key;
				if(first > last){
					s.push(last);
					s.push(first);
				} else {
					s.push(first);
					s.push(last);
				}
			}
		}
	}
	
	public static void sameLevelQueue(BST.Node r){
		Queue<BST.Node> q = new Queue<BST.Node>();
		int i = 0;
		if(r != null)
			q.enqueue(r);
		while(!q.isEmpty()){
			Queue<BST.Node> newLevel = q;
			while(!q.isEmpty()){ System.out.print(q.dequeue().key + ", "); }
			q = new Queue<BST.Node>();
			while(!newLevel.isEmpty()){
				BST.Node n = newLevel.dequeue();
				if(n.left != null)
					q.enqueue(n.left);
				if(n.right != null)	
					q.enqueue(n.right);
			}
		}
	}
	
	public static ArrayList orderedBST(BST.Node r){
		ArrayList<Integer> a = new ArrayList<>();
	 	ArrayDeque<BST.Node> s = new ArrayDeque<>();
//		Stack<BST.Node> s = new Stack<BST.Node>();
		BST.Node n = r;
		while(!s.isEmpty() || n != null){
			if(n != null){
				s.push(n);
				n = n.left;
			} else {
				n = s.pop();
				a.add((int) n.key);
				n = n.right;
			}
		}
		
		return a;
	}
	
	public static void main(String[] args) {
//		System.out.println(evaluate("3,4,+,2,*,1,+"));
//		System.out.println(parenthesisMatch("[()[]{()()}]"));

		BST<Integer> b = new BST<>();
		b.insert(314);
		b.insert(6);
		b.insert(6);
		b.insert(271);
		b.insert(561);
		b.insert(2);
		b.insert(271);
		b.insert(28);
		b.insert(0);
		b.insert(3);
		b.insert(1);
		b.insert(28);
		b.insert(17);
		b.insert(401);
		b.insert(257);
		b.insert(641);
		
		sameLevelQueue(b.root);

//		Stack<Integer> s = new Stack<>();
//		s.push(5);
//		s.push(2);
//		s.push(21);
//		s.push(8);
//		s.push(12);
//		s.push(13);
//		s.push(4);
//		s.push(1);
//		s.push(92);
//		s.push(54);
//		sortStack(s, s.length);
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
//		s.pop();
//		System.out.println(s.peek().key);
	
//		BST<Integer> b = new BST<>();
//		b.insert(5);
//		b.insert(2);
//		b.insert(8);
//		b.insert(1);
//		b.insert(4);
//		b.insert(7);
//		b.insert(12);
//		b.insert(6);
//		ArrayList a = orderedBST(b.root);
//		for(int i=0; i<a.size(); i++)
//			System.out.println(a.get(i));

//		System.out.println(cleanPathname("scripts//./../scripts/awkscripts/././"));
	}
}