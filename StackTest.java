class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("Yunus");
		s.push("Mustafa");
		s.push("Emre");
		s.push("Osman");
		s.push("Ayse");
		s.push("Ela");
		s.push("Bade");
		s.push("Ozgun");
		s.push("Yeliz");
		
		//System.out.println(s.peek().prev.prev.key);
		System.out.println(s.length);
		System.out.println(s.pop().key);
		System.out.println(s.length);
		System.out.println(s.empty());
	}
}