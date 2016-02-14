import java.util.*;
class Tries {
	
	Node root;
	int size;
	
	class Node {
		char key;
		Map<Character, Node> children;
		public Node(char k){
			key = k;
			children = new HashMap<>();
		}
	}
	public Tries(){
		root = new Node('*');
		size = 0;
	}
	
	public void add(String s){
		Node r = root;
		add(r, s.toLowerCase().toCharArray(), 0);
	}
	public void add(Node n, char[] arr, int i){
		if(i == arr.length-1){
			if(n.children.get(arr[i]) == null)
				n.children.put(arr[i], new Node(arr[i]));
		} else if(i < arr.length-1){
			if(n.children.get(arr[i]) == null){
				n.children.put(arr[i], new Node(arr[i]));
				add(n.children.get(arr[i]), arr, i+1);
			} else {
				add(n.children.get(arr[i]), arr, i+1);
			}
			
		}
	}
	
	public List<String> getWords(String prefix){
		char[] arr = prefix.toLowerCase().toCharArray();
		List<String> output = new ArrayList<>();
		Node n = begin(arr);
		if(n == null)
			return null;
		getWords(n, output, prefix);
		return output;
	}
	
	public void getWords(Node n, List<String> output, String s){
		if(n.children.isEmpty()){
			output.add(s);
			return;
		}
		for(Map.Entry<Character, Node> e : n.children.entrySet()){
			getWords(e.getValue(), output, s + e.getKey());
		}
	}
	
	public Node begin(char[] arr){
		int i = 0;
		Node n = root;
		while(i<arr.length){
			n = n.children.get(arr[i]);
			if(n == null)
				return null;
			i++;
		}
		return n;
	}
	
	
	public static void main(String[] args) {
		Tries t = new Tries();
		t.add("Yunus");
		t.add("Yunmaz");
		t.add("Yunmor");
		t.add("Yunkol");
		t.add("Yugioh");
		
		List<String> words = t.getWords("Yu");
		for(String word : words)
			System.out.println(word);
	}
}