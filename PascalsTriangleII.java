import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalsTriangleII {
	// 小于17时有效
	// public static List<Integer> getRow(int rowIndex) {
	// List<Integer> list = new ArrayList<Integer>;
	// list.add(1);
	// for (int i = 1; i <= rowIndex / 2; i++)
	// list.add(fac(rowIndex - i + 1, rowIndex) / fac(1, i));
	// for (int i = rowIndex / 2 - ((rowIndex + 1) % 2); i >= 0; i--)
	// list.add(list.get(i));
	// return list;
	// }
	//
	// public static int fac(int x, int y) {
	// int n = x;
	// for (int i = x + 1; i <= y; i++)
	// n = n * i;
	// return n;
	// }
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int a = 0, b = 1;
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = 1; j < i; j++) {
				a = list.get(j);
				list.set(j, list.get(j) + b);
				b = a;
			}
			list.add(1);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = getRow(13);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
