import java.util.stream.IntStream;
import java.util.ArrayList;
class Untitled {
	
	public static int sum(int a, int b){
		int[] arr = new int[2];
		arr[0] = a;
		arr[1] = b;
		return IntStream.of(arr).parallel().sum();
	}
	
	public static void main(String[] args) {
		System.out.print(sum(-2, 3));
	}
}