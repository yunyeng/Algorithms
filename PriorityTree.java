class PriorityTree {
	
	private Tree storage;
	private int size;
	
	public PriorityTree(){
		storage = new Tree();
		size = 0;
	}
	
	public void insert(int key){
		storage.insert(key);
		size++;
	}
	
	public Tree.Node delete(){
		Tree.Node temp = storage.max(Tree.root);
		storage.delete(temp.data);
		size--;
		return temp;
	}
	
	public Tree.Node max(){
		return storage.max(Tree.root);	
	}
	
	public static void main(String[] args) {
		PriorityTree p = new PriorityTree();
		p.insert(25);
		p.insert(35);
		p.insert(1);
		p.insert(100);
		p.insert(500);
		p.insert(200);
		p.insert(19);
		System.out.println(p.max().data);
		p.delete();
		System.out.println(p.max().data);
		p.insert(1000);
		System.out.println(p.max().data);
	}
}