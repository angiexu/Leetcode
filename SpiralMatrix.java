import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return list;
		int rows = matrix.length, columns = matrix[0].length;
		int rs = 0, cs = 0;
		int n = matrix.length * matrix[0].length;
		while (list.size() < n) {
			for (int i = cs; i < columns && list.size() < n; i++)
				list.add(matrix[rs][i]);
			rs++;
			for (int i = rs; i < rows && list.size() < n; i++)
				list.add(matrix[i][columns - 1]);
			columns--;

			for (int i = columns - 1; i >= cs && list.size() < n; i--)
				list.add(matrix[rows - 1][i]);
			rows--;
			for (int i = rows - 1; i >= rs && list.size() < n; i--)
				list.add(matrix[i][cs]);
			cs++;
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 } };
		List<Integer> list = spiralOrder(matrix);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
	}
}
