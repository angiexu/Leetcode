package based;

public class MoreThanHalf {
	public static int FindOneNumber(int[] nums) {
		int n = nums.length;
		int result = nums[0];
		int time = 1;
		for (int i = 1; i < n; i++) {
			if (time == 0) {
				result = nums[i];
				time = 1;
			} else {
				if (result == nums[i])
					time++;
				else
					time--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 2, 2, 3 };
		System.out.println(FindOneNumber(nums));
	}

}
