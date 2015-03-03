class MatrixSearch {
	
	public static boolean search(int[][] matrix, int target){
		int row = 0;
		int col = matrix[0].length-1;
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == target){
				return true;
			} else if(matrix[row][col] > target){
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
		System.out.print(search(arr, 80));
	}
	
}