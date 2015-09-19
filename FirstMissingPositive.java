import java.util.Arrays;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		int i = 0, j, n = 1;
		Arrays.sort(nums);
		while (i < nums.length && nums[i] <= 0)
			i++;
		if (i == nums.length)
			return 1;
		for (j = i; j < nums.length; j++) {
			if (nums[j] > n)
				break;
			else
				n++;
			while (j < nums.length - 1 && nums[j] == nums[j + 1])
				j++;
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1 };
		System.out.println(firstMissingPositive(nums));
	}
}
