class SameNum {
	
	public static boolean contains(int[] arr, int index, int value){
		for(int i=index+1; i<arr.length; i++){
			if(arr[i] == value) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] input = {1, 3, 1, 4, 5, 6, 3, 2};
		int n = input.length;
		int answer = 0;
		int[] second = new int[n];
		int k = 0;
		
		for(int i=0; i<n; i++){
			if(contains(input, i, input[i]) && !contains(second, -1, input[i])){
				answer++;
				second[k] = input[i];
				k++;
			}
		}
		
		System.out.println(answer);
		
	}
}