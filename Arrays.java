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
	
	public static void main(String[] args) {
		int[] a = {8,9,9,9,8};
		int[] arr = plusOne(a);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]);
	}
}