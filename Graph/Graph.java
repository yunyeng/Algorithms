class Graph {
	
	private int maxVerts;
	private final int INFINITY = 9999999;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts;
	boolean directed;
	
	private Heap h;
	private int current;
	private int nFlagged;
	
	public Graph(int n, boolean d){
		directed = d;
		maxVerts = n;
		nVerts = 0;
		h = new Heap(n);
		vertexList = new Vertex[n];
		adjMat = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				adjMat[i][j] = INFINITY;
	}
	
	public void addVertex(String s){
		vertexList[nVerts++] = new Vertex(s);
	}
	
	public void addEdge(int s, int e, int w){
			adjMat[s][e] = w;
		if(!directed)
			adjMat[e][s] = w;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].name);
	}
	
	public void minSpanTreeW(){
		current = 0;
		nFlagged = 0;
		while(nFlagged < nVerts - 1){
			vertexList[current].visited = true;
			nFlagged++;
			for(int i=0; i<nVerts; i++){
				if(i == current)
					continue;
				if(vertexList[i].visited)
					continue;
				int distance = adjMat[current][i];
				if(distance == INFINITY)
					continue;
				putInPQ(i, distance);
			}
			if(h.size() == 0){
				System.out.println("Graph not connected!");
				return;
			}
			Edge e = h.remove();
			current = e.dest;
			System.out.print(vertexList[e.src].name + " -> ");
			System.out.print(vertexList[current].name);
			System.out.println();
		}
	}
	
	public void putInPQ(int newVert, int newDist){
		int index = h.find(newVert);
//		System.out.println("Index: " + index);
		if(index == -1){
			h.insert(new Edge(current, newVert, newDist));
		} else {
			Edge e = h.peekN(index);
			int oldDist = e.weight;
			if(oldDist > newDist){
				h.remove(index);
				h.insert(new Edge(current, newVert, newDist));
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6, false);
		g.addVertex("A"); // 0
		g.addVertex("B"); // 1
		g.addVertex("C"); // 2
		g.addVertex("D"); // 3
		g.addVertex("E"); // 4
		g.addVertex("F"); // 5
		
		g.addEdge(0, 1, 6);
		g.addEdge(0, 3, 4);
		g.addEdge(1, 2, 10);
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 7);
		g.addEdge(2, 3, 8);
		g.addEdge(2, 4, 5);
		g.addEdge(2, 5, 6);
		g.addEdge(3, 4, 12);
		g.addEdge(4, 5, 7);
		
		g.minSpanTreeW();
	}
}