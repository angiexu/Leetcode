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
		TreeNode p = new TreeNode(root.val);
		p.left =root.left;
		p.right=root.right;
		root.left = null;
		root.right = null;
		print(p, root);
	}

	public static void print(TreeNode root, TreeNode p) {
		if (root == null)
			return;
		else {
			p.right = root;
			p = p.right;
			print(root.left, p);
			print(root.right, p);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 1, 2, 5, 4, '#', 6 };
		TreeNode p = CreatTree(array);
		flatten(p);
		while (p != null) {
			System.out.println(p.val);
			p = p.right;
		}

	}
}
