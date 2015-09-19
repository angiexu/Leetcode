import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	// 超时
	// public static List<List<Integer>> permuteUnique(int[] nums) {
	// List<List<Integer>> list = new LinkedList<List<Integer>>();
	// if (nums.length == 0)
	// return list;
	// list.add((List<Integer>) Arrays.asList(nums[0]));
	// for (int i = 1; i < nums.length; i++) {// 数组
	// List<List<Integer>> li = new LinkedList<List<Integer>>();
	// li.addAll(list);
	// list.clear();
	// for (int j = 0; j < i + 1; j++) {// 放位置
	// Iterator<List<Integer>> it = li.iterator();
	// while (it.hasNext()) {// 放的次数
	// List<Integer> l = new LinkedList<Integer>(it.next());
	// l.add(j, nums[i]);
	// if (list.contains(l))
	// continue;
	// list.add(l);
	// }
	// }
	// }
	// return list;
	// }
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (nums.length == 0)
			return list;
		Arrays.sort(nums);
		permute(nums, 0, list);
		return list;
	}

	public static void permute(int[] nums, int begin,
			List<List<Integer>> permutations) {
		if (begin == nums.length - 1) {
			permutations.add(convertArrayToList(nums));
		} else if (begin < nums.length - 1) {
			for (int i = begin; i < nums.length; i++) {
				if (i == begin || nums[begin] != nums[i]) {
					swap(nums, i, begin);
					permute(nums, begin + 1, permutations);
				}
			}
			for (int i = begin; i + 1 < nums.length; i++) {
				swap(nums, i, i + 1);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		if (i != j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}

	public static List<Integer> convertArrayToList(int[] nums) {
		List<Integer> list = new ArrayList<Integer>(nums.length);
		for (int num : nums) {
			list.add(num);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 3, 0, 0, 2, 3, 2 };
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = permuteUnique(nums);
		Iterator<List<Integer>> it = list.iterator();
		System.out.println(list.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
