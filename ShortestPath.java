import java.util.*;
class ShortestPath {
	
	public static class Map{
		int row;
		int col;
		Map parent;
		public Map(int r, int c, Map p){
			row = r;
			col = c;
			parent = p;
		}
	}
	
	public static class BinaryNode {
		int key;
		BinaryNode left;
		BinaryNode right;
		public BinaryNode(int k, BinaryNode l, BinaryNode r){
			key = k;
			left = l;
			right = r;
		}
	}
	
	public static void hanoi(int n, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> dest){
		if(n > 0){
			hanoi(n-1, origin, dest, buffer);
			dest.push((int) origin.pop().key);
			hanoi(n-1, buffer, origin, dest);
		}
	}
	
	public void findPath(int[][] grid, Map origin, Map dest){
		Queue<Map> q = new Queue<>();
		if(isValid(grid, origin.row, origin.col))
			q.enqueue(origin);
		else
			return;
		Map m = null;
		while(!q.isEmpty()){
			m = q.dequeue();
			int r = m.row;
			int c = m.col;
			if(r == dest.row && c == dest.col)
				break;
			if(isValid(grid, r-1, c))
				q.enqueue(new Map(r-1, c, m));
			if(isValid(grid, r, c-1))
				q.enqueue(new Map(r, c-1, m));
			if(isValid(grid, r+1, c))
				q.enqueue(new Map(r+1, c, m));
			if(isValid(grid, r, c+1))
				q.enqueue(new Map(r, c+1, m));
		}
		m = reverseMap(m);
		while(m != null){
			System.out.println(m.row + " " + m.col);
			m = m.parent;
		}
	}
	
	public static Map reverseMap(Map m){
		Map current = m, prev = null;
		while(current != null){
			Map parent = current.parent;
			current.parent = prev;
			prev = current;
			current = parent;
		}
		return prev;
	}
	
	public static boolean isValid(int[][] grid, int row, int col){
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
			return false;
		if(grid[row][col] == 1 || grid[row][col] == -1)
			return false;
		grid[row][col] = 1;
		return true;
	}
	
