import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
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

	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.left);
		flatten(root.right);
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		root.right = left;
		while (root.right != null)
			root = root.right;
		root.right = right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 1, 2, 5, 3, 4, '#', 6 };
		TreeNode p = CreatTree(array);
		flatten(p);
		while (p != null) {
			System.out.print(p.val+" ");
			p = p.right;
		}

	}
}