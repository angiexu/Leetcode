public class SurroundedRegions {
	public static void print(char[][] matrix) {
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

	// public static void solve(int[][] board) {
	// if (board.length == 0)
	// return;
	// int m = board.length, n = board[0].length;
	// for (int i = 0; i < m; i++) {
	// for (int j = 0; j < n; j++)
	// if (board[i][j] == 'O') {
	// boolean bo = true;
	// int k = 0;
	// // 上
	// for (k = i - 1; k >= 0 && bo == true; k--)
	// if (board[k][j] == 'X')
	// break;
	// if (k < 0)
	// bo = false;
	// // 下
	// for (k = i + 1; k < m && bo == true; k++)
	// if (board[k][j] == 'X')
	// break;
	// if (k == m)
	// bo = false;
	// // 左
	// for (k = j - 1; k >= 0 && bo == true; k--)
	//
	// if (board[i][k] == 'X')
	// break;
	// if (k < 0)
	// bo = false;
	// // 右
	// for (k = j + 1; k < n && bo == true; k++)
	// if (board[i][k] == 'X')
	// break;
	// if (k == n)
	// bo = false;
	// if (bo == true)
	// board[i][j] = 'X';
	// }
	// }
	// }

	public static void solve(char[][] board) {
		if (board.length == 0)
			return;
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				if (board[i][j] == 'O') {
					boolean bo = true;
					int k = 0;
					// 上
					for (k = i - 1; k >= 0 && bo == true; k--)
						if (board[k][j] == 'X')
							break;
					if (k < 0)
						bo = false;
					// 下
					for (k = i + 1; k < m && bo == true; k++)
						if (board[k][j] == 'X')
							break;
					if (k == m)
						bo = false;
					// 左
					for (k = j - 1; k >= 0 && bo == true; k--)

						if (board[i][k] == 'X')
							break;
					if (k < 0)
						bo = false;
					// 右
					for (k = j + 1; k < n && bo == true; k++)
						if (board[i][k] == 'X')
							break;
					if (k == n)
						bo = false;
					if (bo == true)
						board[i][j] = 'X';
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String str = "[[1,1,1],[1,2,1],[1,1,1]]";
		// int[][] matrix = matrixs(3, 3, str);
		char[][] matrix = { { 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'O', 'X', 'O' }, { 'X', 'O', 'X', 'O', 'X' },
				{ 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		print(matrix);
		System.out.println();
		solve(matrix);
		print(matrix);
	}
}
