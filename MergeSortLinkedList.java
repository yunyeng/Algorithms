import java.util.*;
class MergeSortLinkedList {
	
	public static LLists.Node sort(LLists.Node head){
		if(head == null || head.next == null)
			return head;
		
		LLists.Node slow = head, fast = head, prev = null;
		while(fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		
		return merge(sort(head), sort(slow));
	}
	
	public static LLists.Node merge(LLists.Node a, LLists.Node b){
		LLists.Node first = a, second = b;
		LLists<Integer> newList = new LLists<>();
		while(first != null && second != null){
			if(Integer.compare((int) first.key, (int) second.key) <= 0){
				newList.insert((int) first.key);
				first = first.next;
			} else {
				newList.insert((int) second.key);
				second = second.next;
			}
		}
		if(first != null){
			newList.insert((int) first.key);
		} else {
			newList.insert((int) second.key);
		}
		return newList.head;
	}
	
	public static void maxOfThrees(int[] arr){
		int i;
		for(i=0; i<arr.length-2; i+=3){
			System.out.println(Math.max(arr[i], Math.max(arr[i+1], arr[i+2])));
		}
	}
	
	public static double salaryCap(List<Integer> salaries, int target){
		int excess = 0;
		for(Integer salary : salaries)
			excess += salary;
		excess -= target;
		int cnt = 1;
		Collections.sort(salaries);
		for(int i=salaries.size()-1; i>0; i--){
			int diff = (cnt * (salaries.get(i) - salaries.get(i-1))); 
			excess -= diff;
			cnt++;
			if(excess <= 0){
				excess += diff;
				return (double) salaries.get(i) - ((double) excess / (salaries.size() - i));
			}
 		}
		return -1.0;
	}
	
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<>();
//		s.add(20);
		s.add(30);
		s.add(40);
		s.add(60);
		s.add(90);
		s.add(150);
		s.add(210);
		s.add(300);
//		System.out.println(salaryCap(s, 700));

		int[] arr = {3, 5, 12, 20, -1, 0, 14, 21, 5, 6, 50, 44, 22, 11};
		maxOfThrees(arr);
		
	}
}