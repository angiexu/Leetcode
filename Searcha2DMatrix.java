public class Searcha2DMatrix {
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

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		if (matrix[0][0] > target || matrix[m - 1][n - 1] < target)
			return false;
		boolean bo = false;
		int i = 0, j = 0;
		for (; i < m; i++) {
			if (matrix[i][0] > target)
				break;
		}
		i--;
		if (i < 0)
			i++;
		for (; j < n; j++) {
			if (matrix[i][j] == target) {
				bo = true;
				break;
			}
		}
		return bo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "[[1],[3]]";
		int[][] matrix = matrixs(2, 1, str);
		print(matrix);
		int target = 3;
		System.out.println(searchMatrix(matrix, target));

	}

}
