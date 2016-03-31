public class LargestNumber {
	public static String largestNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return "0";
		sort(nums, 0, len - 1);
		StringBuffer s = new StringBuffer();
		for (int i = len - 1; i >= 0; i--)
			s = s.append(nums[i]);
		String ss = s.toString();
		if (s.charAt(0) == '0')
			return "0";
		return ss;
	}

	private static void sort(int[] nums, int start, int end) {
		if (start >= end || nums.length == 0)
			return;
		int flag = nums[start];
		int i = start, j = end;
		while (i < j) {
			while (i < j && firstbig(nums[j], flag))
				j--;
			nums[i] = nums[j];
			while (i < j && firstbig(flag, nums[i]))
				i++;
			nums[j] = nums[i];
		}
		nums[i] = flag;
		sort(nums, start, j - 1);
		sort(nums, j + 1, end);
	}

	private static boolean firstbig(int i, int j) {
		String s1 = String.valueOf(i) + String.valueOf(j);
		String s2 = String.valueOf(j) + String.valueOf(i);
		if (s1.equals(s2))
			return true;
		int len = s1.length();
		for (int k = 0; k < len; k++) {
			if (s1.charAt(k) != s2.charAt(k))
				return s1.charAt(k) > s2.charAt(k);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0,0 };
		System.out.println(largestNumber(nums));
	}
}