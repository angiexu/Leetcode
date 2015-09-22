

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
	// 空间复杂度大
	// public static void setZeroes(int[][] matrix) {
	// int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
	// int[][] mat = new int[m][n];
	// for (; j < n; j++)
	// for (i = 0; i < m; i++)
	// if (matrix[i][j] == 0)
	// mat[i][j] = 1;
	// for (j = 0; j < n; j++) {
	// for (i = 0; i < m; i++)
	// if (mat[i][j] == 1) {
	// for (int s = 0; s < m; s++)
	// matrix[s][j] = 0;
	// for (int t = 0; t < n; t++)
	// matrix[i][t] = 0;
	// }
	// }
	// }
	public static void setZeroes(int[][] matrix) {
		int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (; j < n; j++)
			for (i = 0; i < m; i++)
				if (matrix[i][j] == 0) {
					queue.add(i);
					queue.add(j);
				}
		while (!queue.isEmpty()) {
			i = queue.poll();
			j = queue.poll();
			for (int s = 0; s < m; s++)
				matrix[s][j] = 0;
			for (int t = 0; t < n; t++)
				matrix[i][t] = 0;
		}
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	public static int[][] matrixs(int m, int n, String str) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "[[1,1,2,2],[1,2,1,2],[1,2,0,1]]";
		int[][] matrix = matrixs(3, 4, str);
		print(matrix);
		System.out.println();
		setZeroes(matrix);
		print(matrix);
	}
}
