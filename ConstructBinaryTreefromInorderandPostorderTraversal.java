public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		TreeNode root = buildchild(inorder, 0, inorder.length - 1, postorder,
				0, postorder.length - 1);
		return root;
	}

	public static TreeNode buildchild(int[] inorder, int ll, int lr,
			int[] postorder, int rl, int rr) {
		if (inorder.length == 0 || ll > lr || rl > rr)
			return null;
		TreeNode root = new TreeNode(postorder[rr]);
		int i = 0, j = 0;
		for (i = ll; i < lr; i++)
			if (postorder[rr] == inorder[i])
				break;
		j = i - ll + rl;
		if (i > 0 && j > 0)
			root.left = buildchild(inorder, ll, i - 1, postorder, rl, j - 1);
		if (j < rr && j >= rl)
			root.right = buildchild(inorder, i + 1, lr, postorder, j, rr - 1);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = { 1, 3, 2, 4 };
		int[] postorder = { 3, 4, 2, 1 };
		buildTree(inorder, postorder);
	}

}
