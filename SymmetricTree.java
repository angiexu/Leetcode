import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 先序遍历
	public static void print(TreeNode root) {
		if (root == null)
			return;
		else {
			System.out.print(root.val + " ");
			print(root.left);
			print(root.right);
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

	public static boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if ((root.left == null && root.right != null)
				|| (root.left != null && root.right == null))
			return false;
		return Symmetric(root.left, root.right);
	}

	public static boolean Symmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null && q != null) || (p != null && q == null)
				|| (p.val != q.val))
			return false;
		return (Symmetric(p.left, q.right) && Symmetric(p.right, q.left));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 2, 3, 3, 4, 5, 5 };
		TreeNode p = CreatTree(array);
		System.out.println(isSymmetric(p));
	}
}
