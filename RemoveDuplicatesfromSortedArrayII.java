public class RemoveDuplicatesfromSortedArrayII {
	public static int removeDuplicates(int[] nums) {
		int length = 0;
		int[] num = new int[nums.length];
		for (int i = 0; i < nums.length;) {
			int k = nums[i];
			num[length] = nums[i];
			length++;
			i++;
			if (i < nums.length && nums[i] == k) {
				num[length] = nums[i];
				length++;
				i++;
			}
			while (i < nums.length && nums[i] == k)
				i++;
		}
		for (int i = 0; i < length; i++) {
			nums[i] = num[i];
		}
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2 };
		System.out.println(removeDuplicates(nums));
	}
}
