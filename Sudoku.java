class Sudoku {
	
	private int ROWS, COLS;
	public int[][] grid;
	public Sudoku(int n){
		ROWS = COLS = n;
		grid = new int[n][n];
	}
	
	private boolean checkCols(int col, int key){
		for(int row = 0; row<ROWS; row++)
			if(grid[row][col] == key)
				return false;
		return true;
	}
	
	private boolean checkRows(int row, int key){
		for(int col = 0; col<COLS; col++)
			if(grid[row][col] == key)
				return false;
		return true;
	}
	
	public static void spiralOrder(int[][] matrix, int start, int end, int n){
		if(n < Math.ceil(0.5 * matrix.length)){
			int a;
			for(a = start; a < end; a++)
				System.out.print(matrix[start][a] + " ");
			for(a = start; a < end; a++)
				System.out.print(matrix[a][end] + " ");
			for(a = end; a > start; a--)
				System.out.print(matrix[end][a] + " ");
			for(a = end; a > start; a--)
				System.out.print(matrix[a][start] + " ");
			spiralOrder(matrix, start+1, end-1, n+1);
		} else {
			if(matrix.length % 2 != 0)
				System.out.print(matrix[start-1][end+1] + " ");
		}
	}
	
	public void display(){
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		int n = 9;
//		Sudoku s = new Sudoku(9);
//		int[][] g = new int[n][n];
//		
//		s.fillSudoku();
//		s.display();

//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//		int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		spiralOrder(matrix, 0, matrix.length-1, 0);
		
	}
}