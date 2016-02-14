class VendorSupply {
	
	public static class Vendor{
		String name;
		public Vendor(String n){
			name = n;
		}
	}
	public static class Item{
		String name;
		Vendor supplier;
		public Item(String n, Vendor s){
			name = n;
			supplier = s;
		}
	}	
	
	public static int fibonacci(int n){
		if(n <= 1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void fizzBuzz(int n){
		for(int i=1; i<=n; i++){
			if(i % 3 == 0)
				System.out.print("buzz ");
			if(i % 5 == 0)
				System.out.print("fuzz ");
			if(i % 3 != 0 && i % 5 != 0)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static int GCA(int[] arr){
		int min = arr[0];
		for(int i=1; i<arr.length; i++)
			if(min < arr[i])
				min = arr[i];
		for(int j=min; j>0; j--){
			if(isDivisible(arr, j)){
				return j;
			}
		}
		return -1;
	}
	public static boolean isDivisible(int[] arr, int n){
		for(int i=0; i<arr.length; i++){
			if(arr[i] % n != 0)
				return false;
		}
		return true;
	}
	
	public static int gcd(int a, int b){
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
	
	public static int median(int[] a, int[] b, int s, int e, int n){
		int m1, m2;
		if(n <= 0)
			return -1;
		if(n == 1)
			return a[s] + b[s] / 2;
		if(n == 2)
			return (Math.max(a[s], b[s]) + Math.min(a[e], b[e])) / 2;
		m1 = n % 2 == 0 ? (a[(e-s+1)/2] + a[(e-s+1)/2-1]) / 2 : a[(e-s+1)/2];
		m2 = n % 2 == 0 ? (b[(e-s+1)/2] + b[(e-s+1)/2-1]) / 2 : b[(e-s+1)/2];
		if(m1 == m2)
			return m1;
		else if(m1 < m2)
			return n % 2 == 0 ? median(a, b, s + n/2-1, e, n - n/2+1) : median(a, b, s + n/2, e, n - n/2);
		else
			return n % 2 == 0 ? median(b, a, s + n/2-1, e, n - n/2+1) : median(b, a, s + n/2, e, n - n/2);
	}
	
	public static boolean isAnagram(String a, String b){
		if(a.length() != b.length())
			return false;
		a = a.toLowerCase();
		b = b.toLowerCase();
		boolean[] arr = new boolean[256];
		for(int i=0; i<a.length(); i++)
			arr[a.charAt(i)] = true;
		for(int i=0; i<a.length(); i++)
			if(!arr[b.charAt(i)])
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("yunus", "ssunuy"));
//		System.out.print(fibonacci(0));
		int[] arr = {500, 25, 50, 50, 200, 100};
//		System.out.println(GCA(arr));
		
		System.out.println(gcd(12, 3));
		
//		Vendor v1 = new Vendor("CocaCola");
//		Vendor v2 = new Vendor("Penguin");
//		Vendor v3 = new Vendor("Nestle");
//		Vendor v4 = new Vendor("Comics");
//		
//		Item[] items = {new Item("Ritz", "CocaCola"), 
//							  new Item("Biscoto", "Nestle"),
//							  new Item("Snaple", "Nestle"),
//							  new Item("Linux", "Nestle"),
//							  new Item("Pencil", "Nestle"),
//							  new Item("Ritz", "Nestle"),
//							  new Item("Pencil", "Nestle"),
//							  new Item("Ritz", "Nestle"),
//							  new Item("Ritz", "Nestle"),
//							  new Item("Party", "Nestle"),
//							  new Item("Keys", "Nestle")};
	}
}