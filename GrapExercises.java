import java.util.*;
class GrapExercises {
	
	public static class Map{
		String name;
		int distance;
		public Map(String n, int d){
			name = n;
			distance = d;
		}
	}
	
	public static int shortestString(String s, String t, HashSet<String> dict){
		Queue<Map> q = new Queue<>();
		q.enqueue(new Map(s, 0));
		dict.remove(s);
		while(!q.isEmpty()){
			Map m = q.dequeue();
			if(t.equals(m.name))
				return m.distance+1;
			for(int i=0; i<m.name.length(); i++){
				for(int j=0; j<26; j++){
					char[] arr = m.name.toCharArray();
					arr[i] = (char)('a' + j);
					String str2 = new String(arr);
					if(dict.remove(str2)){
						q.enqueue(new Map(str2, m.distance + 1));
					}
				}
			}
		}
		return 0;
	}
	
	public static class Vertex {
		char label;
		int inline;
		int outline;
		int maxDistance;
		boolean visited;
		List<Vertex> edges;
		public Vertex(char l){
			label = l;
			inline = 0;
			outline = 0;
			visited = false;
			maxDistance = 1;
			edges = new ArrayList<>();
		}
		public void addEdge(Vertex v){
			edges.add(v);
			v.inline++;
			outline++;
		}
	}
	public static Vertex firstZero(List<Vertex> vertices){
		for(Vertex vertice : vertices)
			if(vertice.inline == 0 && !vertice.visited)
				return vertice;
		return null;
	}
	public static List<Vertex> topoSort(List<Vertex> G){
		List<Vertex> queue = new ArrayList<>();
		queue.add(firstZero(G));
		int qInd = 0;
		while(qInd < G.size()){
			Vertex v = G.get(qInd++);
			if(v == null)
				break;
			v.visited = true;
			for(Vertex u : v.edges)
				u.inline--;
			queue.add(firstZero(G));
		}
		return queue;
	}
	
	public static int findLongestPath(List<Vertex> ordered){
		int max = 0;
		while(!ordered.isEmpty()){
			Vertex v = ordered.get(0);
			max = Math.max(max, v.maxDistance);
			for(Vertex u : v.edges)
				u.maxDistance = Math.max(u.maxDistance, v.maxDistance + 1);
			ordered.remove(0);
		}
		return max;
	}
	
	
	public static void main(String[] args) {
//		HashSet<String> dict = new HashSet<>();
//		dict.add("bat");
//		dict.add("cot");
//		dict.add("dog");
//		dict.add("dag");
//		dict.add("dot");
//		dict.add("cat");
//		
//		System.out.println(shortestString("dot", "cat", dict));
		List<Vertex> graph = new ArrayList<Vertex>();
		graph.add(new Vertex('D'));
		graph.add(new Vertex('C'));
		graph.add(new Vertex('B'));
		graph.add(new Vertex('F'));
		graph.add(new Vertex('E'));
		graph.add(new Vertex('A'));
		graph.get(0).addEdge(graph.get(1));
		graph.get(0).addEdge(graph.get(2));
		graph.get(1).addEdge(graph.get(2));
		graph.get(1).addEdge(graph.get(4));
		graph.get(2).addEdge(graph.get(3));
		graph.get(2).addEdge(graph.get(4));
		graph.get(2).addEdge(graph.get(5));
		graph.get(3).addEdge(graph.get(4));
		graph.get(3).addEdge(graph.get(5));
		graph.get(4).addEdge(graph.get(5));
		
		List<Vertex> sorted = topoSort(graph);
		for(int i=0; i<sorted.size(); i++)
			if(sorted.get(i) == null)
				sorted.remove(i);
		for(Vertex v : sorted)
			System.out.print(v.label + "-");
		System.out.println();
		System.out.println(findLongestPath(sorted));
	}
}