class setTest {
		public static void main(String[] args) {
			
				Set<Integer> s = new Sets<Integer>();
				
				ArrayList<Integer> set1 = new ArrayList<Integer>();
				ArrayList<Integer> set2 = new ArrayList<Integer>();
				
				/*
				set1.add("Kamuran");
				set1.add("Kamil");
				set1.add("Murtaza");
				set1.add("Muzaffer");
				set1.add("Cafer");
				
				set2.add("Alexander");
				set2.add("Cafer");
				set2.add("Mahmut");
				set2.add("Nurullah");
				*/
				
				set1.add(1);
				set1.add(3);
				set1.add(8);
				set1.add(12);
				set1.add(5);
				
				set2.add(2);
				set2.add(0);
				set2.add(5);
				set2.add(25);
				
				
				ArrayList<Integer> Union;
				ArrayList<Integer> Intersect;
				
				Union = (ArrayList<Integer>) union(set1, set2);
				Intersect = (ArrayList<Integer>) intersection(set1, set2);
				
				
				//System.out.println(union);
				//System.out.println(intersect);
				
			}
}