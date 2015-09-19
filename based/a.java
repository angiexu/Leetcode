package based;

public class a {
	public static int[][] matrix(int m, int n, String str) {
		int[][] matrix = new int[m][n];
		int i = 0, j = 0;
		for (int s = 0; s < str.length() && i < m; s++) {
			while (s < str.length()
					&& (str.charAt(s) == '[' || str.charAt(s) == ']' || str
							.charAt(s) == ','))
				s++;
			matrix[i][j] = str.charAt(s) - '0';
			s++;
			j++;
			if (j == n) {
				j = 0;
				i++;
			}
		}
		return matrix;
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = { -10, -7, -3, -9, -8, -9, -5, 6, 0, 6, 4, -15, -12, 3, -12,
				-10, -5, -5, 2, -4, 13, 8, -9, 6, -11, 11, 3, -13, -3, 14, -9,
				2, 14, -5, 8, -9, -7, -12, 5, 1, 2, -6, 1, 5, 4, -4, 3, 7, -2,
				12, 10, -3, 6, -14, -12, 10, 12, 7, 12, -14, -2, 11, 4, -10,
				13, -11, -4, -8, -15, -14, 8, -6, -12, -14, 6, 7, -3, -14, -1,
				11, 14, -6, -15, 5, -13, -12, 0, 14, 2, -11, -14, 8, -15, -3,
				13, 14, -7, -14, 13, -15, 10, -2, -14, 13 };
		System.out.println(s.length);
		String str = "[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1]]";
		int[][] mat = matrix(5, 4, str);
		print(mat);
	}

}
