class pascalTriangle {
	
	public static void drawTriangle(int n){
		int[][] tri = new int[n][n];
		
		for(int i=0; i<n; i++){
			for(int k=i; k<n; k++)System.out.print(" ");
			for(int j=0; j<=i; j++){
				if(i==0 || j==0) tri[i][j] = 1;
				else tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
				System.out.print(tri[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		drawTriangle(4);
		drawTriangle(6);
		drawTriangle(8);
	}
}