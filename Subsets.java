import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Subsets {
	@SuppressWarnings("unchecked")
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (nums.length == 0) {
			return lists;
		}
		Arrays.sort(nums);
		lists.add(list);
		List<List<Integer>> li = (ArrayList<List<Integer>>) (((ArrayList<List<Integer>>) lists)
				.clone());
		for (int i = 1; i <= nums.length; i++) {
			li = permute(nums, li, i);
			lists.addAll(li);
		}
		return lists;
	}

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> permute(int[] nums,
			List<List<Integer>> lists, int n) {
		List<List<Integer>> list = (ArrayList<List<Integer>>) (((ArrayList<List<Integer>>) lists)
				.clone());
		lists.clear();
		for (int i = n - 1; i < nums.length; i++) {// 数组
			Iterator<List<Integer>> it = list.iterator();
			while (it.hasNext()) {
				List<Integer> l = new ArrayList<Integer>(it.next());
				if (l.size() < 1
						|| (nums[i] > l.get(n - 2) && !l.contains(nums[i]))) {
					l.add(nums[i]);
					lists.add(l);
				}
			}
		}
		return lists;
	}

	// static void subsets(int[] nums, List<List<Integer>> lists, int start) {
	// if (start >= nums.length) {
	// return;
	// }
	// List<List<Integer>> nlists = new ArrayList<List<Integer>>(lists);
	// for (int i = 0; i < nlists.size(); i++) {
	// List<Integer> l = new ArrayList<Integer>(nlists.get(i));
	// l.add(nums[start]);
	// if (!lists.contains(l)) {
	// lists.add(l);
	// }
	// }
	// subsets(nums, lists, start + 1);
	// return;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> alist = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		l = null;
		alist.add(l);
		int[] nums = { 1, 2, 3 };
		alist = subsets(nums);
		Iterator<List<Integer>> it = alist.iterator();
		System.out.println(alist.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
