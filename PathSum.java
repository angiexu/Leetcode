import java.util.ArrayList;
import java.util.List;

public class PathSum {
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

	public static boolean hasPathSum(TreeNode root, int sum) {
		boolean bo = false;
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum == root.val)
			return true;
		else
			bo = hasPathSum(root.left, sum - root.val)
					|| hasPathSum(root.right, sum - root.val);
		return bo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 5, 4, 8, 11, '#', 13, 4, 7, 2 };
		TreeNode p = CreatTree(array);
		System.out.println(hasPathSum(p, 23));
	}
}
