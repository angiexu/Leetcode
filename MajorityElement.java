import java.util.HashMap;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		int max = -1, num = nums[0];
		HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			if (ht.containsKey(nums[i])) {
				int n = ht.get(nums[i]) + 1;
				ht.remove(nums[i]);
				ht.put(nums[i], n);
				if (n > max) {
					max = n;
					num = nums[i];
				}
			} else
				ht.put(nums[i], 1);
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 3, 4};
		System.out.println(majorityElement(nums));
	}

}
