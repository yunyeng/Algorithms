class KnightsTour {
	
	class Vertex {
		int x;
		int y;
		boolean visited;
		public Vertex(int xPos, int yPos){
			x = xPos;
			y = yPos;
			visited = false;
		}
	}
	
	int[][] adjMatrix;
	Vertex[] vertexList;
	int n;
	
	public KnightsTour(int nVerts){
		n = nVerts;
		vertexList = new Vertex[n * n];
		adjMatrix = new int[n * n][n * n];
		for(int i=0; i<n * n; i++)
			for(int j=0; j<n * n; j++)
				adjMatrix[i][j] = 0;
		int x = 0;
		int y = 0;
		int k = 0;
		for(int i=0; i<(n * n); i++){
			if(i > 0 && (i % n) == 0){
				y = 0;
				x++;
			}
			vertexList[i] = new Vertex(x, y);
			y++;
		}
		for(int i=0; i<n * n; i++){
			for(int j=0; j<n * n; j++){
				if(legitMove(vertexList[i], vertexList[j])){
					adjMatrix[i][j] = 1;
				}
			}
		}
	}
	
	public boolean legitMove(Vertex v1, Vertex v2){
		if(v1.x == v2.x && v1.y == v2.y)
			return false;
		if(v1.x < 0 || v1.x >= n || v1.y < 0 || v1.y >= n || v2.x < 0 || v2.x >= n || v2.y < 0 || v2.y >= n)
			return false;
		int xPos = Math.abs(v1.x - v2.x);
		int yPos = Math.abs(v1.y - v2.y);
		
		if(!(xPos == 2 && yPos == 1) && !(xPos == 1 && yPos == 2))
			return false;
		
//		if(xPos > 2 || xPos < 1 || yPos > 2 || yPos < 1)
//			return false;
//		if(v2.visited)
//			return false;
		return true;
	}
	
	public int firstLegitMove(int v){
		for(int i=0; i<(n * n); i++){
			if(adjMatrix[v][i] == 1 && !vertexList[i].visited){
				return i;
			}
		}
		return -1;
	}
	
	public void dfs(int i){
		vertexList[i].visited = true;
		Stack<Integer> s = new Stack<Integer>();
		s.push(i);
		while(!s.empty()){
			System.out.print(s.length + " ");
			if(s.length == vertexList.length){
				System.out.print("WIN");
				return;
			}
			int v = firstLegitMove((int) s.peek().key);
//			System.out.println(s.peek().key);
//			System.out.println(v);
			if(v == -1){
				s.pop();
			} else {
				vertexList[v].visited = true;
				s.push(v);
			}
		}
		resetFlags();
	}
	
	public void resetFlags(){
		for(int i=0; i<vertexList.length; i++)
			vertexList[i].visited = false;
	}
	
	public static void main(String[] args) {
		int n = 8;
		KnightsTour k = new KnightsTour(n);
//		k.dfs(4);
		for(int i=0; i < n * n; i++){
			k.dfs(i);
			System.out.println();
			System.out.println();
		}
//		for(int i=0; i<64; i++)
//		System.out.println(k.vertexList[0].x + " " + k.vertexList[0].y);
//		System.out.println(k.vertexList[6].x + " " + k.vertexList[6].y);
//		for(int i=0; i<n * n; i++){
//			for(int j=0; j<n*n; j++){
//				System.out.print(k.adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}