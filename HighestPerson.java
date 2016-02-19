import java.util.*;
class HighestPerson {

	public static class ListComparator implements Comparator<List<Integer>>{
		@Override
		public int compare(List<Integer> a, List<Integer> b){
			return b.get(0) - a.get(0);
		}
	}
	
	public static List<List<Integer>> tallestPeople(List<List<Integer>> people){
		Collections.sort(people, new ListComparator());
		int max = 0;
		for(int i=0; i<people.size(); i++){
			max = Math.max(max, tallestPeople(people, i));
		}
		return max;
	}
	public static List<List<Integer>> tallestPeople(List<List<Integer>> people, int index){
		List<Integer> bottom = people.get(index);
		int max = 0;
		for(int i=index+1; i<people.size(); i++){
			if(canBeAbove(people.get(i), bottom)){
				int height = tallestPeople(people, i);
				max = Math.max(max, height);
			}
		}
		max++;
		return max;
	}
	public static boolean canBeAbove(List<Integer> a, List<Integer> b){
		return (b.get(0) > a.get(0)) && (b.get(1) > a.get(1));
	}
	
	public static void main(String[] args) {
		List<List<Integer>> people = new ArrayList<>();
		
		List<Integer> a = new ArrayList<>();
		a.add(65);
		a.add(100);
		List<Integer> b = new ArrayList<>();
		b.add(70);
		b.add(150);
		List<Integer> c = new ArrayList<>();
		c.add(56);
		c.add(90);
		List<Integer> d = new ArrayList<>();
		d.add(75);
		d.add(190);
		List<Integer> e = new ArrayList<>();
		e.add(60);
		e.add(95);
		List<Integer> f = new ArrayList<>();
		f.add(68);
		f.add(110);
		
		people.add(a);
		people.add(b);
		people.add(c);
		people.add(d);
		people.add(e);
		people.add(f);
		
		System.out.println(tallestPeople(people));
	}
}