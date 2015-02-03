import java.util.*;
class Graph {
	
	class Vertex{
		int label;
		int d = 0;
		int color = 0;
		Vertex p = null;
		int f = 0;
		public Vertex(int label){
			this.label = label;
		}
	}

	int vertices;
	int edges = 0;
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	ArrayList<Vertex> vertex = new ArrayList<Vertex>();
	
	
	public Graph(int v){
		this.vertices = v;
		for(int i=0; i<this.vertices; i++){
			this.vertex.add(new Vertex(i));
			this.adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v, int w){
		this.adj.get(w).add(v);
		this.adj.get(v).add(w);
		this.edges++;
	}
	
	public void bfs(){
		Vertex s = this.vertex.get(0);
		s.color = 1;
		s.d = 0;
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(s);
		while(!Q.isEmpty()){
			Vertex u = Q.remove();
			//ArrayList a = adj.get(u.label);
			for(Integer a : adj.get(u.label)){
				Vertex v = vertex.get(a);
				if(v.color == 0){
					v.color = 1;
					v.d = u.d + 1;
					v.p = u;
					Q.add(v);
				}
			}
			u.color = 2;
		}
	}
	
	public String show(){
		String result = "";
		for (int i = 0; i < this.vertices; ++i){
			result += i + " -> "; 
			for (int j = 0; j < this.adj.get(i).size(); ++j){
				if(this.adj.get(i).get(j) != null){
					result += this.adj.get(i).get(j) + " ";
				}
			}
			result += '\n';
		}
		return result;
	}
	
	public static void main(String[] args) {	
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.bfs();
		
		System.out.println(g.vertex.get(4).d);
			
	}
}