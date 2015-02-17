import java.util.*;
import java.util.Collections;
class Heap <T extends Comparable<T>>{
	
	ArrayList<T> heap = new ArrayList<T>();
	
	public void minHeapify(){
		int i = heap.size() - 1;
		int cmp = heap.get(i).compareTo(heap.get((i-1)/2));
		while(i > 0 && cmp < 0){
			Collections.swap(heap, i, (i-1)/2);
			i = (i-1)/2;
			cmp = heap.get(i).compareTo(heap.get((i-1)/2));
		}
	}
	
	public void maxHeapify(){
		int i = heap.size() - 1;
		int cmp = heap.get(i).compareTo(heap.get((i-1)/2));
		while(i > 0 && cmp > 0){
			Collections.swap(heap, i, (i-1)/2);
			i = (i-1)/2;
			cmp = heap.get(i).compareTo(heap.get((i-1)/2));
		}
	}
	
	public void add(T value){
		heap.add(value);
		minHeapify();
	}
	
	public boolean remove(T value){
		int index = heap.indexOf(value);
		if(index < 0) return false;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		heap.set(index, heap.get(heap.size()-1));
		int l2 = heap.get(index).compareTo(heap.get(left));
		int l3 = heap.get(index).compareTo(heap.get(right));
		while(left < heap.size() && (l2 > 0 || l3 > 0)){
			int l4 = heap.get(left).compareTo(heap.get(right));
			if(l4 < 0){
				Collections.swap(heap, left, index);
				index = left;
			} else {
				Collections.swap(heap,right, index);
				index = right;
			}
			l2 = heap.get(left).compareTo(heap.get(index));
			l3 = heap.get(right).compareTo(heap.get(index));
		}
		return true;
	}
	
	public boolean contains(T value){
		int i = 0;
		while(i < heap.size() && heap.get(i) != value){
			i++;
		}
		if(i < heap.size()){
			return true;
		} else {
			return false;
		}
	}

	public boolean contains2(T value){
		int start = 0;
		int nodes = 1;
		int end;
		int count;
		while(start < heap.size()){
			start = nodes - 1;
			end = nodes + start;
			count = 0;
			while(start < end){
				int cmp = value.compareTo(heap.get(start));
				int cmp2 = value.compareTo(heap.get(start/2));
				if(cmp == 0) return true;
				else if(cmp2 > 0 && cmp < 0) count++;
				start++;
			}
			if(count == nodes) return false;
			nodes *= 2;
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*Heap<Integer> h = new Heap<Integer>();
		h.add(3);
		h.add(5);
		h.add(12);
		h.add(1);
		h.add(-99);
		h.add(4);
		h.add(27);
		
		h.remove(-99);
		*/
		
		Heap<String> h = new Heap<String>();
		h.add("Yunus");
		h.add("Kamil");
		h.add("Ahmet");
		h.add("Mehmet");
		h.add("Nuri");
		h.add("Safa");
		h.add("Kazim");
		h.add("Abba");
		
		System.out.println(h.contains2("Yunus"));
		
		System.out.println(h.heap.get(0));
	}
}