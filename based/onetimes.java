package based;

public class onetimes {
	public static void onetime(int[] nums, int[] one) {
		int n = nums.length;
		if (n == 0)
			return;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum = sum ^ nums[i];
		int indexBit = lastBit(sum);
		for (int i = 0; i < n; i++)
			if (isBit(nums[i], indexBit))
				one[0] = one[0] ^ nums[i];
			else
				one[1] = one[1] ^ nums[i];
	}

	public static int lastBit(int sum) {
		int indexBit = 0;
		while ((sum & 1) == 0) {
			sum = sum >> 1;
			indexBit++;
		}
		return indexBit;
	}

	public static boolean isBit(int num, int indexBit) {
		num = num >> indexBit;
		return ((num & 1) == 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 4, 3, 6, 5 };
		int[] one = new int[2];
		onetime(nums, one);
		System.out.println(one[0] + "  " + one[1]);
	}
}
