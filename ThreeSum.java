import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreeSum {// 超时
// public static List<List<Integer>> threeSum(int[] num) {
// List<List<Integer>> f = new ArrayList<List<Integer>>();
// if (num.length < 3) {
// return f;
// }
// List h = new ArrayList();
// for (int i = 0; i < num.length; i++)
// h.add(num[i]);
// for (int i = 0; i < num.length - 1; i++)
// for (int j = i + 1; j < num.length; j++) {
// int tag = 0;
// int a = num[i];
// h.remove(i);
// int b = num[j];
// h.remove(j-1);
// int t = 0;
// int c = 0 - a - b;
// if (h.contains(c)) {
// if (a > b) {
// t = a;
// a = b;
// b = t;
// }
// if (b > c) {
// t = b;
// b = c;
// c = t;
// }
// if (a > b) {
// t = a;
// a = b;
// b = t;
// }
// Iterator it = f.iterator();
// while (it.hasNext()) {
// if (it.next().equals(Arrays.asList(a, b, c)))
// tag = 1;
// }
// if (tag == 0)
// f.add((List<Integer>) Arrays.asList(a, b, c));
// }
// h.add(j-1, num[j]);
// h.add(i, num[i]);
// }
// return f;
// }

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> f = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return f;
		Arrays.sort(num);
		for (int n = 0; n < num.length; n++) {
			if (n > 0 && num[n] == num[n - 1])
				continue;
			int i = n + 1, j = num.length - 1;
			while (i < j) {
				if ((num[n] + num[i] + num[j]) > 0) {
					j--;
					while (num[j] == num[j + 1] && j > i)
						j--;
				} else if ((num[n] + num[i] + num[j]) < 0) {
					i++;
					while (num[i] == num[i - 1] && i < j)
						i++;
				} else {
					f.add((List<Integer>) Arrays.asList(num[n], num[i], num[j]));
					i++;
					while (num[i] == num[i - 1] && i < j)
						i++;
					j--;
					while (num[j] == num[j + 1] && j > i)
						j--;
				}
			}
		}
		return f;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 0, 0, 0 };
		List<List<Integer>> h = threeSum(num);
		Iterator<List<Integer>> it = h.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
