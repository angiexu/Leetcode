import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	// 超时
	// public static String getPermutation(int n, int k) {
	// String s = null;
	// List<List<Integer>> list = new LinkedList<List<Integer>>();
	// if (n == 0)
	// return s;
	// list.add((List<Integer>) Arrays.asList(1));
	// for (int i = 1; i < n; i++) {// 数组
	// List<List<Integer>> li = new LinkedList<List<Integer>>();
	// li.addAll(list);
	// list.clear();
	// for (int j = 0; j < i + 1; j++) {// 放位置
	// Iterator<List<Integer>> it = li.iterator();
	// while (it.hasNext()) {// 放的次数
	// List<Integer> l = new LinkedList<Integer>(it.next());
	// l.add(j, i + 1);
	// list.add(l);
	// }
	// }
	// }
	// String[] nums = new String[list.size()];
	// int i = 0;
	// Iterator<List<Integer>> it = list.iterator();
	// while (it.hasNext()) {
	// nums[i] = String.valueOf(it.next());
	// i++;
	// }
	// Arrays.sort(nums);
	// s = String.valueOf(nums[k - 1].charAt(1));
	// for (i = 4; i < nums[k - 1].length(); i=i+3)
	// s = s + String.valueOf(nums[k - 1].charAt(i));
	// return s;
	// }
	public static String getPermutation(int n, int k) {
		String s = "";
		int num = 1;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			num *= i;
			list.add(i);
		}
		k--;
		while (list.size() != 0) {
			num /= (list.size());
			s += list.remove(k / num);
			k -= (k / num) * num;
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 2));
	}
}
