
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UniqueBinarySearchTreesII {
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

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> list = generateTrees(3);
		Iterator<TreeNode> it = list.iterator();
		while (it.hasNext())
			print(it.next());
	}
}
