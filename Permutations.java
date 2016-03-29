import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (nums.length == 0)
			return list;
		list.add((List<Integer>) Arrays.asList(nums[0]));
		for (int i = 1; i < nums.length; i++) {// 数组
			List<List<Integer>> li = new LinkedList<List<Integer>>();
			li.addAll(list);
			list.clear();
			for (int j = 0; j < i + 1; j++) {// 放位置
				Iterator<List<Integer>> it = li.iterator();
				while (it.hasNext()) {// 放的次数
					List<Integer> l = new LinkedList<Integer>(it.next());
					l.add(j, nums[i]);
					list.add(l);
				}
			}
		}
		return list;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (nums.length == 0)
			return list;
		else {
			List<Integer> li = new LinkedList<Integer>();
			for (int i = 0; i < nums.length; i++)
				li.add(nums[i]);
			list.add(li);
			return per(list, 0);
		}
	}

	public static List<List<Integer>> per(List<List<Integer>> list, int begin) {
		if (begin == list.get(0).size())
			return list;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			int end = list.get(0).size();
			for (int j = begin + 1; j < end; j++) {
				List<Integer> l = new LinkedList<Integer>(list.get(i));
				int x = l.get(begin);
				l.set(begin, l.get(j));
				l.set(j, x);
				list.add(l);
			}
		}
		list = per(list, begin + 1);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = permute(nums);
		Iterator<List<Integer>> it = list.iterator();
		System.out.println(list.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}