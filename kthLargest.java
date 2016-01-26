import java.util.*;
class kthLargest {
	
	public static void interUnsorted(int[] a, int[] b){
		HashMap<Integer, Boolean> h = new HashMap<>();
		for(int i=0; i<a.length; i++)
			h.put(a[i], true);
		for(int i=0; i<b.length; i++)
			if(h.get(b[i]) != null)
				System.out.println(b[i]);
	}
	
	public static LLists.Node reverse(LLists.Node h){
		LLists.Node curr = h, prev = null;
		while(curr != null){
			LLists.Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static LLists.Node findLoop(LLists.Node n){
		LLists.Node slow = n;
		LLists.Node fast = n;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next;
			if(slow == fast){
				int length = 0;
				do{
					++length;
					fast = fast.next;
				} while(slow != fast);
				LLists.Node head = n;
				while(length-- > 0)
					head = head.next;
				LLists.Node iter = n;
				while(iter != head){
					iter = iter.next;
					head = head.next;
				}
				return iter;
			}
		}
		return null;
	}
	
	public static void interSorted(int[] a, int[] b){
		int i = 0, j = 0;
		while(i < a.length && j < b.length){
			if(a[i] == b[j]){
				System.out.println(a[i]);
				i++;
				j++;
			} else if(a[i] > b[j]){
				j++;
			} else {
				i++;
			}
		}
	}
	
	public static int largest(int[] a, int k){
		SimpleHeap sh = new SimpleHeap(k);
//		sh.addAll(a);
//		int kthMax = 0;
		for(int i=0; i<a.length; i++){
			if(i < k){
				sh.insert(a[i]);
			} else {	
				if(sh.min() < a[i]){
					sh.delete();
					sh.insert(a[i]);
				}
			}
		}
			
		return sh.min();
	}
	
	public static int factorial(int n){
		if(n <= 1){
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	public static void quickSort(int[] a, int p, int r){
		if(p < r){
			int q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}
	
	public static int partition(int[] a, int p, int r){
		int q = p;
		for(int i=p; i<r; i++)
			if(a[i] <= a[r])
				swap(a, i, q++);
		swap(a, r, q);
		return q;
	}
	
	public static void swap(int[] a, int f, int s){
		int temp = a[f];
		a[f] = a[s];
		a[s] = temp;
	}
	
	public static void print(int[] a){
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
	}
	
	public static void removeConsDups(char[] s){
		for(int i=1; i<s.length; i++){
			while(s[i] == s[i-1]){
				s[i] = s[i+1];
				i++;
			}
		}
	}
	
	public static ArrayList<Integer> union(ArrayList<ArrayList<Integer>> input){
		ArrayList<Integer> result = new ArrayList<>();
		SimpleHeap mh = new SimpleHeap(input.size());
		int i,j;
		for(i=0;i<input.size();i++)
			mh.insert(input.get(i).get(0));
		int max = 0;
		for(i=0; i<input.size(); i++)
			if(input.get(i).size() > max)
				max = input.get(i).size();
		for(i=1; i<max; i++){
			for(j=0; j<input.size(); j++){
				result.add(mh.delete());
				if(i < input.get(j).size())
					mh.insert(input.get(j).get(i));
			}
		}
		while(!mh.isEmpty())
			result.add(mh.delete());
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr     = {3, 5, 21, 12, 99, 13, 14, 55, 29, 30, 100, 200, 300, 1, 42, 19, 23, 71, 61, 10};
		int[] arr2    = {19, 5, 4, 12, 50, 13, 21, 55, 29, 0};
	
//		print(arr2);
//		quickSort(arr2, 0, arr2.length-1);
//		System.out.println();
//		print(arr2);

		char[] 

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a1.add(3);
		a1.add(5);
		a1.add(7);
		a2.add(0);
		a2.add(6);
		a3.add(0);
		a3.add(6);
		a3.add(28);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		ArrayList<Integer> b = union(a);
//		for(int i=0; i<b.size(); i++)
//			System.out.print(b.get(i) + " ");
		
//		System.out.println(largest(arr, 2));
		int[] ordArr  = {1, 3, 5, 10, 12, 13, 14, 19, 21, 23, 29, 30, 42, 55, 61, 71, 99, 100, 200, 300};
		int[] ordArr2 = {2, 3, 5, 10, 11, 13, 14, 19, 21, 20, 29, 31, 40};
//		System.out.println(largest(arr, 10));
//		interSorted(ordArr, ordArr2);
//		interUnsorted(arr, arr2);
		LLists<Integer> ll = new LLists<>();
		ll.insert(3);
		ll.insert(13);
		ll.insert(25);
		ll.insert(1);
		ll.insert(0);
		ll.insert(18);
		ll.insert(7);
		ll.insert(4);
		ll.insert(-2);
		ll.insert(1);
		ll.head = reverse(ll.head);
//		System.out.println(ll.head.next.next.key);

//		System.out.println(factorial(10) / 120960);
	}
}