//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
class Fibonacci {
	public static int sum = 0;
	public static int FibonacciIterative(int n){
	    int prevPrev = 0;
	    int prev = 1;
	    int result = 0;
	    for(int i = 2; i <= n; i++){
			if(result > 4000000) break;
			if(result % 2 == 0) sum += result;
			result = prev + prevPrev;
			prevPrev = prev;
			prev = result;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(FibonacciIterative(100));
		System.out.print(sum);
	}
}