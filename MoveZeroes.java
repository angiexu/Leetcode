public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return;
		int i = 0;
		for (int j = 0; j < len;) {
			if (nums[j] != 0)
				nums[i++] = nums[j++];
			else {
				while (j < len && nums[j] == 0)
					j++;
				if (j < len)
					nums[i++] = nums[j++];
			}
		}
		for (; i < len; i++)
			nums[i] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
