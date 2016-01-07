import java.util.*;
class Graph implements Cloneable{
	
	class Vertex{
		int label;
		int d = 0;
		int color = 0;
		int count = 0;
		Vertex p = null;
		int f = 0;
		public Vertex(int label){
			this.label = label;
		}
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}  

	int vertices;
	int edges = 0;
	int time;
	int count = 0;
	int adjCount = 0;
	char directed;
	LinkedList<Vertex> LL = new LinkedList<Vertex>();
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	ArrayList<Vertex> vertex = new ArrayList<Vertex>();
	
	
	public Graph(int v, char d){
		this.vertices = v;
		this.directed = d;
		for(int i=0; i<this.vertices; i++){
			this.vertex.add(new Vertex(i));
			this.adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v, int w){
		this.adj.get(v).add(w);
		if(directed == 'u'){
			this.adj.get(w).add(v);	
		}
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
	
		
	public LinkedList<Vertex> topSort(){
		this.dfs();
		return LL;
	}
	
	public void dfs(){
		time = 0;
		for(Vertex u : vertex)
			if(u.color == 0)
				dfsVisit(u);
	}
	
	public void dfsVisit(Vertex u){
		time++;
		u.color = 1;
		u.d = time;
		for(Integer a : adj.get(u.label)){
			Vertex v = vertex.get(a);
			if(v.color == 0){
				v.p = u;
				dfsVisit(v);
			}
		}
		u.color = 2;
		time++;
		u.f = time;
		LL.addFirst(u);
	}
	
	public void transpose(){
		ArrayList<ArrayList<Integer>> newAdj = new ArrayList<ArrayList<Integer>>();
		for(Vertex u : vertex){
			for(Integer a : adj.get(u.label)){
				newAdj.add(new ArrayList<Integer>());
			}
		}
		newAdj.add(new ArrayList<Integer>());
		//System.out.print(newAdj);
		for(Vertex u : vertex){
			for(Integer a : adj.get(u.label)){
				newAdj.get(a).add(u.label);
			}
		}
		this.adj = newAdj;
	}
	
	public boolean isThereCycle(){
		for(Vertex s : vertex){
			if(s.color == 0){
				s.color = 1;
				s.d = 0;
				Queue<Vertex> Q = new LinkedList<Vertex>();
				Q.add(s);
				while(!Q.isEmpty()){
					Vertex u = Q.remove();
					for(Integer a : adj.get(u.label)){
						Vertex v = vertex.get(a);
						if(v.color == 0){
							v.color = 1;
							v.d = u.d + 1;
							v.p = u;
							Q.add(v);
						} else {
							return true;
						}
					}
					u.color = 2;
				}		
			}
		}
		return false;
	}
	
	public void dfsNon(){
		time = 0;
		ArrayDeque<Vertex> S = new ArrayDeque<Vertex>();
		Vertex v0 = vertex.get(0);
		S.push(v0);
		while(!S.isEmpty()){
			Vertex v = S.pop();
			if(v.color == 0){
				v.color = 1;
				time++;
				v.d = time;
				for(Integer a : adj.get(v.label)){
					Vertex r = vertex.get(a);
					r.p = v;
					S.push(r);
				}	
			} else {
				v.color = 2;
				time++;
				v.f = time;
			}
		}
	}
	
	/*
	2		let S be a stack
	3      S.push(v)
	4      while S is not empty
	5            v ← S.pop() 
	6            if v is not labeled as discovered:
	7                label v as discovered
	8                for all edges from v to w in G.adjacentEdges(v) do
	9                    S.push(w)
	*/
	
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
		
		Graph g = new Graph(14, 'd');
		
		g.addEdge(0,4);
		g.addEdge(0,5);
		g.addEdge(0,11);
		g.addEdge(1,2);
		g.addEdge(1,4);
		g.addEdge(1,8);
		g.addEdge(2,5);
		g.addEdge(2,6);
		g.addEdge(2,9);
		g.addEdge(3,2);
		g.addEdge(3,6);
		g.addEdge(3,13);
		g.addEdge(4,7);
		g.addEdge(5,8);
		g.addEdge(5,12);
		g.addEdge(6,5);
		g.addEdge(8,7);
		g.addEdge(9,10);
		g.addEdge(9,11);
		g.addEdge(10,13);
		g.addEdge(12,9);
		
		
		
		
		/*
		Graph g = new Graph(10, 'd');
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(3,6);
		g.addEdge(4,5);
		g.addEdge(5,7);
		g.addEdge(5,8);
		g.addEdge(8,9);
		*/
		//g.addEdge(9,6);
		
		
		try {  
			Graph g2 = (Graph)g.clone();
			g2.transpose();
			System.out.println(g2.adj);
		}catch(CloneNotSupportedException c){}  
		
		
		//System.out.println(g.isThereCycle());
			
		/*Graph g = new Graph(10, 'd');
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(0,6);
		g.addEdge(1,4);
		g.addEdge(1,8);
		g.addEdge(2,5);
		g.addEdge(3,7);
		g.addEdge(3,8);
		g.addEdge(4,8);
		g.addEdge(5,6);
		g.addEdge(6,2);
		g.addEdge(7,9);
		g.addEdge(8,0);
		g.addEdge(9,7);
		*/
		//g.dfsNon();
		//g.topSort(g.vertex);
		//for(Vertex v : g.LL){
		//System.out.println(v.label);
		//}
		
		
		//System.out.println(g.vertex.get(4).p.label);
			
	}
}