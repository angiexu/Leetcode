import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersinEachNode {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static TreeLinkNode CreatTree(char[] array) {
		TreeLinkNode root = new TreeLinkNode(array[0] - 0);
		List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		list.add(root);
		int i = 1;
		while (i < array.length) {
			TreeLinkNode p = list.get(0);
			list.remove(0);
			if (array[i] != '#') {
				p.left = new TreeLinkNode(array[i] - 0);
				list.add(p.left);
			}
			i++;
			if (i < array.length && array[i] != '#') {
				p.right = new TreeLinkNode(array[i] - 0);
				list.add(p.right);
			}
			i++;
		}
		return root;
	}

	public static void connect(TreeLinkNode p) {
		if (p == null)
			return;
		List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		list.add(p);
		while (!list.isEmpty()) {
			TreeLinkNode k = list.get(0), l = null;
			while (!list.isEmpty() && (k.left == null || list.get(0) != k.left)) {
				l = list.get(0);
				list.remove(0);
				if (k.left != null)
					list.add(l.left);
				if (k.right != null)
					list.add(l.right);
				if (!list.isEmpty()
						&& (k.left == null || list.get(0) != k.left)) {
					l.next = list.get(0);
					l = l.next;
				}
			}
			l.next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 1, 2, 3, 4, 5, 6, 7 };
		TreeLinkNode p = CreatTree(array);
		connect(p);
		while (p != null) {
			TreeLinkNode q = p;
			while (q != null) {
				System.out.print(q.val + " ");
				q = q.next;
			}
			System.out.println();
			p = p.left;
		}
	}
}
