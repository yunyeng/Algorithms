import java.util.*;
class LLQs {
	
//	public static LLists.Node reverse(LLists.Node head){
//		if(head == null || head.next == null)
//			return head;
//		LLists.Node n = reverse(head.next);
//		head.next.next = head;
//		head.next = null;
//		return n;
//	}

	public static int kthLargest(int[] arr, int k){
		
	}
	
	public static LLists.Node reverse(LLists.Node head, int s, int f){
			if(head == null || s == f)
				return head;
			LLists.Node n = reverse(head.next, s+1, f);
			head.next.next = head;
			head.next = null;
			return n;
		}
	
//	public static LLists reverse(LLists ll, int s, int f){
//			int a = 1;
//			LLists.Node n = ll.head, c = null;
//			while(a != s && n != null){
//				c = n;
//				n = n.next;
//				a++;
//			}
//			c.next = reverse(n, s, f);
//			return ll;
//	}

	public static int mostFrequent(int[] arr){
		HashMap<Integer, Integer> h = new HashMap<>();
		int count = 1;
		int maxInd = 0;
		for(int i=0; i<arr.length; i++){
			if(h.get(arr[i]) ==  null){
				h.put(arr[i], 1);
			} else {
				h.put(arr[i], h.get(arr[i])+1);
				if(h.get(arr[i]) > count){
					count = 	h.get(arr[i]);
					maxInd = arr[i];
				}
			}
		}
		return maxInd;
	}
	
