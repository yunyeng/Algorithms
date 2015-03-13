class emptyStrings {

	public static int find(String[] arr, String target, int min, int max){
		if(min > max) return -1;
		int mid = (min+max)/2;
		if(arr[mid]==target) return mid;
		if(arr[mid]!="" && arr[mid].compareTo(target)==1){
			return find(arr, target, min, mid-1);
		} else if(arr[mid]!="" && arr[mid].compareTo(target)==-1){
			return find(arr, target, mid+1, max);
		} else if(arr[mid]!="" && arr[mid].compareTo(target)==0){
			return mid;
		} else {
			int q = find(arr, target, min, mid-1);
			if(q == -1){
				return find(arr, target, mid+1, max);
			} else {
				return q;
			}
		}
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};		System.out.print(find(arr, "ball", 0, arr.length-1));
	}
}