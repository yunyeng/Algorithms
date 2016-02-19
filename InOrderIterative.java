import java.util.*;
class InOrderIterative {
	
	public static void inOrder(BST.Node r){
		BST.Node curr = r, prev = null;
		while(curr != null){
			BST.Node next;
			if(prev == curr.parent){
				if(curr.left != null){
					next = curr.left;
				} else {	
					System.out.println(curr.key);
					next = (curr.right == null) ? curr.parent : curr.right;
				}
			} else if(prev == curr.left){
				System.out.println(curr.key);
				next = (curr.right == null) ? curr.parent : curr.right;
			} else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
	}
	
	public static int pickUpCoins(int[] coins){
		List<List<Integer>> T = new ArrayList<>(coins.length);
		for(int i=0; i<coins.length; i++)
			T.add(new ArrayList(Collections.nCopies(coins.length, -1)));
		return pickUpCoins(coins, 0, coins.length-1, T);
	}
	public static int pickUpCoins(int[] C, int a, int b, List<List<Integer>> T){
		if(a > b)
			return 0;
		if(T.get(a).get(b) == -1){
			T.get(a).set(b, Math.max(C[a] + Math.min(pickUpCoins(C, a+2, b, T),
												                pickUpCoins(C, a+1, b-1, T)), 
												C[b] + Math.min(pickUpCoins(C, a+1, b-1, T), 
												                pickUpCoins(C, a, b-2, T))));
		}
		return T.get(a).get(b);
	}
	
	public static int maxCoins(int[] coins){
			int[][] memo = new int[coins.length][coins.length];
			return maxCoins(coins, memo, 0, coins.length-1);
		}
		public static int maxCoins(int[] coins, int[][] memo, int i, int j){
			if(i > j)
				return 0;
			if(memo[i][j] == 0){
				int left  = coins[i] + Math.min(maxCoins(coins, memo, i+2, j), maxCoins(coins, memo, i+1, j-1));
				int right = coins[j] + Math.min(maxCoins(coins, memo, i+1, j-1), maxCoins(coins, memo, i, j-2));
				memo[i][j] = Math.max(left, right);
			}
			return memo[i][j];
		}
	
	public static void main(String[] args) {
		int[] coins = {25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10};
		System.out.println(maxCoins(coins));
		System.out.println(pickUpCoins(coins));
		
//		BST<Integer> b = new BST<>();
//		b.insert(8);
//		b.insert(1);
//		b.insert(5);
//		b.insert(-2);
//		b.insert(21);
//		b.insert(14);
//		inOrder(b.root);
	}
}