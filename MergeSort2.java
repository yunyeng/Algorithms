import java.util.ArrayList;
class Untitled {
	
	public static void mergeSort(int[] arr, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r){
		ArrayList<Integer> loHalf = new ArrayList<Integer>();
		ArrayList<Integer> hiHalf = new ArrayList<Integer>();
		int k = p;
		while(k <= q)	loHalf.add(arr[k++]);
		while(k <= r)	hiHalf.add(arr[k++]);
		k = p;
		int i = 0;
		int j = 0;
		while(i < loHalf.size() &&
				j < hiHalf.size())
			if(loHalf.get(i) <= hiHalf.get(j)) arr[k++] = loHalf.get(i++);
			else								   arr[k++] = hiHalf.get(j++);
		while(i < loHalf.size())		   arr[k++] = loHalf.get(i++);
		while(j < hiHalf.size())		   arr[k++] = hiHalf.get(j++);
	}
	
	public static void main(String[] args) {
		
		int[] a = {77, -12, 21, 0, 1, 13, -2, 4, 19, 99, 500};
		mergeSort(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + ", ");
		
	}
}