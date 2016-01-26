class QuestionsCont {
	
	public static int height(BST.Node r){
		if(r == null)
			return 0;
		return Math.max(height(r.left), height(r.right)) + 1;
	}
	
	public static void printAllLevels(BST.Node r){
		int h = height(r);
		for(int i=1; i<=h; i++){
			printLevel(r, i);
			System.out.println();
		}
	}
	
	public static void printLevel(BST.Node root, int level){
		if(root == null)
			return;
		if(level == 1){
			System.out.print(root.key + " ");
		} else if (level > 1) {
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	
	public static void quickSort(int[][] arr, int p, int r){
		if(p < r){
			int q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
	}
	
	public static int partition(int[][] arr, int p, int r){
		int q = p;
		for(int i=p; i<r; i++){
			if(arr[i][0] <= arr[r][0]){
				swap(arr, i, q);
				q++;
			}
		}
		swap(arr, q, r);
		return q;
	}
	
	public static void swap(int[][] arr, int f, int s){
		int[] temp = arr[f];
		arr[f] = arr[s];
		arr[s] = temp;
	}
	
	public static int[] longestInterval(int[][] arr){
		quickSort(arr, 0, arr.length-1);
		int last;
		int sec = 1;
		int fir = 0;
		while(sec < arr.length){
			if(arr[fir][1] > arr[sec][1]){
			} else if(arr[fir][1] > arr[sec][0]){
				arr[fir][1] = arr[sec][1];
			} else {
				fir++;
			}
			sec++;
		}
		int max = 0;
		int[] maxOverlaps = new int[2];
		for(int i=0; i<arr.length; i++){
			if(arr[i][1] - arr[i][0] > max){
				max = arr[i][1] - arr[i][0];
				maxOverlaps[0] = arr[i][0];
				maxOverlaps[1] = arr[i][1];
			}
		}
		return maxOverlaps;
	}
	
	public static boolean isPrime(int n){
		if(n < 2)
			return false;
		for(int i=2; i * i <= n; i++)
			if(n % i == 0)
				return false;
		return true;
	}
	
	public static void precedingPrimes(int n){
		for(int i=2; i<n; i++)
			if(isPrime(i))
				System.out.println(i);
	}
	
	public static void primeNums(int n){
		boolean[] prime = new boolean[n];
		for(int i=2; i<n; i++) prime[i] = true;
		for(int p=2; p*p<n; p++){
			if(prime[p]) {
				for(int i=p*2; i<n; i += p){
					prime[i] = false;
				}
			}
		}
		for(int i=0; i<n; i++) if(prime[i]) System.out.print(i + " ");
	}
	     
	
	public static void main(String[] args) {
		BST<Integer> b = new BST<>();
		b.insert(3);
		b.insert(8);
		b.insert(2);
		b.insert(0);
		b.insert(-2);
		b.insert(21);
		b.insert(5);		
		b.insert(9);
		b.insert(4);
		b.insert(11);
		b.insert(1);
		
		int[][] overlaps = {{1, 3}, {5, 9}, {4, 12}, {2, 10}, {8, 16}, {10, 14}, {18, 20}};
		int[] res = longestInterval(overlaps);
//		System.out.println(res[0] + " " + res[1]);

		int a = -1; 
//		System.out.print(Integer.toHexString(a));
		
//		precedingPrimes(29);
		primeNums(29);
		
//		System.out.print(height(b.root));
//		printAllLevels(b.root);
//		printLevel(b.root, 5);

	}
}