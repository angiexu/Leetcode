import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class SingleNumberII {
	public static int singleNumber1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], 2);
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int key = (int) it.next();
			if (map.get(key) == 1)
				return key;
		}
		return 0;
	}

	public static int singleNumber(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n < 3)
			return nums[0];
		Arrays.sort(nums);
		for (int i = 0; i < n - 1; i = i + 3) {
			if (nums[i] != nums[i + 2])
				return nums[i];
		}
		return nums[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, -1, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5 };
		long startTime = System.nanoTime(); // 获取开始时间
		singleNumber(nums); // 测试的代码段
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
		System.out.println(singleNumber(nums));
	}
}
