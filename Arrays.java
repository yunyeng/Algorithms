import java.util.*;
class Arrays {
	
	public static int[] plusOne(int[] arr){
		int n = arr.length - 1;
		while(n >=0 && arr[n] == 9){
			arr[n] = 0;
			n--;
		}
		if(n < 0){
			int[] newArr = new int[arr.length+1];
			newArr[0] = 1;
			return newArr;
		} else {
			arr[n]++;
		}
		return arr;
	}
	
	public static int[] multiply(int[] a, int[] b){
		boolean isNegative = false;
		if(a[0] < 0 && b[0] < 0){
			a[0] *= -1;
			b[0] *= -1;
		} else if(a[0] < 0){
			a[0] *= -1;
			isNegative = true;
		} else if(b[0] < 0){
			b[0] *= -1;
			isNegative = true;
		}
		int extra = 0;
		int[] newArr = new int[a.length+b.length];
		for(int i=a.length-1; i>=0; i--){
			for(int j=b.length-1; j>=0; j--){
				newArr[i+j+1] += (a[i] * b[j]) + extra;
				extra = newArr[i+j+1] / 10;
				newArr[i+j+1] %= 10;
			}
			newArr[i] = extra;
			extra = 0;
		}
		if(isNegative)
			newArr[0] *= -1;
		return newArr;
	}
	
	public static void goToEnd(int[] a, int i){
		if(i < a.length){
			for(int j=a[i]; j>0; j--){
				goToEnd(a, i + j);
			}
		} else {
			System.out.println("AT THE END!");
		}
	}
	
	public static boolean canReachEnd(int[] a){
		int index = 0, last = a.length -1;
		for(int i=0; i<=index && index < last; i++)
			index = Math.max(index, i + a[i]);
		return index >= last;
	}
	
	public static void deleteKey(int[] a, int key){
		int j = 0;
		for(int i=0; i<a.length; i++){
			a[j] = a[i];
			if(a[i] != key)
				j++;
		}	
	}
	
	public static void deleteSortedDups(int[] a){
		int j = 0;
		for(int i=1; i<a.length; i++){
			if(a[i-1] != a[i]) j++;
			a[j] = a[i];
		}
	}
	
	public static int buyAndSell(int[] stocks){
		int profit = 0;
		int stock  = 99999999;
		for(int i=0; i<stocks.length; i++){
			profit = Math.max(profit, stocks[i] - stock);
			stock  = Math.min(stock, stocks[i]);
		}
		return profit;
	}
	
