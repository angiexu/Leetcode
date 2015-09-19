public class SearchforaRange {
	// 时间复杂度O(n)
	// public static int[] searchRange(int[] nums, int target) {
	// int[] n = { -1, -1 };
	// int start = 0, end = nums.length, i = 0, target = 0;
	// if (nums.length == 1 && nums[0] == target) {
	// n[0] = 0;
	// n[1] = 0;
	// }
	// if (nums.length > 1) {
	// for (i = 0; i < nums.length; i++)
	// if (nums[i] == target) {
	// n[0] = i;
	// break;
	// }
	// while (i < nums.length && nums[i] == target)
	// i++;
	// if (nums[i - 1] == target)
	// n[1] = i - 1;
	// }
	// return n;
	// }
	// 时间复杂度符合题意
	public static int[] searchRange(int[] nums, int target) {
		int[] n = { -1, -1 };
		int start = 0, end = nums.length - 1, tag = 0;
		while (start < end) {
			if (nums[(end + start) / 2] > target)
				end = (end + start) / 2 - 1;
			else if (nums[(end + start) / 2] < target)
				start = (end + start) / 2 + 1;
			else {
				if ((end + start) / 2 > 0
						&& nums[(end + start) / 2 - 1] < target) {
					n[0] = (end + start) / 2;
					start = (end + start) / 2;
					tag = 1;
				} else if ((end + start) / 2 + 1 < nums.length
						&& nums[(end + start) / 2 + 1] > target) {
					n[1] = (end + start) / 2;
					end = (end + start) / 2;
					tag = 2;
				}
				break;
			}
		}
		if (start != end) {
			int s = start, e = end;
			if (tag != 1)
				while (s < e) {
					if (nums[s] == target && (s == 0 || nums[s - 1] < target)) {
						n[0] = s;
						break;
					} else if (nums[e] == target && nums[e - 1] < target) {
						n[0] = e;
						break;
					} else if (nums[(e + s) / 2 - 1] < target
							&& nums[(e + s) / 2] == target) {
						n[0] = (e + s) / 2;
						break;
					} else if (nums[(e + s) / 2] == target)
						e = (e + s) / 2 - 1;
					else
						s = (e + s) / 2 + 1;
				}
			s = start;
			e = end;
			if (tag != 2)
				while (s < e) {
					if (nums[e] == target
							&& (e == nums.length - 1 || nums[e + 1] > target)) {
						n[1] = e;
						break;
					} else if (nums[s] == target && nums[s + 1] > target) {
						n[1] = s;
						break;
					} else if (nums[(e + s) / 2 + 1] > target
							&& nums[(e + s) / 2] == target) {
						n[1] = (e + s) / 2;
						break;
					} else if (nums[(e + s) / 2] == target)
						s = (e + s) / 2 + 1;
					else
						e = (e + s) / 2 - 1;
				}
		} else {
			if (nums[start] == target) {
				if (tag != 1)
					n[0] = start;
				if (tag != 2)
					n[1] = start;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0,1,2,3,3,4,4,5,5,6,6,7,7,7,9,9,11,11,11,12,12,12,12};
		int target = 12;
		nums = searchRange(nums, target);
		System.out.println(nums[0]);
		System.out.println(nums[1]);
	}

}
