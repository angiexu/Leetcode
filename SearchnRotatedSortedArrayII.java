public class SearchnRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == target)
				return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 4, 5 };
		int target = 5;
		System.out.println(search(nums, target));
	}
}
