public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int m = n - 2;
		int[][] matrix = new int[n][m];
		if (n == 0)
			return matrix;
		int rows = matrix.length, lines = matrix[0].length;
		int startr = 0, startl = 0, endr = rows - 1, endl = lines - 1;
		int k = 1;
		while (startr * 2 < rows && startl * 2 < lines) {
			for (int i = startl; i <= endl; i++)
				matrix[startr][i] = k++;
			startr++;
			if (startr < endr) {
				for (int i = startr; i <= endr; i++)
					matrix[i][endl] = k++;
				endl--;
			}
			if (startr < endr && startl < endl) {
				for (int i = endl; i >= startl; i--)
					matrix[endr][i] = k++;
				endr--;
			}
			if (startr < endr && startl < endl) {
				for (int i = endr; i >= startr; i--)
					matrix[i][startl] = k++;
				startl++;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = generateMatrix(5);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
