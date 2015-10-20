import java.util.HashMap;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0)
			return false;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i + "");
			else {
				if (Math.abs(Integer.parseInt(map.get(nums[i])) - i) <= k)
					return true;
				else
					map.put(nums[i], i + "");
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 11, 8, 13, 4, 5, 6, 8, 8 };
		System.out.println(containsNearbyDuplicate(nums, 2));
	}

}
