import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		dfs(nums, 0, new ArrayList<Integer>(), lists);
		return lists;
	}

	public static void dfs(int[] nums, int index, List<Integer> path,
			List<List<Integer>> lists) {
		lists.add(path);
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			List<Integer> nPath = new ArrayList<Integer>(path);
			nPath.add(nums[i]);
			dfs(nums, i + 1, nPath, lists);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> alist = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		l = null;
		alist.add(l);
		int[] nums = { 1, 2, 3, 4, 5 };
		alist = subsetsWithDup(nums);
		Iterator<List<Integer>> it = alist.iterator();
		System.out.println(alist.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
