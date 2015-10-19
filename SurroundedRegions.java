import java.util.LinkedList;
import java.util.Queue;

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

	// public static void solve(char[][] board) {
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

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		int n = board.length;
		int m = board[0].length;

		// scan the borders and mark the 'O's to '1'
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if ((i * j == 0 || i == n - 1 || j == m - 1)
						&& board[i][j] == 'O')
					bfs(board, n, m, i, j);

		// scan the inner area and mark the 'O's to 'X'
		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++)
				if (board[i][j] == 'O')
					board[i][j] = 'X';

		// reset all the '1's to 'O's
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j] == '1')
					board[i][j] = 'O';

	}

	static void bfs(char[][] board, int n, int m, int i, int j) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i * m + j);
		board[i][j] = '1';
		while (!queue.isEmpty()) {
			Integer pos = queue.poll();
			int row = pos / m;
			int col = pos % m;
			for (int k = 0; k < 4; k++) {
				i = row + dx[k];
				j = col + dy[k];
				if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O') {
					board[i][j] = '1';
					queue.add(i * m + j);
				}
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
