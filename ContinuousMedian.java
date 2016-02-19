import java.io.*;
import java.util.*;
class ContinuousMedian {
	
	public static void continuousMedian(InputStream sequence){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		Scanner s = new Scanner(sequence);
		while(s.hasNextInt()){
			int x = s.nextInt();
			if(minHeap.isEmpty()){
				minHeap.add(x);
			} else {
				if(x >= minHeap.peek()){
					minHeap.add(x);
				} else {
					maxHeap.add(x);
				}
			}
			if(minHeap.size() > maxHeap.size() + 1)
				maxHeap.add(minHeap.remove());
			else if(maxHeap.size() > minHeap.size())
				minHeap.add(maxHeap.remove());
			double val = minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) * 0.5 : minHeap.peek();
			System.out.println(val);
		}
	}
	
	public static void main(String[] args) {
		
	}
}