	public static LLists.Node reverseLoop(LLists.Node head){
		LLists.Node prev = null, curr = head;
		while(curr != null){
			LLists.Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	public static LLists mergedSort(LLists.Node h1, LLists.Node h2){
		LLists newList = new LLists();
		while(h1 != null && h2 != null){
			if((int) h1.key < (int) h2.key){
				newList.insert(h1.key);
				h1 = h1.next;
			} else {
				newList.insert(h2.key);
				h2 = h2.next;
			}
		}
		while(h1 != null){
			newList.insert(h1.key);
			h1 = h1.next;
		}
		while(h2 != null){
			newList.insert(h2.key);
			h2 = h2.next;
		}
		return newList;
	}
	
	public static LLists.Node reverse(LLists.Node r){
		LLists.Node curr = r;
		LLists.Node next = curr.next;
		while(next != null){
			next = curr.next;
			curr.next.next = curr;
			curr = next;
		}
		return curr;
	}
	
	public static LLists.Node overlap(LLists a, LLists b){
		int l1 = 1, l2 = 1;
		LLists.Node h1 = a.head;
		LLists.Node h2 = b.head;
		while(h1 != null || h2 != null){
			if(h1 != null){
				l1++;
				h1 = h1.next;
			}
			if(h2 != null){
				l2++;
				h2 = h2.next;
			}
		}
		h1 = a.head;
		h2 = b.head;
		int differ;
		System.out.println(l1);
		System.out.println(l2);
		if(l1 == l2){
			while(h1 != h2){
				h1 = h1.next;
				h2 = h2.next;
				if(h1 == null || h2 == null)
					return null;
			}
		} else if(l1 < l2){
			differ = l2 - l1;
			while(h1 != h2){
				if(differ == 0){
					h1 = h1.next;
				} else {
					differ--;
				}
				h2 = h2.next;
				if(h1 == null || h2 == null)
					return null;
			}
		} else {
			differ = l1 - l2;
			while(h1 != h2){
				if(differ == 0){
					h2 = h2.next;
				} else {
					differ--;
				}
				h1 = h1.next;
				if(h1 == null || h2 == null)
					return null;
			}
		}
		return h1;
	}
	
	public static LLists.Node pivoting(LLists l, int k){
		LLists.Node lessHead = l.newNode();
		LLists.Node equalHead = l.newNode();
		LLists.Node greaterHead = l.newNode();
		LLists.Node lessIter = lessHead;
		LLists.Node equalIter = equalHead;
		LLists.Node greaterIter = greaterHead;
		LLists.Node n = l.head;
		while(n != null){
			if((int) n.key < k){
				lessIter.next = n;
				lessIter = n;
			} else if((int) n.key == k){
				equalIter.next = n;
				equalIter = n;
			} else {
				greaterIter.next = n;
				greaterIter = n;
			}
			n = n.next;
		}
		equalIter.next = greaterHead.next;
		lessIter.next  = equalHead.next;
		
		return lessHead.next;
	}
	
	public static LLists.Node shiftByK(LLists.Node h, int k){
		if(h == null)
			return h;
		int n = 1;
		LLists.Node tail = h;
		while(tail.next != null){
			n++;
			tail = tail.next;
		}
		k %= n;
		if(k == 0)
			return h;
		int kToN = n - k;
		tail.next = h;
		LLists.Node newTail = tail;
		while(kToN > 0){
			kToN--;
			newTail = newTail.next;
		}
		LLists.Node newHead = newTail.next;
		newTail.next = null;
		return newHead;
	}
	
	public static void oddEvenMerge(LLists l){
		LLists.Node even = l.head;
		LLists.Node odd  = even.next;
		LLists.Node n    = odd;
		while(even.next != null){
			even.next = even.next.next;
			odd.next  = odd.next.next;
			even = even.next;
			odd = odd.next;
		}
		even.next = n;
//		odd.next = null;
	}
	
	public static LLists sum(LLists l1, LLists l2){
		LLists l = new LLists();
		LLists.Node h1 = l1.head;
		LLists.Node h2 = l2.head;
		int extra = 0;
		int sum   = 0;
		while(h1 != null || h2 != null){
			if(h1 != null && h2 != null){
				sum = (int) h1.key + (int) h2.key + extra;
				l.insert(sum % 10);
				h1 = h1.next;
				h2 = h2.next;
			} else if(h2 != null && h1 == null){
				sum = (int) h2.key + extra;
				l.insert(sum % 10);
				h2 = h2.next;
			} else if(h1 != null && h2 == null){
				sum = (int) h1.key + extra;
				l.insert(sum % 10);
				h1 = h1.next;
			}
			extra = sum / 10;
		}
		if(extra > 0)
			l.insert(extra);
		
		return l;
	}
	
	public static int closestInt(int[] arr, double num){
		double diff, min = 999999999.9;
		int minInd = 0;
		for(int i=0; i<arr.length; i++){
			diff = Math.abs(arr[i] - num);
			if(diff < min){
				min = diff;
				minInd = i;
			}
		}
		return minInd;
	}
	
	
	public static int fibonacci(int n){
		if(n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};
		missing2(arr);
//		System.out.println(closestInt(arr, 90.2));

//		System.out.println(fibonacci(10));
		
		LLists<Integer> ll = new LLists<>();
//		LLists<Integer> ll2 = new LLists<>();
//		ll2.insert(4);
//		ll2.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(5);
		ll.insert(7);
		ll.insert(11);
		ll.insert(17);
		ll.insert(21);
		ll.insert(32);
		ll.insert(33);
//		reverse(ll.head);
//		System.out.println(ll.head.key);
//		oddEvenMerge(ll);
//		System.out.println(ll.head.next.next.next.next.next.next.next.next.next.key);
//		ll2.find(1).next = ll.find(32);

//		ll.insert(3);
//		ll.insert(2);
//		ll.insert(2);
//		ll.insert(11);
//		ll.insert(7);
//		ll.insert(5);
//		ll.insert(11);
//		pivoting(ll, 7);
//		System.out.println(ll.head.next.next.next.next.next.next.next.key);
		
//		System.out.println(overlap(ll, ll2).key);
//		ll.head = shiftByK(ll.head, 3);
//		System.out.println(ll.head.next.next.next.key);
		
//		int[] frequency = {3, 5, 61, 24, 24, 24, 24, 3, 18, 24, 18, 3, 44, 18, 41, 18, 55, 24, 3, 12, 98, 100, 101, 100, 3, 24, 18, 18};
//		System.out.println(mostFrequent(frequency));
		
//		ll = reverse(ll, 4, 7);
//		System.out.print(ll.head.next.next.next.next.next.next.next.key);
		
//		LLists<Integer> ll1 = new LLists<>();
//		LLists<Integer> ll2 = new LLists<>();
//		ll1.insert(2);
//		ll1.insert(5);
//		ll1.insert(7);
//		ll2.insert(3);
//		ll2.insert(11);
	
//		LLists l1 = new LLists();
//		l1.insert(3);
//		l1.insert(1);
//		l1.insert(4);
//		LLists l2 = new LLists();
//		l2.insert(7);
//		l2.insert(0);
//		l2.insert(9);
//		
//		LLists l3 = sum(l1, l2);
//		System.out.println(l3.head.next.next.next.next.key);
		
//		LLists<Integer> newList = mergedSort(ll1.head, ll2.head);
//		System.out.println(newList.head.key);
	}
}