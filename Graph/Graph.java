class Graph {
	
	private int maxVerts;
	private int nVisited;
	private final int INFINITY = 9999999;
	
	private Vertex[] vertexList;
	public Vertex[] sortedVer;
	private DistPar[] sPath;
	
	private int[][] adjMat;
	private int nVerts;
	private Heap h;
	
	public DistPar[][] distances;
	
	private boolean directed;
	
	public Graph(int n, boolean d){
		directed = d;
		maxVerts = n;
		nVerts = 0;
		h = new Heap(n);
		vertexList = new Vertex[n];
		adjMat = new int[n][n];
		distances = new DistPar[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				adjMat[i][j] = INFINITY;
				distances[i][j] = new DistPar(INFINITY, j);
			}
		}
		sortedVer = new Vertex[n];
		sPath = new DistPar[n];
	}
	
	public void addVertex(String s){
		vertexList[nVerts++] = new Vertex(s);
	}
	
	public void addEdge(int s, int e){
		adjMat[s][e] = 1;
		if(!directed)
			adjMat[e][s] = 1;
	}
	
	public void addEdge(int s, int e, int w){
		adjMat[s][e] = w;
		if(!directed)
			adjMat[e][s] = w;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].name);
	}
	
	public void path(int s){
		vertexList[s].visited = true;
		nVisited++;
		for(int i=0; i<nVerts; i++)
			sPath[i] = new DistPar(adjMat[s][i], s);
		while(nVisited < nVerts){
			int indexMin = getMin();
			int minDist = sPath[indexMin].distance;
			if(minDist == INFINITY){
				System.out.println("There are unreachable vertices!");
				break;
			}
			vertexList[indexMin].visited = true;
			nVisited++;
			adjustPaths(indexMin, minDist, s);
		}
		displayPaths(s);
		nVisited = 0;
		resetFlags();
	}
	
	public int getMin(){
		int minDist  = INFINITY;
		int indexMin = 0;
		for(int i=0; i<nVerts; i++){
			if(i != sPath[i].parent && !vertexList[i].visited && sPath[i].distance < minDist){
				minDist  = sPath[i].distance;
				indexMin = i;
			}
		}
		return indexMin;
	}
	
	public void adjustPaths(int current, int startToCurrent, int s){
		int column = 0;
		while(column < nVerts){
			if(column == s){
				column++;
				continue;
			}
			int currentToFringe = adjMat[current][column];
			int startToFringe   = startToCurrent + currentToFringe;
			int sPathDist       = sPath[column].distance;
			if(startToFringe < sPathDist){
				sPath[column].parent   = current;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}
	
	public void displayPaths(int j){
		for(int i=0; i<nVerts; i++){
			System.out.print(vertexList[i].name + " = ");
			distances[j][i] = sPath[i];
			if(sPath[i].distance == INFINITY)
				System.out.print("inf");
			else
				System.out.print(sPath[i].distance);
			System.out.print("("+vertexList[sPath[i].parent].name+") ");
		}
		System.out.println();
	}
	
	public void dfs(int start){
		vertexList[start].visited = true;
		displayVertex(start);
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		while(!s.empty()){
			int v = getAdjUnvisitedVertex((int) s.peek().key);
			if(v == -1){
				s.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(v);
				s.push(v);
			}
		}
		resetFlags();
	}
	
	// Topological Sorting
	public void topoSort(){
		while(nVerts > 0){
			int current = noSuccessors();
			if(current == -1){
				System.out.println("Graph has cycles!");
				return;
			}
			sortedVer[nVerts-1] = vertexList[current];
			deleteVertex(current);
		}
		System.out.println("Topologically sorted order: ");
		for(int i=0; i<sortedVer.length; i++)
			System.out.print(sortedVer[i].name + ", ");
		System.out.println();
	}
	
	private int noSuccessors(){
		int i, j;
		for(i=0; i<nVerts; i++){
			for(j=0; j<nVerts; j++){
				if(adjMat[i][j] != INFINITY && adjMat[i][j] > 0){
					break;
				}
			}
			if(j == nVerts){
				return i;
			}
		}
		return -1;
	}
	
	public void deleteVertex(int index){
		if(index != nVerts-1){
			for(int i=index; i<nVerts-1; i++)
				vertexList[i] = vertexList[i+1];
			for(int row=index; row<nVerts-1; row++)
				moveRowUp(row, nVerts);
			for(int col=index; col<nVerts-1; col++)
				moveColLeft(col, nVerts-1);
		}
		nVerts--;
	}
	
	private void moveRowUp(int row, int n){
		for(int col=0; col<n; col++)
			adjMat[row][col] = adjMat[row+1][col];
	}
	
	private void moveColLeft(int col, int n){
		for(int row=0; row<n; row++)
			adjMat[row][col] = adjMat[row][col+1];
	}
	
	public void bfs(int start){
		vertexList[start].visited = true;
		displayVertex(start);
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(start);
		int v2;
		while(!q.isEmpty()){
			int v1 = (int) q.dequeue().key;
			v2 = getAdjUnvisitedVertex(v1);
			while(v2 != -1){
				vertexList[v2].visited = true;
				displayVertex(v2);
				q.enqueue(v2);
				v2 = getAdjUnvisitedVertex(v1);
			}
		}
		resetFlags();
	}
	
	private int getAdjUnvisitedVertex(int v){
		for(int i=0; i<nVerts; i++)
			if(!vertexList[i].visited && adjMat[v][i] == 1)
				return i;
		return -1;
	}
	
	public void resetFlags(){
		for(int i=0; i<nVerts; i++)
			vertexList[i].visited = false;
	}
	
	// Minimum Spanning Tree
	public void minSpanTree(){
		vertexList[0].visited = true;
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		while(!s.empty()){
			int current = (int) s.peek().key;
			int v = getAdjUnvisitedVertex(current);
			if(v == -1){
				s.pop();
			} else {
				vertexList[v].visited = true;
				displayVertex(current);
				displayVertex(v);
				System.out.print(" ");
				s.push(v);
			}
		}
		resetFlags();
	}
	
	// Minimum Spanning Tree with Weights
	public void minSpanTreeW(){
		int current = 0;
		while(nVisited < nVerts - 1){
			vertexList[current].visited = true;
			nVisited++;
			for(int i=0; i<nVerts; i++){
				if(i == current)
					continue;
				if(vertexList[i].visited)
					continue;
				int distance = adjMat[current][i];
				if(distance == INFINITY)
					continue;
				putInPQ(current, i, distance);
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
		resetFlags();
	}
	
	public void putInPQ(int c, int newVert, int newDist){
		int index = h.find(newVert);
//		System.out.println("Index: " + index);
		if(index == -1){
			h.insert(new Edge(c, newVert, newDist));
		} else {
			Edge e = h.peekN(index);
			int oldDist = e.weight;
			if(oldDist > newDist){
				h.remove(index);
				h.insert(new Edge(c, newVert, newDist));
			}
		}
	}
	
	public void floyds(){
		for(int i=0; i<nVerts; i++){
			path(i);
		}
		
		for(int row=0; row<nVerts; row++){
			for(int col=0; col<nVerts; col++){
				if(distances[row][col].distance < INFINITY){
					for(int z=0; z<nVerts; z++){
						if(z != col){
							if(distances[z][col].distance == INFINITY || 
							  (distances[z][row].distance + distances[row][col].distance) < distances[z][col].distance){
								distances[z][col].distance = distances[z][row].distance + distances[row][col].distance;
							}
						}
					}
				}
			}
		}
		
		
		
		for(int i=0; i<nVerts; i++){
			for(int j=0; j<nVerts; j++){
				if(distances[i][j].distance == INFINITY)
					System.out.print(" - ");
				else 
					System.out.print(distances[i][j].distance + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		Graph g = new Graph(6, false);
//		g.addVertex("A"); // 0
//		g.addVertex("B"); // 1
//		g.addVertex("C"); // 2
//		g.addVertex("D"); // 3
//		g.addVertex("E"); // 4
//		g.addVertex("F"); // 5
//		
//		g.addEdge(0, 1, 6);
//		g.addEdge(0, 3, 4);
//		g.addEdge(1, 2, 10);
//		g.addEdge(1, 3, 7);
//		g.addEdge(1, 4, 7);
//		g.addEdge(2, 3, 8);
//		g.addEdge(2, 4, 5);
//		g.addEdge(2, 5, 6);
//		g.addEdge(3, 4, 12);
//		g.addEdge(4, 5, 7);
//		
//		g.minSpanTreeW();

//		Graph g = new Graph(5, true);
//		g.addVertex("A"); // 0
//		g.addVertex("B"); // 1
//		g.addVertex("C"); // 2
//		g.addVertex("D"); // 3
//		g.addVertex("E"); // 4
//		
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(0, 3);
//		g.addEdge(0, 4);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(1, 4);
//		g.addEdge(2, 3);
//		g.addEdge(2, 4);
//		g.addEdge(3, 4);
//		
//		g.minSpanTree();

//		Graph g = new Graph(8, true);
//		g.addVertex("A"); // 0
//		g.addVertex("B"); // 1
//		g.addVertex("C"); // 2
//		g.addVertex("D"); // 3
//		g.addVertex("E"); // 4
//		g.addVertex("F"); // 5
//		g.addVertex("G"); // 6
//		g.addVertex("H"); // 7
//		
//		g.addEdge(0, 3);
//		g.addEdge(0, 4);
//		g.addEdge(1, 4);
//		g.addEdge(2, 5);
//		g.addEdge(3, 6);
//		g.addEdge(4, 6);
//		g.addEdge(5, 7);
//		g.addEdge(6, 7);
//		
//		g.topoSort();

//		Graph g = new Graph(9, true);
//		g.addVertex("San Francisco");   // 0
//		g.addVertex("Los Angeles");     // 1
//		g.addVertex("San Diego");       // 2
//		g.addVertex("Santa Barbara");   // 3
//		g.addVertex("San Luis Obispo"); // 4
//		g.addVertex("Santa Cruz");      // 5
//		g.addVertex("Monterey");        // 6
//		g.addVertex("Napa Valley");     // 7
//		g.addVertex("San Jose");        // 8
//		
//		g.addEdge(0, 1, 383);
//		g.addEdge(0, 3, 325);
//		g.addEdge(0, 4, 231);
//		g.addEdge(0, 5, 73);
//		g.addEdge(0, 7, 59);
//		g.addEdge(0, 8, 48);
//		g.addEdge(1, 2, 120);
//		g.addEdge(1, 7, 412);
//		g.addEdge(3, 2, 215);
//		g.addEdge(3, 1, 95);
//		g.addEdge(4, 3, 95);
//		g.addEdge(8, 5, 42);
//		g.addEdge(8, 7, 98);
//		
//		g.path(0);

		Graph g = new Graph(5, true);
		g.addVertex("A");   // 0
		g.addVertex("B");     // 1
		g.addVertex("C");       // 2
		g.addVertex("D");   // 3
		g.addVertex("E"); // 4
		
		g.addEdge(0, 1, 30);
		g.addEdge(0, 3, 80);
		g.addEdge(1, 2, 60);
		g.addEdge(1, 3, 90);
		g.addEdge(2, 4, 40);
		g.addEdge(3, 2, 20);
		g.addEdge(3, 4, 70);
		g.addEdge(4, 1, 50);
		
//		g.path(0);
		g.floyds();

	}
}