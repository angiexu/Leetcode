import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {
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

	public static TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return root;
		if (root.left != null) {
			TreeNode flag = root.left;
			root.left = root.right;
			root.right = flag;
			invertTree(root.right);
		}
		if (root.left != null)
			invertTree(root.left);
		return root;
	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		if (root.left != null)
			invertTree(root.left);
		if (root.right != null)
			invertTree(root.right);
		TreeNode flag = root.left;
		root.left = root.right;
		root.right = flag;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 1, 2 };
		TreeNode p = CreatTree(array);
		invertTree(p);
		System.out.println();
	}
}
