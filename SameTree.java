import java.util.ArrayList;
import java.util.List;

public class SameTree {
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

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null && p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array1 = { 2, 3, 3, 5, '#', 5, 4 };
		TreeNode p = CreatTree(array1);
		char[] array2 = { 2, 3, 3, 4, '#', 5, 4 };
		TreeNode q = CreatTree(array2);
		System.out.println(isSameTree(p, q));
	}
}
