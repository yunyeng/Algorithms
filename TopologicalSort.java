import java.util.*;
class TopologicalSort {
	
	public static class Node {
		String name;
		List<Node> neighbors;
		int inline;
		int outline;
		boolean visited;
		public Node(String n){
			name = n;
			inline = 0;
			outline = 0;
			neighbors = new ArrayList<>();
			visited = false;
		}
		public void add(Node n){
			n.inline++;
			neighbors.add(n);
			outline++;
		}
	}
	
	public static class Map {
		int row;
		int col;
		Map prev;
		boolean flag;
		public Map(int r, int c, Map p){
			row = r;
			col = c;
			prev = p;
			flag = false;
		}
	}
	
	public static boolean isValidMove(int[][] maze, int row, int col){
		if(row < 0 || col < 0)
			return false;
		if(row >= maze.length || col >= maze[0].length)
			return false;
		if(maze[row][col] != 0)
			return false;
		maze[row][col] = 2;
		return true;
	}
	public static void escapeMaze(int[][] maze, Map start, Map end){
		Queue<Map> q = new Queue<>();
		if(isValidMove(maze, start.row, start.col))
			q.enqueue(start);
		else
			return;
		Map m = null;
		int count = 0;
		while(!q.isEmpty()){
			m = q.dequeue();
			
//			System.out.println(m.flag);
//			if(m.flag){
//				count++;
//				m = q.dequeue();
//			}
			if(m.row == end.row && m.col == end.col)
				count++;
			
			if(isValidMove(maze, m.row+1, m.col))
				q.enqueue(new Map(m.row+1, m.col, m));
			if(isValidMove(maze, m.row, m.col+1))
				q.enqueue(new Map(m.row, m.col+1, m));
			if(isValidMove(maze, m.row-1, m.col))
				q.enqueue(new Map(m.row-1, m.col, m));
			if(isValidMove(maze, m.row, m.col-1))
				q.enqueue(new Map(m.row, m.col-1, m));
			
//			Map m1 = new Map(0, 0, null);
//			m1.flag = true;
//			q.enqueue(m1);
		}
		System.out.println(count);
//		m = reverse(m);
//		while(m != null){
//			System.out.println(m.row+"."+m.col);
//			m = m.prev;
//		}
	}
	
	public static Map reverse(Map h){
		if(h == null || h.prev == null)
			return h;
		Map newHead = reverse(h.prev);
		h.prev.prev = h;
		h.prev = null;
		return newHead;
	}
	
	public static Node firstZero(List<Node> vertices){
		for(Node v : vertices)
			if(v.inline == 0 && !v.visited)
				return v;
		return null;
	}
	
	public static void sort(List<Node> vertices){
		Queue<Node> q = new Queue<>();
		q.enqueue(firstZero(vertices));

		while(!q.isEmpty()){
			Node v = q.dequeue();
			if(v == null)
				break;
			System.out.print(v.name + " ");
			v.visited = true;
			for(Node neighbor : v.neighbors){
				neighbor.inline--;
			}
			q.enqueue(firstZero(vertices));
		}
	}
	
	public static void main(String[] args) {
//		Node n1 = new Node("A");
//		Node n2 = new Node("B");
//		Node n3 = new Node("C");
//		Node n4 = new Node("D");
//		Node n5 = new Node("E");
//		Node n6 = new Node("F");
//		Node n7 = new Node("G");
//		Node n8 = new Node("H");
//
//		n1.add(n3);
//		n2.add(n3);
//		n2.add(n4);
//		n3.add(n5);
//		n4.add(n6);
//		n5.add(n6);
//		n5.add(n8);
//		n6.add(n7);
//		n2.add(n1);
//		
//		List<Node> vertices = new ArrayList<>();
//		vertices.add(n1);
//		vertices.add(n2);
//		vertices.add(n3);
//		vertices.add(n4);
//		vertices.add(n5);
//		vertices.add(n6);
//		vertices.add(n7);
//		vertices.add(n8);
//		
//		sort(vertices);
		
		int[][] maze = new int[4][4];
		maze[0][1] = 1;
		maze[0][2] = 1;
		maze[0][3] = 1;
//		maze[1][2] = 1;
		maze[1][3] = 1;
		maze[3][0] = 1;
		maze[3][1] = 1;
		maze[3][2] = 1;
//		maze[1][1] = 1;
//		maze[1][2] = 1;
//		maze[2][2] = 1;
//		maze[3][3] = 1;
//		maze[1][5] = 1;
//		maze[2][5] = 1;
//		maze[5][1] = 1;
//		maze[6][1] = 1;
//		maze[6][2] = 1;
//		maze[5][4] = 1;
//		maze[5][5] = 1;
//		maze[5][6] = 1;
//		maze[6][7] = 1;
		
		escapeMaze(maze, new Map(0, 0, null), new Map(3, 3, null));
	}
}