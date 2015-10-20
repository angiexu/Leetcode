import java.util.TreeSet;

public class ContainsDuplicateIII {
	// Time Limit Exceeded
	// public static boolean containsNearbyAlmostDuplicate(int[] nums, int k,
	// int t) {// k是距离
	// if (nums.length == 0)
	// return false;
	// for (int i = 0; i < nums.length; i++)
	// for (int j = i + 1; j <= i + k && j < nums.length; j++) {
	// if (Math.abs(nums[i] - nums[j]) <= t)
	// return true;
	// }
	// return false;
	// }
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		if (nums.length == 0 || k == 0)
			return false;
		k = k < nums.length - 1 ? k : nums.length - 1;
		for (int i = 1; i <= k; i++)
			set.add(nums[i]);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] - t - 1 >= nums[i] + t)
				return false;// 控制subset
			if (!set.subSet(nums[i] - t, nums[i] + t).isEmpty()
					|| set.contains(nums[i] + t))
				return true;
			else {
				if (i != nums.length - 2)
					set.remove(nums[i + 1]);
				else
					break;
				if (i + k + 1 < nums.length)
					set.add(nums[i + k + 1]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, -11, 8, 9, 33, 6, 4 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 5, 2));
	}
}
