class LListsTest {
	public static void main(String[] args) {
		LLists ll = new LLists();
		ll.insert(3);
		ll.insert(5);
		ll.insert(6);
		ll.insert(8);
		ll.insert(2);
		ll.insert(18);
		ll.insert(21);
		ll.insert(35);
		System.out.println(ll.show());
		ll.remove(2);
		System.out.println(ll.show());
	}
}