	public static int longestSubArray(int[] a){
		int count = 1;
		int maxCount = 1;
		for(int i=0; i<a.length-1; i++){
			if(a[i] == a[i+1])
				count++;
			else
				count = 1;
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}
	
	public static int buyAndSellTwice(int[] stocks){
		int profit = 0;
		int stock  = 999999;
		int[] firstProfits = new int[stocks.length];
		for(int i=0; i<stocks.length; i++){
			stock = Math.min(stock, stocks[i]);
			profit = Math.max(profit, stocks[i] - stock);
			firstProfits[i] = profit;
		}
		int maxPrice = 0;
		for(int i=stocks.length-1; i>0; i--){
			maxPrice = Math.max(maxPrice, stocks[i]);
			profit = Math.max(profit, maxPrice - stocks[i] + firstProfits[i-1]);
		}
		return profit;
	}
	
	public static ArrayList<int[]> permutation(int[] a){
		ArrayList<int[]> arr = new ArrayList<int[]>();
		permutate(a, a.length);
		return arr;
	}
	
	public static void permutate(int[] a, int n){
		if(n > 1){
			for(int i=0; i<n; i++){
				permutate(a, n-1);
				if(n == 2)
					displayArr(a);
				rotate(a, n);
			}
		}
	}
	
	public static void displayArr(int[] a){
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]);
		System.out.println();
	}
	
	public static void rotate(int[] a, int n){
		int j, position = a.length - n;
		int temp = a[position];
		for(j=position+1; j<a.length; j++)
			a[j-1] = a[j];
		a[j-1] = temp;
//		for(int i=0; i<a.length; i++)
//			System.out.print(a[i] + " ");
//		System.out.println();
	}
	
	public static int[] nextPermut(int[] a){
		int i = a.length-2;
		while(i >= 0 && a[i] >= a[i+1])
			i--;
		if(i == -1)
			return new int[a.length];
		for(int j=a.length-1; j>i; j--){
			if(a[j] > a[i]){
				swap(a, j, i);
				break;
			}
		}
		int k = a.length - 1;
		for(int j=i+1; j<k; j++){
			swap(a, j, k);
			k--;
		}
		return a;
	}
	
	public static void swap(int[] a, int f, int s){
		int temp = a[f];
		a[f] = a[s];
		a[s] = temp;
	}
	
	public static void randomSubset(int[] input, int k){
		Random rand = new Random();
		for(int i=0; i<k; i++)
			swap(input, i, rand.nextInt(input.length - i));
	}
	
	public static ArrayList<Integer> randomKSubset(int n, int k){
		HashMap<Integer, Integer> h = new HashMap<>();
		Random rand = new Random();
		for(int i=0; i<k; i++){
			int randNum = rand.nextInt(n - i) + i;
			Integer ptr1 = h.get(randNum);
			Integer ptr2 = h.get(i);
			if(ptr1 == null && ptr2 == null){
				h.put(randNum, i);
				h.put(i, randNum);
			} else if(ptr1 != null && ptr2 == null){
				h.put(i, ptr1);
				h.put(randNum, i);
			} else if(ptr1 == null && ptr2 != null){
				h.put(randNum, ptr2);
				h.put(i, randNum);
			} else {
				h.put(i, ptr1);
				h.put(randNum, ptr2);
			}
		}
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=0; i<k; i++){
			a.add(h.get(i));
		}
		return a;
	}
	
	public static void rotate(int[][] matrix){
		int n = matrix.length - 1;
		for(int i=0; i<(matrix.length / 2); i++){
			for(int j=i; j<n-i; j++){
				int temp1 = matrix[n-j][i];
				int temp2 = matrix[n-i][n-j];
				int temp3 = matrix[j][n-i];
				int temp4 = matrix[i][j];
				matrix[i][j] = temp1;
				matrix[n-j][i] = temp2;
				matrix[n-i][n-j] = temp3;
				matrix[j][n-i] = temp4;
			}
		}
	}
	
	public static int[][] pascalTriangle(int n){
		int[][] pascal = new int[n][n];
		pascal[0][0] = 1;
		int i, j;
		for(i=1; i<n; i++){
			pascal[i][0] = 1;
			for(j=1; j<i; j++){
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
			pascal[i][j] = 1;
		}
		return pascal;
	}
	
	public static void main(String[] args) {
//		int[] a = {8,9,9,9,8};
//		int[] arr = plusOne(a);
//		for(int i=0; i<arr.length; i++)
//			System.out.print(arr[i]);
//		int[] a = {-9,9,9};
//		int[] b = {-9,9,9};
//		int[] ab = multiply(a, b);
//		for(int i=0;i<ab.length; i++)
//			System.out.print(ab[i]);
//		System.out.println();
//		System.out.println(-999 * -999);
//		int[] game = {3, 3, 1, 0, 2, 0, 1};
//		goToEnd(game, 0);
//		System.out.println(canReachEnd(game));
//		int[] keys = {5, 3, 7, 11, 2, 3, 13, 5, 7};
//		deleteKey(keys, 3);
//		for(int i=0; i<keys.length; i++)
//			System.out.print(keys[i] + ", ");

//		int[] arr = {2,3,5,5,7,11,11,11,13};
//		deleteSortedDups(arr);
//		for(int i=0; i<arr.length; i++)
//			System.out.print(arr[i] + ", ");			
//		int[] arr = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
//		System.out.println(buyAndSellTwice(arr));

//		int[] arr = {310, 315, 315, 315, 315, 275, 295, 260, 270, 290, 290, 290, 230, 255, 250, 250, 250, 250, 250};
//		System.out.println(longestSubArray(arr));
		
//		int[] a = {1, 0, 3, 2};
//		ArrayList<int[]> arr = new ArrayList<int[]>();
//		arr = permutation(a);
//		
//		for(int i=0; i<arr.size(); i++){
//			for(int j=0; j<a.length; j++){
//				System.out.print(arr.get(i)[j] + " ");
//			}
//			System.out.println();
//		}

//		a = nextPermut(a);
//		for(int i=0; i<a.length; i++)
//			System.out.print(a[i] + ", ");

//		int[] a = {3, 7, 5, 11};
//		randomSubset(a, 2);
		
//		Random rand = new Random();
//		System.out.print(rand.nextInt((5) + 2));
		
//		for(int i=0; i<2; i++)
//			System.out.print(a[i] + " ");

//		int k = 4;
//		ArrayList<Integer> a = randomKSubset(100, k);
//		for(int i=0; i<k; i++)
//			System.out.print(a.get(i) + ", ");
		
//		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//		rotate(matrix);
//		for(int i=0; i<matrix.length; i++){
//			for(int j=0; j<matrix.length; j++){
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int n = 10;
		int[][] pascal = pascalTriangle(n);
		for(int i=0; i<pascal.length; i++){
			for(int j=0; j<=i; j++){
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}