	public static int factorial(int n){
		if(n <= 1){
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	public static List<List<Integer>> permutation(List<Integer> input){
		List<List<Integer>> output = new ArrayList<>();
		permutate(input, output, 0);
		return output;
	}
	
	public static List<List<Integer>> subset(List<Integer> input, int k){
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> partial = new ArrayList<>();
		subset(input, output, partial, k, 0);
		return output;
	}
	public static void subset(List<Integer> input, List<List<Integer>> output, List<Integer> partial, int k, int i){
		if(partial.size() >= k){
			output.add(new ArrayList<>(partial));
		} else if(i >= input.size()){
			return;
		} else {
			partial.add(input.get(i));
			subset(input, output, partial, k, i+1);
			partial.remove(partial.size()-1);
			subset(input, output, partial, k, i+1);
		}
	}
	
	public static List<List<Integer>> powerSet(List<Integer> input){
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> partial = new ArrayList<>();
		powerSet(input, output, partial, 0);
		return output;
	}
	public static void powerSet(List<Integer> input, List<List<Integer>> output, List<Integer> partial, int i){
		if(i == input.size()){
			output.add(new ArrayList<>(partial));
		} else {
			partial.add(input.get(i));
			powerSet(input, output, partial, i+1);
			partial.remove(partial.size()-1);
			powerSet(input, output, partial, i+1);
		}
	}
	
	public static void permutate(List<Integer> input, List<List<Integer>> output, int i){
		if(i == input.size()-1){
			output.add(new ArrayList<>(input));
		} else {
			for(int j=i; j<input.size(); j++){
				Collections.swap(input, i, j);
				permutate(input, output, i+1);
				Collections.swap(input, i, j);
			}
		}
	}
	
	public static List<String> permutation(String input){
		List<String> output = new ArrayList<>();
		char[] in = input.toCharArray();
		permutate(in, output, 0, in.length-1);
		return output;
	}
		
	public static void permutate(char[] input, List<String> output, int i, int n){
		if(i == n){
			char[] temp = new char[n+1];
			for(int j=0;j<=n;j++)
				temp[j] = input[j];
			output.add(new String(temp));
		} else {
			for(int j=i; j<=n; j++){
				swap(input, i, j);
				permutate(input, output, i+1, n);
				swap(input, i, j);
			}
		}
	}
	
	public static List<String> parentheses(int k){
		List<String> output = new ArrayList<>();
		String partial = "";
		parentheses(output, partial, k, k);
		return output;
	}
	public static void parentheses(List<String> output, String partial, int left, int right){
		if(left == 0 && right == 0){
			output.add(partial);
			return;
		}
		if(left > 0)
			parentheses(output, partial + "(", left-1, right);
		if(left < right)
			parentheses(output, partial + ")", left, right-1);
	}
	
	public static boolean isPalindrome(String s){
		for(int i=0, j=s.length()-1; i<j; i++,j--){
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
	public static List<List<String>> palindromeDecomposition(String input){
		List<List<String>> output = new ArrayList<>();
		List<String> partial = new ArrayList<>();
		palindromeDecomposition(input, output, partial, 0);
		return output;
	}
	public static void palindromeDecomposition(String input, List<List<String>> output, List<String> partial, int offset){
		if(offset == input.length()){
			output.add(new ArrayList<>(partial));
			return;
		}
		for(int i=offset+1; i<=input.length(); i++){
			String prefix = input.substring(offset, i);
			if(isPalindrome(prefix)){
				partial.add(prefix);
				palindromeDecomposition(input, output, partial, offset+1);
				partial.remove(partial.size()-1);
			}
		}
	}
	
	public static void swap(int[] input, int f, int s){
		int temp  = input[f];
		input[f]  = input[s];
		input[s]  = temp;
	}
	
	public static void swap(char[] input, int f, int s){
		char temp  = input[f];
		input[f]  = input[s];
		input[s]  = temp;
	}
	
	public static List<BinaryNode> generateBinaryTrees(int k){
		List<BinaryNode> result = new ArrayList<>();
		if(k == 0)
			result.add(null);
		for(int left=0; left<k; left++){
			int right = k - 1 - left;
			List<BinaryNode> leftSubtree = generateBinaryTrees(left);
			List<BinaryNode> rightSubtree = generateBinaryTrees(k-left-1);
			for(BinaryNode l : leftSubtree){
				for(BinaryNode r : rightSubtree){
					result.add(new BinaryNode(0, l, r));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[8][8];
		matrix[3][5] = -1;
		matrix[1][0] = -1;
		matrix[6][4] = -1;
		matrix[0][2] = -1;
		matrix[6][5] = -1;
		matrix[4][0] = -1;
		matrix[7][3] = -1;
//		ShortestPath sp = new ShortestPath();
//		Map origin = new Map(0, 0, null);
//		Map dest   = new Map(7, 7, null);
//		sp.findPath(matrix, origin, dest);
		List<Integer> input = new ArrayList<>();
		input.add(2);
		input.add(3);
		input.add(5);
		input.add(7);
		input.add(9);
//		String input = "yunus";
//		List<List<Integer>> output = subset(input, 4);
//		for(int i=0; i<output.size(); i++){
//			for(int j=0; j<output.get(i).size(); j++){
//				System.out.print(output.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		
//		List<String> parens = parentheses(3);
//		for(int j=0; j<parens.size(); j++){
//			System.out.println(parens.get(j));
//		}

//		List<List<String>> decompositions = palindromeDecomposition("yunus");
//		for(int i=0; i<decompositions.size(); i++){
//			for(int j=0; j<decompositions.get(i).size(); j++){
//				System.out.print(decompositions.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		
//		List<BinaryNode> trees = generateBinaryTrees(3);
//		for(BinaryNode tree : trees){
//			System.out.println(tree.right.key);
//		}
	}
}