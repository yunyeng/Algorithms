import java.util.*;
class knapsacketc {
	
	public static void maxFish(int[][] grid, int row, int col, int fish){
		fish += grid[row][col];
		if(row < grid.length-1)
			maxFish(grid, row+1, col, fish);
		if(col < grid[0].length-1)
			maxFish(grid, row, col+1, fish);
	}

	
	public static void move(int[][] grid, int row, int col){
		if(row == 0 || col == 0)
			grid[row][col] = 1;
		else
			grid[row][col] = grid[row-1][col] + grid[row][col-1];
		if(row < grid.length-1)
			move(grid, row+1, col);
		if(col < grid[0].length-1)
			move(grid, row, col+1);
	}
	
	public static int fibonacci(int n){
		int[] cache = new int[n+1];
		return fibonacci(cache, n);
	}
	public static int fibonacci(int[] cache, int n){
		if(n <= 1){
			return n;
		} else if(cache[n] == 0){
			cache[n] = fibonacci(cache, n-1) + fibonacci(cache, n-2);
		}
		return cache[n];
	}
	
	public static boolean check(int[][] grid, int[] nums, int i, int row, int col){
		if(row >= grid.length || col >= grid[0].length)
			return false;
		if(i == nums.length)
			return true;
		if(grid[row][col] != nums[i])
			return false;
		if(row == grid.length-1 && col == grid[0].length-1)
			return true;
		return check(grid, nums, i+1, row+1, col) || check(grid, nums, i+1, row, col+1);
	}
	
	public static class Item{
		Integer weight;
		Integer value;
		public Item(Integer w, Integer v){
			weight = w;
			value  = v;
		}
	}
	public static int knapSack(List<Item> items, int w){
		List<Integer> V = new ArrayList<>(Collections.nCopies(w + 1, 0));
		for(Item item : items){
			for(int j = w; j >= item.weight; j--){
				V.set(j, Math.max(V.get(j), V.get(j - item.weight) + item.value));
			}
		}
		return V.get(w);
	}
	
	public static boolean isSubstring(String a, String b){
		return a.indexOf(b) != -1;
	}
	public static boolean isRotated(String a, String b){
		if(a.length() != b.length())
			return false;
		a += a;
		return isSubstring(a, b);
	}
	
	public static List<String> subWords(String s, HashSet<String> dict){
		List<String> partial = new ArrayList<>();
		subWords(s, partial, dict, 0);
		return partial;
	}
	public static void subWords(String s, List<String> partial, HashSet<String> dict, int i){
		if(i < s.length()){
			for(int j=i+1; j<=s.length(); j++){
				String pre = s.substring(i, j);
				if(dict.contains(pre)){
					partial.add(pre);
				}
			}
			subWords(s, partial, dict, i+1);
		}
	}

	
	public static int longestSubstring(String s){
		int count = 1, maxCount = 1;
		char a = s.charAt(0);
		char b = ' ';
		for(int i=2; i<s.length(); i++){
			count++;
			if(s.charAt(i) != a && b == ' '){
				b = a;
				a = s.charAt(i);
			} else if(s.charAt(i) != a && s.charAt(i) != b){
				maxCount = Math.max(maxCount, count);
				count = 1;
				b = ' ';
				a = s.charAt(i);
			}
			
			
			
			
		}
		return maxCount;
	}
		
	public static boolean isBST(BST.Node r, int min, int max){
		if(r == null)
			return true;
		if((int) r.key < min || (int) r.key > max)
			return false;
		return isBST(r.left, min, (int) r.key) && isBST(r.right, (int) r.key, max);
	}
	
	public static void main(String[] args) {
//		System.out.println(fibonacci(6));
		
		int[][] grid = new int[3][3];
		for(int i=0; i<grid.length; i++)
			grid[i] = new int[grid.length];
			
		grid[0][0] = 1;
		grid[0][1] = 2;
		grid[0][2] = 3;
		grid[1][0] = 3;
		grid[1][1] = 4;
		grid[1][2] = 5;
		grid[2][0] = 5;
		grid[2][1] = 6;
		grid[2][2] = 7;
		
		int[] nums = {1, 2, 3, 5, 7};
//		
//		int fish = 0;
//		maxFish(grid, 0, 0, fish);
//		
//		System.out.println(fish);

		List<Item> items = new ArrayList<>();
		items.add(new Item(20, 65));
		items.add(new Item(8, 35));
		items.add(new Item(60, 245));
		items.add(new Item(55, 195));
		items.add(new Item(40, 65));
		items.add(new Item(70, 150));
		items.add(new Item(85, 275));
		items.add(new Item(25, 155));
		items.add(new Item(30, 120));
		items.add(new Item(65, 320));
		items.add(new Item(75, 75));
		items.add(new Item(10, 40));
		items.add(new Item(95, 200));
		items.add(new Item(50, 100));
		items.add(new Item(40, 220));
		items.add(new Item(10, 99));
		
		HashSet<String> dict = new HashSet<>();
		dict.add("bed");
		dict.add("bath");
		dict.add("hand");
		dict.add("and");
		dict.add("beyond");
		dict.add("communication");
		dict.add("bed");
		dict.add("man");
		dict.add("plan");
		dict.add("canal");
		dict.add("book");
		
		BST b = new BST();
		BST.Node r = b.newNode(6);
		r.right = b.newNode(8);
		r.left = b.newNode(4);
		r.left.left = b.newNode(2);
		r.left.right = b.newNode(5);
		r.right.right = b.newNode(12);
//		r = b.newNode(3);
//		r = b.newNode(3);
//		r = b.newNode(3);

		System.out.println(longestSubstring("aaabaadaaacaaaaaa"));
		
//		System.out.println(isBST(r, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
//		List<String> output = subWords("bedbathandbeyondplcana.com", dict);
//			for(String s : output){
//				System.out.print(s + " ");
////			}
//		}


//abcds: 2
//abbbbcdbe
//aaaaa
//aaaabbc
//aabbaac
//abbbcdbbbbe
//		System.out.println(uniqueChars("aabbaac"));
		
//		System.out.println(isRotated("waterbottle", "erbottlewat"));
		
//		System.out.println(knapSack(items, 150));
		
//		System.out.println(check(grid, nums, 0, 0, 0));
		
	}
}