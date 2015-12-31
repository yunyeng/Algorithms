class TreeHeap {
	
	public Node root;
	public int size;
	
	class Node {
		private int data;
		Node right;
		Node left;
		Node parent;
		public Node(int d){
			data = d;
		}
		public int get(){
			return data;
		}
		public void set(int d){
			data = d;
		}
	}
	
	public TreeHeap(){
		size = 1;
		root = null;
	}
	
	public void insert(int key){
		if(root == null){
			root = new Node(key);
		} else {
			Node n = find((int) (size) / 2);
			Node newNode = new Node(key);
			if(n.left == null){
				n.left = newNode;
			} else {
				n.right = newNode;
			}
			newNode.parent = n;
			trickleUp(newNode);
		}
		size++;	
	}
	
	public void trickleUp(Node n){
		int d = n.data;
		while(n.parent != null && n.parent.data < n.data){
			n.data = n.parent.data;
			n = n.parent;
		}
		n.data = d;
	}
	
	public void trickleDown(Node n){
		int d = n.data;
		Node larger;
		while(n.left != null || n.right != null){
			if(n.right.data > n.left.data){
				n.data = n.right.data;
				n = n.right;
			} else {
				n.data = n.left.data;
				n = n.left;
			}
			if(n.data >= n.left.data && n.data >= n.right.data)
				break;
		}
		n.data = d;
	}
	
	public Node delete(){
		Node temp = root;
		root.data = find(size-1).data;
		trickleDown(root);
		size--;
		return temp;
	}
	
	public Node find(int index){
		String key = Integer.toBinaryString(index).substring(1);
		Node n = root;
		for(int i=0; i<key.length();i++){
			if(key.charAt(i) == '1'){
				n = n.right;
			} else {
				n = n.left;
			}
		}
		return n;
	}
	
	public Node max(){
		return root;
	}
	
	public static void main(String[] args) {
		TreeHeap t = new TreeHeap();
		t.insert(5);
		t.insert(29);
		t.insert(209);
		t.insert(109);
		t.insert(1);
		t.insert(56);
		t.insert(32);
		t.insert(100);
//		System.out.println(t.max().data);
//		t.delete();
//		System.out.println(t.max().data);
		t.delete();
		System.out.print(t.root.data);
	}
}