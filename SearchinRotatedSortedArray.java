public class SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
		int n = -1;
		int start = 0, end = nums.length, i = 0;
		if (nums.length > 1) {
			while (i < nums.length - 1 && nums[i] < nums[i + 1])
				i++;
			if (i != 0 && nums[0] <= target && target < nums[i]) {
				start = 0;
				end = i;
			} else {
				start = i;
				end = nums.length;
			}
		}
		for (i = start; i < end; i++)
			if (nums[i] == target)
				n = i;
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3 };
		int target = 0;
		System.out.println(search(nums, target));
	}
}
