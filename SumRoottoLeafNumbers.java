import java.util.ArrayList;
import java.util.List;


public class SumRoottoLeafNumbers {
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
    public int sumNumbers(TreeNode root) {
        int sum=0;
		return sum;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = { 2, 3, 3, 4, '#', 5, 4 };
		TreeNode p = CreatTree(array);
	}

}
