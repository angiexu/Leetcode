public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;
		int rows = n, columns = n;
		int rs = 0, cs = 0;
		int num = n * n, k = 1;
		while (k <= num) {
			for (int i = cs; i < columns && k <= num; i++) {
				matrix[rs][i] = k;
				k++;
			}
			rs++;
			for (int i = rs; i < rows && k <= num; i++) {
				matrix[i][columns - 1] = k;
				k++;
			}
			columns--;
			for (int i = columns - 1; i >= cs && k <= num; i--) {
				matrix[rows - 1][i] = k;
				k++;
			}
			rows--;
			for (int i = rows - 1; i >= rs && k <= num; i--) {
				matrix[i][cs] = k;
				k++;
			}
			cs++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = generateMatrix(3);
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				System.out.println(matrix[i][j]);
	}

}
