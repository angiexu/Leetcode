public class RangeSumQuery2DImmutable {
	public static void print(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	public static int[][] matrixs(int m, int n, String str) {
		int[][] matrix = new int[m][n];
		int i = 0, j = 0;
		for (int s = 0; s < str.length() && i < m; s++) {
			while (s < str.length()
					&& (str.charAt(s) == '[' || str.charAt(s) == ']'
							|| str.charAt(s) == ',' || str.charAt(s) == ' '))
				s++;
			int num = str.charAt(s) - '0';
			s++;
			while (s < str.length() && str.charAt(s) - '0' >= 0
					&& str.charAt(s) - '0' <= 9) {
				num = num * 10 + (str.charAt(s) - '0');
				s++;
			}
			matrix[i][j] = num;
			j++;
			if (j == n) {
				j = 0;
				i++;
			}
		}
		return matrix;
	}

	public static class NumMatrix {
		int[][] sums;

		public NumMatrix(int[][] matrix) {
			if (matrix.length != 0) {
				sums = new int[matrix.length][matrix[0].length];
				for (int j = 0; j < matrix.length; j++) {
					System.arraycopy(matrix[j], 0, sums[j], 0, matrix[0].length);
					for (int i = 1; i < matrix[0].length; i++) {
						sums[j][i] += sums[j][i - 1];
					}
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			if (col1 == 0)
				for (int i = row1; i <= row2; i++)
					sum = sum + sums[i][col2];
			else
				for (int i = row1; i <= row2; i++)
					sum = sum + sums[i][col2] - sums[i][col1 - 1];
			return sum;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "[[-5,5]]";
		int[][] matrix = matrixs(1, 2, str);
		print(matrix);
		System.out.println();
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 0, 0, 1));
		System.out.println(numMatrix.sumRegion(0, 1, 0, 1));
	}
}
