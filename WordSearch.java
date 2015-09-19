public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		if (word.length() == 0)
			return true;
		if (board.length == 0)
			return false;
		int m = board.length, n = board[0].length;
		boolean[][] usage = new boolean[m][n];
		int i = 0, j = 0;
		for (i = 0; i < m; i++)
			for (j = 0; j < n; j++)
				if (board[i][j] == word.charAt(0))
					if (ex(board, usage, word.substring(1), i, j))
						return true;
		return false;
	}

	private static boolean ex(char[][] board, boolean[][] usage, String word,
			int i, int j) {
		if (word.length() == 0)
			return true;
		usage[i][j] = true;
		if (i < board.length - 1 && board[i + 1][j] == word.charAt(0)
				&& !usage[i + 1][j])
			if (ex(board, usage, word.substring(1), i + 1, j))
				return true;
		if (i > 0 && board[i - 1][j] == word.charAt(0) && !usage[i - 1][j])
			if (ex(board, usage, word.substring(1), i - 1, j))
				return true;
		if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(0)
				&& !usage[i][j + 1])
			if (ex(board, usage, word.substring(1), i, j + 1))
				return true;
		if (j > 0 && board[i][j - 1] == word.charAt(0) && !usage[i][j - 1])
			if (ex(board, usage, word.substring(1), i, j - 1))
				return true;
		usage[i][j] = false;
		return false;
	}

	// public static boolean valid(int r, int c, char[][] b, boolean[][] m) {
	// if (r < 0 || c < 0 || r > b.length - 1 || c > b[0].length - 1)
	// return false;
	// if (m[r][c] == true)
	// return false;
	// return true;
	// }
	//
	// public static boolean search(char[][] b, boolean[][] m, String w, int r,
	// int c) {
	// char ch = b[r][c];
	// char wc = w.charAt(0);
	// if (w.length() == 1)
	// return ch == wc;
	// if (ch != wc)
	// return false;
	// m[r][c] = true;
	// int up_r = r - 1, up_c = c;
	// int down_r = r + 1, down_c = c;
	// int left_r = r, left_c = c - 1;
	// int right_r = r, right_c = c + 1;
	// if (valid(up_r, up_c, b, m) && search(b, m, w.substring(1), up_r, up_c))
	// return true;
	// if (valid(down_r, down_c, b, m)
	// && search(b, m, w.substring(1), down_r, down_c))
	// return true;
	// if (valid(left_r, left_c, b, m)
	// && search(b, m, w.substring(1), left_r, left_c))
	// return true;
	// if (valid(right_r, right_c, b, m)
	// && search(b, m, w.substring(1), right_r, right_c))
	// return true;
	// m[r][c] = false;
	// return false;
	// }
	//
	// public static boolean exist(char[][] board, String word) {
	// if (word.length() == 0)
	// return false;
	// int m = board.length;
	// if (m == 0)
	// return false;
	// int n = board[0].length;
	// if (n == 0)
	// return false;
	// boolean[][] map = new boolean[m][n];
	// for (int r = 0; r < m; r++) {
	// for (int c = 0; c < n; c++) {
	// boolean found = search(board, map, word, r, c);
	// if (found)
	// return true;
	// }
	// }
	// return false;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(exist(board, word));
	}
}
