class RowColSearch {
	
	public static int[] search(int matrix[][], int target){
		int[] indices = new int[2];
		indices[0] = -1;
		indices[1] = -1;
		int row = 0;
		int col = matrix[0].length-1;
		while(row < matrix.length && col > -1){
			if(matrix[row][col] == target){
				indices[0] = row;
				indices[1] = col;
				return indices;
			} else if(matrix[row][col] > target){
				col--;
			} else {
				row++;
			}
		}
		return indices;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		int[] indices = search(matrix, 13);
		for(int i=0; i<2; i++){
			System.out.println(indices[i]);
		}
		
	}
}