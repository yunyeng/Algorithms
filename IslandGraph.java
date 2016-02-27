import java.util.*;
public class IslandGraph {
	public class Map {
		int row;
		int col;
		public Map(int r, int c){
			row = r;
			col = c;
		}
	}
	public boolean isValid(char[][] grid, boolean[][] visited, int i, int j){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return false;
		if(grid[i][j] == '0' || visited[i][j])
			return false;
		visited[i][j] = true;
		return true;
	}
	public void isIsland(char[][] grid, boolean[][] visited, int row, int col){
		Queue<Map> queue = new Queue<>();
		queue.enqueue(new Map(row, col));
		while(!queue.isEmpty()){
			Map m = queue.dequeue();
			if(isValid(grid, visited, m.row+1, m.col))
				queue.enqueue(new Map(m.row+1, m.col));
			if(isValid(grid, visited, m.row, m.col+1))
				queue.enqueue(new Map(m.row, m.col+1));
			if(isValid(grid, visited, m.row-1, m.col))
				queue.enqueue(new Map(m.row-1, m.col));
			if(isValid(grid, visited, m.row, m.col-1))
				queue.enqueue(new Map(m.row, m.col-1));
		}
//		return true;
	}
	public int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid.length];
		for(int i=0; i<grid.length; i++)
			visited[i] = new boolean[grid[i].length];
		int count = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(isValid(grid, visited, i, j)){
					isIsland(grid, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args){
		IslandGraph ig = new IslandGraph();
//		11000
//		11000
//		00100
//		00011
		char[][] island = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(ig.numIslands(island));
	}
}