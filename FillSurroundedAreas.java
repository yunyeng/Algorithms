import java.util.*;
class FillSurroundedAreas {
	
	public static class Map{
		int row;
		int col;
		public Map(int r, int c){
			row = r;
			col = c;
		}
	}
	
	public static void fillSurrounded(char[][] board){
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=1; i<board.length-1; i++)
			for(int j=1; j<board[i].length-1; j++)
				if(isValid(board, visited, i, j))
					fillSurrounded(board, visited, i, j);
	}
	public static boolean isValid(char[][] board, boolean[][] visited, int row, int col){
		if(board[row][col] != 'W' || visited[row][col])
			return false;
		visited[row][col] = true;
		return true;
	}
	public static void fillSurrounded(char[][] board, boolean[][] visited, int row, int col){
		List<Map> q = new ArrayList<>();
		int qInd = 0;
		q.add(new Map(row, col));
		boolean isSurrounded = true;
		while(qInd < q.size()){
			Map m = q.get(qInd++);
			if(m.row == 0 || m.col == 0 || m.row == board.length-1 || m.col == board[0].length-1){
				isSurrounded = false;
			} else {
				if(isValid(board, visited, m.row+1, m.col))
					q.add(new Map(m.row+1, m.col));
				if(isValid(board, visited, m.row, m.col+1))
					q.add(new Map(m.row, m.col+1));
				if(isValid(board, visited, m.row-1, m.col))
					q.add(new Map(m.row-1, m.col));
				if(isValid(board, visited, m.row, m.col-1))
					q.add(new Map(m.row, m.col-1));
			}
		}
		if(isSurrounded){
			for(Map m : q){
				board[m.row][m.col] = 'B';
			}
		}
	}
	
	public static void main(String[] args) {
		char[][] board = {{'B','B','B','B'},{'W','B','W','B'},{'B','W','W','B'},{'B','B','B','B'}};
		for(char[] bo : board){
			for(char b : bo){
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
		fillSurrounded(board);
		for(char[] bo : board){
			for(char b : bo){
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}