public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		TreeNode root = buildchild(preorder, 0, preorder.length - 1, inorder,
				0, inorder.length - 1);
		return root;
	}

	public static TreeNode buildchild(int[] preorder, int ll, int lr,
			int[] inorder, int rl, int rr) {
		if (preorder.length == 0)
			return null;
		TreeNode root = new TreeNode(preorder[ll]);
		int i = 0, j = 0;
		for (j = rl; j < rr; j++)
			if (inorder[j] == preorder[ll])
				break;
		i = j - rl + ll;
		if (j <= rr && j > rl)
			root.left = buildchild(preorder, ll + 1, i, inorder, rl, j - 1);
		if (i < lr && i < preorder.length - 1 && j < preorder.length - 1)
			root.right = buildchild(preorder, i + 1, lr, inorder, j + 1, rr);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = { 1, 2 };
		int[] inorder = { 1, 2 };
		buildTree(preorder, inorder);
	}
}
