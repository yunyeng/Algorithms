import java.util.*;
class StackQs {
	
	public static int evaluate(String s){
		Stack<Integer> results = new Stack<>();
		String[] symbols = s.split(",");
		for(String symbol : symbols){
			if(symbol.length() == 1 && "+-*/".contains(symbol)){
				int y = (int) results.pop().key;
				int x = (int) results.pop().key;
				if(symbol.charAt(0) == '+'){
					results.push(x + y);
				} else if(symbol.charAt(0) == '-'){
					results.push(x - y);
				} else if(symbol.charAt(0) == '*'){
					results.push(x * y);
				} else if(symbol.charAt(0) == '/'){
					results.push(x / y);
				}
			} else {
				results.push(Integer.parseInt(symbol));
			}
		}
		return (int) results.pop().key;
	}
	
	public static void main(String[] args) {
		System.out.println(evaluate("3,4,+,2,*,1,+"));
	}
}