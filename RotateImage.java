public class RotateImage {
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix[0].length == 1)
			return;
		int length = matrix[0].length;
		for (int i = 0; i < length; i++)
			for (int j = 0; j < i; j++) {// 转置
				int a = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = a;
			}
		for (int i = 0; i < length; i++)
			for (int j = 0; j < length / 2; j++) { // 中轴对换
				int a = matrix[i][length - j - 1];
				matrix[i][length - j - 1] = matrix[i][j];
				matrix[i][j] = a;
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 },
				{ 11, 12, 13, 14 } };
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
		rotate(matrix);
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
