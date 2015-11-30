public class RangeSumQueryImmutable {

	public static class NumArray {
		int[] sums;

		public NumArray(int[] nums) {
			sums = new int[nums.length];
			System.arraycopy(nums, 0, sums, 0, nums.length);
			for (int i = 1; i < sums.length; i++) {
				sums[i] += sums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			if (i == 0)
				return sums[j];
			return sums[j] - sums[i - 1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}
}
