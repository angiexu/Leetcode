import java.util.Arrays;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0)
			return false;
		Arrays.sort(nums);
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i])
				max = nums[i];
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 8 };
		System.out.println(containsDuplicate(nums));
	}
}
