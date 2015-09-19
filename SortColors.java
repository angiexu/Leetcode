import java.util.Arrays;

public class SortColors {
	public static void sortColors1(int[] nums) {
		Arrays.sort(nums);
	}

	public static void sortColors(int[] nums) {
		int n0 = 0, n1 = 0, n2 = 0, i = 0;
		for (i = 0; i < nums.length; i++)
			switch (nums[i]) {
			case 0:
				n0++;
				break;
			case 1:
				n1++;
				break;
			case 2:
				n2++;
				break;
			}
		for (i = 0; i < n0; i++)
			nums[i] = 0;
		for (; i < n0 + n1; i++)
			nums[i] = 1;
		for (; i < n0 + n1 + n2; i++)
			nums[i] = 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, 2, 1, 0, 1, 2 };

		long startTime = System.nanoTime(); // 获取开始时间
		sortColors(nums); // 测试的代码段
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
