import java.util.*;
class Calendar {
	
	private static class Event implements Comparable<Event>{
		public int start;
		public int end;
		public Event(int s, int e){
			start = s;
			end   = e;
		}
		public int compareTo(Event e){
//			int cmp = Integer.compare(end, e.end);
//			if(cmp != 0)
//				return cmp;
//			return Integer.compare(e.start, start);
			return Integer.compare(start, e.start);
		}
	}
	
	private static class Student{
		String name;
		int age;
		public Student(String n, int a){
			name = n;
			age = a;
		}
	}
	
	public static void groupByAge(List<Student> students){
		HashMap<Integer, Integer> h = new HashMap<>();
		for(Student student : students){
			Integer age = h.get(student.age);
			if(age == null)
				age = 0;
			age++;
			h.put(student.age, age);
		}
		int index = 0;
		for(Map.Entry<Integer, Integer> entry : h.entrySet()){
			int temp = entry.getValue();
			h.put(entry.getKey(), index);
			index += temp;
		}
		int j;
		for(int i=0; i<students.size(); i++){
			int age = students.get(i).age;
			j = i;
			swap(students, j, h.get(age));
			h.put(age, h.get(age) + 1);
		}
	}
	
	public static void swap(List<Student> l, int i, int j){
		Student s = l.get(i);
		l.add(i, l.get(j));
		l.add(j, s);
	}
	
	public static List<Event> mergeIntervals(List<Event> events){
		List<Event> newList = new ArrayList<>();
		int i=0, j=1, k=0;
		newList.add(new Event(events.get(k).start, events.get(k).start));
//		newList.get(k).start = events.get(k).start;
		while(j < events.size()){
			if(events.get(i).end >= events.get(j).start || events.get(j-1).end >= events.get(j).start){
				j++;
			} else {
				newList.get(k++).end = events.get(j-1).end;
				i = j;
				j++;
				newList.add(new Event(events.get(i).start, events.get(i).start));
//				newList.get(k).start = events.get(i).start;
			}
		}
		return newList;
	}
	
	public static void setDisjoint(List<Event> events, Event event){
		int i=0;
		while(i < events.size() && event.start > events.get(i).end)
			i++;
		if(event.start < events.get(i).start)
			events.get(i).start = event.start;
		while(i < events.size()-1 && event.end > events.get(i).end)
			events.remove(++i);
		events.get(i-1).end = events.get(i).end;
		events.remove(i);
	}
	
	public static int maxConcurrency(List<Event> events){
		Collections.sort(events);
		int count = 1, max = 1;
		for(int i = 1; i<events.size(); i++){
			if(events.get(i-1).end > events.get(i).start){
				count++;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
	public static void main(String[] args) {
//		List<Event> events = new ArrayList<>();
//		events.add(new Event(0, 3));
//		events.add(new Event(1, 1));
//		events.add(new Event(2, 4));
//		events.add(new Event(3, 4));
//		events.add(new Event(5, 7));
//		events.add(new Event(7, 8));
//		events.add(new Event(8, 11));
//		events.add(new Event(9, 11));
//		events.add(new Event(12, 14));
//		events.add(new Event(12, 16));
//		events.add(new Event(13, 15));
//		events.add(new Event(16, 17));

		List<Student> students = new ArrayList<>();
		students.add(new Student("Greg", 14));
		students.add(new Student("John", 12));
		students.add(new Student("Andy", 11));
		students.add(new Student("Jim", 13));
		students.add(new Student("Phil", 12));
		students.add(new Student("Bob", 13));
		students.add(new Student("Chip", 13));
		students.add(new Student("Tim", 14));
		
		for(Student student : students)
			System.out.println(student.name + " : " + student.age);
		
		groupByAge(students);
		
		System.out.println();
		
		for(Student student : students)
			System.out.println(student.name + " : " + student.age);
		
//		Event eventNew = new Event(1, 18);
		
//		for(Event event : events)
//			System.out.println("Start: " + event.start + ", End: " + event.end);
		
//		setDisjoint(events, eventNew);

//		events = mergeIntervals(events);
//		
//		System.out.println();
//		
//		for(Event event : events)
//			System.out.println("Start: " + event.start + ", End: " + event.end);
	
		
//		System.out.println(maxConcurrency(events));
	}
}