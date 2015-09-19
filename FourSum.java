import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> f = new ArrayList<List<Integer>>();
		if (num.length < 4)
			return f;
		Arrays.sort(num);
		for (int n = 0; n < num.length; n++)
			for (int m = n + 1; m < num.length; m++) {
				if (n > 0 && num[n] == num[n - 1])
					continue;
				if (m > 0 && num[m] == num[m - 1] && (m - 1) != n)
					continue;
				int i = m + 1, j = num.length - 1;
				while (i < j) {
					if ((num[n] + num[m] + num[i] + num[j]) > target) {
						j--;
						while (num[j] == num[j + 1] && j > i)
							j--;
					} else if ((num[n] + num[m] + num[i] + num[j]) < target) {
						i++;
						while (num[i] == num[i - 1] && i < j)
							i++;
					} else {
						f.add((List<Integer>) Arrays.asList(num[n], num[m],
								num[i], num[j]));
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
		int[] num = { -1,-5,-5,-3,2,5,0,4};
		int target = -7;
		List<List<Integer>> h = fourSum(num, target);
		Iterator<List<Integer>> it = h.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
