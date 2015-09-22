import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeInorderTraversal {
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

	// static List<Integer> list = new ArrayList<Integer>();
	//
	// public static List<Integer> inorderTraversal(TreeNode root) {
	// if (root == null)
	// return list;
	// else {
	// inorderTraversal(root.left);
	// list.add(root.val);
	// inorderTraversal(root.right);
	// }
	// return list;
	// }

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Traversal(root, list);
		return list;
	}

	public static List<Integer> Traversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return list;
		else {
			Traversal(root.left, list);
			list.add(root.val);
			Traversal(root.right, list);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 1, 2 };
		TreeNode p = CreatTree(array);
		List<Integer> list = inorderTraversal(p);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
