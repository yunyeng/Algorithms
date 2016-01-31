import java.util.*;
class BSTQuests {
	
	public static List<Integer> kLargest(BST bst, int k){
		List<Integer> res = new ArrayList<>();
		kLargest(bst.root, k, res);
		return res;
	}
	
	public static void kLargest(BST.Node n, int k, List<Integer> res){
		if(n != null && res.size() < k){
			kLargest(n.right, k, res);
			if(res.size() < k){
				res.add((int) n.key);
				kLargest(n.left, k, res);
			}
		}
	}
	
	public static List<Integer> minDiff(List<Integer> a, List<Integer> b, List<Integer> c){
		int i = a.size() - 1, j = b.size() - 1, k = c.size() - 1;
		List<Integer> minList = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		while(i >= 0 && j >= 0 && k >= 0){
			int maxVal = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
			int minVal = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
			if((maxVal - minVal) < min){
				min = maxVal - minVal;
				minList = new ArrayList<>();
				minList.add(a.get(i));
				minList.add(b.get(j));
				minList.add(c.get(k));
			}
			if(maxVal == a.get(i))
				i--;
			else if(maxVal == b.get(j))
				j--;
			else if(maxVal == c.get(k))
				k--;
		}
		return minList;
	}
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.insert(19);
		bst.insert(7);
		bst.insert(43);
		bst.insert(3);
		bst.insert(11);
		bst.insert(23);
		bst.insert(47);
		bst.insert(2);
		bst.insert(5);
		bst.insert(17);
		bst.insert(37);
		bst.insert(53);
		bst.insert(13);
		bst.insert(29);
		bst.insert(41);
		bst.insert(31);
//		List<Integer> res = kLargest(bst, 3);
//		for(Integer r : res)
//			System.out.print(r + ", ");

		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		a.add(0);
		a.add(5);
		a.add(10);
		a.add(15);
		b.add(0);
		b.add(8);
		b.add(16);
		b.add(24);
		c.add(1);
		c.add(3);
		c.add(6);
		c.add(9);
		c.add(12);
		c.add(15);
		
		List<Integer> res = minDiff(a, b, c);
		for(Integer r : res)
			System.out.print(r + ", ");
	}
}