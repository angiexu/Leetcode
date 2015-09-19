public class MaximumSubarray {
	// 超时
	// public static int maxSubArray(int[] nums) {
	// int max = 0, length = nums.length;
	// while (length > 0 && nums[length - 1] < 0)
	// length--;
	// for (int start = 0; start < length; start++) {
	// while (start < length && nums[start] < 0)
	// start++;
	// int sum = 0;
	// for (int i = start; i < length; i++) {
	// sum = sum + nums[i];
	// if (sum > max)
	// max = sum;
	// }
	// }
	// return max;
	// }
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int temp = nums[0];
		int max = temp;
		for (int i = 1; i < nums.length; i++) {
			if (temp < 0)
				temp = nums[i];//丢弃小于0的开头
			else
				temp += nums[i];
			max = Math.max(max, temp);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

}
