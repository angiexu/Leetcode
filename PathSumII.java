import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathSumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode CreatTree(char[] array) {
		TreeNode root = new TreeNode(array[0] - 0);
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		int i = 1;
		while (i < array.length) {
			TreeNode p = list.get(0);
			list.remove(0);
			if (array[i] != '#') {
				p.left = new TreeNode(array[i] - 0);
				list.add(p.left);
			}
			i++;
			if (i < array.length && array[i] != '#') {
				p.right = new TreeNode(array[i] - 0);
				list.add(p.right);
			}
			i++;
		}
		return root;
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null) {
			return lists;
		}
		path(lists, new ArrayList<Integer>(), root, sum);
		return lists;
	}

	public static void path(List<List<Integer>> lists, List<Integer> list,
			TreeNode root, int sum) {
		if (root == null)
			return;
		List<Integer> nlist = new ArrayList<Integer>(list);
		nlist.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == root.val)
				lists.add(nlist);
			return;
		}
		if (root.left != null)
			path(lists, nlist, root.left, sum - root.val);
		if (root.right != null)
			path(lists, nlist, root.right, sum - root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 5, 4, 8, 11, '#', 9, 4, 7, 2 };
		TreeNode p = CreatTree(array);
		List<List<Integer>> lists = pathSum(p, 22);
		Iterator<List<Integer>> its = lists.iterator();
		while (its.hasNext()) {
			List<Integer> list = its.next();
			Iterator<Integer> it = list.iterator();
			while (it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		}
	}
}
