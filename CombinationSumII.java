import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinationSumII {
	private static List<List<Integer>> solution;
	private static List<Integer> curSolution;

	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {
		solution = new ArrayList<List<Integer>>();
		curSolution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backTrack(candidates, target, 0);
		return solution;
	}

	private static void backTrack(int[] candidates, int target, int lastIdx) {
		if (target == 0) {
			solution.add(new ArrayList<>(curSolution));
		} else if (target < 0) {
			return;
		} else {
			int i = lastIdx;
			while (i < candidates.length) {
				int candidate = candidates[i];
				curSolution.add(candidate);
				backTrack(candidates, target - candidate, i+1);
				curSolution.remove(curSolution.size() - 1);
				while (i < candidates.length && candidates[i] == candidate) {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> h = combinationSum2(candidates, target);
		Iterator<List<Integer>> it = h.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
