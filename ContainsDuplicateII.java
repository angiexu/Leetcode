import java.util.HashMap;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0)
			return false;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i] + "", nums[i]);
			if (map.containsKey(nums[i]))
				if(abs(Integer.parseInt(map.values(nums[i]))-i)>k)
				else
					map.keySet();
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 11, 12, 13, 4, 5, 6, 7, 8, 8 };
		System.out.println(containsNearbyDuplicate(nums, 2));
	}

}
