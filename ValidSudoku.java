import java.util.Hashtable;

public class ValidSudoku {
	// 检查填写对错
	// public static boolean isValidSudoku(char[][] board) {
	// String[] s1 = { "56.847...", "3.9...6..", "..8......", ".1..8..4.",
	// "79.6.2.18", ".5..3..9.", "......2..", "..6...8.7", "...316.59" };
	// char[][] board1 = new char[9][9];
	// Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
	// for (int i = 0; i < 9; i++) {
	// board1[i] = s1[i].toCharArray();
	// }
	// boolean tap = true;
	//
	// for (int i = 0; i < 9; i++) {
	// int x = 0, n = 0;
	// ht.clear();
	// for (int j = 0; j < 9; j++) {
	// if (board[i][j] != '.')
	// x = Integer.parseInt(String.valueOf(board[i][j]));
	// else if (board1[i][j] != '.')
	// x = Integer.parseInt(String.valueOf(board1[i][j]));
	// ht.put(x, i);
	// n++;
	// }
	// if (n > ht.size())
	// tap = false;
	// }
	// for (int j = 0; j < 9; j++) {
	// int x = 0, n = 0;
	// ht.clear();
	// for (int i = 0; i < 9; i++) {
	// if (board[i][j] != '.')
	// x = Integer.parseInt(String.valueOf(board[i][j]));
	//
	// else if (board1[i][j] != '.')
	// x = Integer.parseInt(String.valueOf(board1[i][j]));
	// ht.put(x, j);
	// n++;
	//
	// }
	// if (n > ht.size())
	// tap = false;
	// }
	// return tap;
	// }

	// 题
	public static boolean isValidSudoku(char[][] board) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		boolean tap = true;
		for (int i = 0; i < 9; i++) {
			int x = 0, n = 0;
			ht.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					x = Integer.parseInt(String.valueOf(board[i][j]));
					ht.put(x, i);
					n++;
				}
			}
			if (n > ht.size())
				tap = false;
		}
		for (int j = 0; j < 9; j++) {
			int x = 0, n = 0;
			ht.clear();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					x = Integer.parseInt(String.valueOf(board[i][j]));
					ht.put(x, j);
					n++;
				}
			}
			if (n > ht.size())
				tap = false;
		}
		for (int k = 0; k < 3; k++)
			for (int s = 0; s < 3; s++) {
				int x = 0, n = 0;
				ht.clear();
				for (int j = k * 3; j < k * 3 + 3; j++)
					for (int i = s * 3; i < s * 3 + 3; i++) {
						if (board[i][j] != '.') {
							x = Integer.parseInt(String.valueOf(board[i][j]));
							ht.put(x, j);
							n++;
						}
						if (n > ht.size())
							tap = false;
					}
			}
		return tap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "....5..1.", ".4.3.....", ".....3..1", "8......2.",
				"..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++)
			board[i] = s[i].toCharArray();
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {

				System.out.print(board[i][j]);

			}
			System.out.println();
		}
		System.out.println();
		System.out.println(isValidSudoku(board));

	}
}
