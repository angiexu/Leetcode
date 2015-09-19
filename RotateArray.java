public class RotateArray {
	public static void rotate(int[] nums, int k) {
		if (k > nums.length)
			k = k - nums.length;
		int[] n = nums.clone();
		for (int i = 0; i < nums.length - k; i++)
			nums[i + k] = n[i];
		for (int i = 0; i < k; i++)
			nums[i] = n[nums.length - k + i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 8;
		rotate(nums, k);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}

}
