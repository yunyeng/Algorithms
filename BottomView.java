import java.util.ArrayList;
class BottomView {
	public static int bottom(BST.Node n, ArrayList<Integer> arr){
		if(n.right == null && n.left == null){
			arr.add((int) n.key);
			return (int) n.key;
		}
		if(n.right != null)	bottom(n.right, arr);
		if(n.left != null)	bottom(n.left, arr);
		return -1;
	}
	public static ArrayList<Integer> bottomView(BST b){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		bottom(b.root, arr);
		return arr;
	}
	public static void main(String[] args) {
		BST<Integer> b = new BST<Integer>();
		b.insert(5);
		b.insert(9);
		b.insert(1);
		b.insert(2);
		b.insert(21);
		b.insert(10);
		b.insert(33);
		b.insert(-21);
		b.insert(13);
		System.out.print(bottomView(b));
	}
}