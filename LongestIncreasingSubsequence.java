public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] n = new int[nums.length];
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			n[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					n[i] = Math.max(n[i], n[j] + 1);
					max = Math.max(n[i], max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

}
