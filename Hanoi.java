import java.util.Stack;
class Hanoi {
	
	public static void orderTowers(int n, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination){
		if(n > 0){
			orderTowers(n-1, origin, destination, buffer);
			destination.push(origin.pop());
			orderTowers(n-1, buffer, origin, destination);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> origin = new Stack<Integer>();
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();
		
		origin.add(5);
		origin.add(4);
		origin.add(3);
		origin.add(2);
		origin.add(1);
		
		orderTowers(5, origin, buffer, destination);

		System.out.println(origin.peek());
	}
}