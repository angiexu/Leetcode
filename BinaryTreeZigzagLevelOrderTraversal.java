import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return lists;
		List<TreeNode> l = new ArrayList<TreeNode>();
		l.add(root);
		int n = 1, i = 0, tag = 1;
		while (i < n) {
			TreeNode p = l.get(i);
			i++;
			if (tag == 1)
				list.add(p.val);
			else
				list.add(0, p.val);
			if (p.left != null)
				l.add(p.left);
			if (p.right != null)
				l.add(p.right);
			if (i == n) {
				@SuppressWarnings("unchecked")
				ArrayList<Integer> li = (ArrayList<Integer>) ((ArrayList<Integer>) list)
						.clone();
				lists.add(li);
				n = l.size();
				list.clear();
				if (tag == 0)
					tag = 1;
				else
					tag = 0;
			}
		}
		return lists;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 3, 9, 20, '#', '#', 15, 7 };
		TreeNode p = CreatTree(array);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists = zigzagLevelOrder(p);
		Iterator<List<Integer>> its = lists.iterator();
		while (its.hasNext()) {
			List<Integer> list = its.next();
			Iterator<Integer> it = list.iterator();
			while (it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		}
	}

}
