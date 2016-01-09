// Write a method to sort an array of strings so that all the anagrams are next to each other.

class javaTest {
	
	protected void finalize() throws Throwable{
		System.out.println("FINALIZE METHOD");
	}
	
	public static String lem(){
		System.out.println("lem");
		return "return from lem";
	}
	
	public static String foo(){
		int x = 0;
		int y = 5;
		try {
			System.out.println("start try");
			int b = y / x;
			System.out.println("end try");
			return "returned from try";
		} catch (Exception e) {
			System.out.println("catch");
			return lem() + " | returned from catch";
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void bar(){
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
	}
	
	public static void main(String[] args) {
		bar();
	}
}