import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
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

	static int sums = 0;

	public static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sumPath(root, root.val);
		return sums;
	}

	public static void sumPath(TreeNode root, int sum) {
		if (root.left == null && root.right == null)
			sums += sum;
		if (root.left != null)
			sumPath(root.left, sum * 10 + root.left.val);
		if (root.right != null)
			sumPath(root.right, sum * 10 + root.right.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 0, 1 };
		TreeNode p = CreatTree(array);
		System.out.println(sumNumbers(p));
	}
}
