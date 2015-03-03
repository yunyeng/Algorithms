import java.util.ArrayList;
class MergeSort {
	
	public static void mergeSort(int[] arr, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r){
		int k = p;
		int i, j;
		ArrayList<Integer> lo = new ArrayList<Integer>();
		ArrayList<Integer> hi = new ArrayList<Integer>();
		for(i=0; k<=q; i++, k++) lo.add(arr[k]);
		for(j=0; k<=r; j++, k++) hi.add(arr[k]);
		k = p;
		i = 0;
		j = 0;
		//System.out.println(hi.size());
		while(i < lo.size() && j < hi.size()){
			if(lo.get(i) < hi.get(j)){
				arr[k++] = lo.get(i);
				i++;
			} else {
				arr[k++] = hi.get(j);
				j++;
			}
		}
		while(i < lo.size()){
			arr[k++] = lo.get(i);
			i++;
		}
		while(j < hi.size()){
			arr[k++] = hi.get(j);	
			j++;
		}
	}
	
	public static void main(String[] args) {
		//int[] lo = new int[(arr.length-1/2) + 1];
		//int[] hi = new int[(arr.length-(arr.length-1/2))];
		int[] arr = {77, -12, 21, 0, 1, 13, -2, 4, 19, 99, 500};
		mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
	}
}