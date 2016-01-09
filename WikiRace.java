class WikiRace {
	public static void main(String[] args) {
		Graph g = new Graph(5, 'd');
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,0);
		g.bfs();
		System.out.println(g.vertex.get(3).d);
	}
}