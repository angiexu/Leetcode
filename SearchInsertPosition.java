public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		for (i = 0; i < nums.length; i++)
			if (nums[i] >= target)
				break;
		if (i > nums.length)
			i--;
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 4, 5 };
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}

}
