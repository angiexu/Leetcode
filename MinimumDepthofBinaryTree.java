import java.util.ArrayList;
import java.util.List;

public class MinimumDepthofBinaryTree {
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

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left != null && root.right == null)
			return minDepth(root.left);
		if (root.right != null && root.left == null)
			return minDepth(root.right);
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 3, 9, 20, '#', '#', 15, 7 };
		TreeNode p = CreatTree(array);
		System.out.println(minDepth(p));
	}

}
