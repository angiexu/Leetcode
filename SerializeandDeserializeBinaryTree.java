import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static void print(TreeNode root) {
		if (root == null)
			return;
		else {
			System.out.print(root.val + " ");
			print(root.left);
			print(root.right);
		}
	}
	// 超时
	public static class Codec1 {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			String data = "";
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			int i = 0, j = 1;
			while (i < list.size()) {
				j = list.size();
				while (i < j) {
					TreeNode p = list.get(i);
					if (p != null) {
						data = data + ',' + String.valueOf(p.val);
						if (p.left != null) {
							list.add(p.left);
						} else
							list.add(null);
						if (p.right != null) {
							list.add(p.right);
						} else
							list.add(null);
					} else
						data += ",null";
					i++;
				}
			}
			for (i = data.length() - 1; i >= 0; i--)
				if ((data.charAt(i) >= '0' && data.charAt(i) <= '9'))
					break;
			data = data.substring(1, i + 1);
			return data;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.length() == 0)
				return null;
			TreeNode root = null;
			int i = 0;
			if (data.charAt(i) != '-') {
				int k = data.charAt(i) - '0';
				while (i < data.length() - 1 && data.charAt(++i) != ',')
					k = k * 10 + data.charAt(i) - '0';
				root = new TreeNode(k);
			} else {
				int k = -1 * (data.charAt(++i) - '0');
				while (data.charAt(++i) != ',')
					k = k * 10 + data.charAt(i) - '0';
				root = new TreeNode(k);
			}
			i++;
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			while (i < data.length()) {
				TreeNode p = list.get(0);
				list.remove(0);
				if (data.charAt(i) != 'n') {
					if (data.charAt(i) != '-') {
						int k = data.charAt(i) - '0';
						while (i < data.length() - 1 && data.charAt(++i) != ',')
							k = k * 10 + data.charAt(i) - '0';
						p.left = new TreeNode(k);
					} else {
						int k = -1 * (data.charAt(++i) - '0');
						while (i < data.length() - 1 && data.charAt(++i) != ',')
							k = k * 10 + data.charAt(i) - '0';
						p.left = new TreeNode(k);
					}
					list.add(p.left);
				} else
					i = i + 4;
				i++;
				if (i < data.length() && data.charAt(i) != 'n') {
					if (data.charAt(i) != '-') {
						int k = data.charAt(i) - '0';
						while (i < data.length() - 1 && data.charAt(++i) != ',')
							k = k * 10 + data.charAt(i) - '0';
						p.right = new TreeNode(k);
					} else {
						int k = -1 * (data.charAt(++i) - '0');
						while (i < data.length() - 1 && data.charAt(++i) != ',')
							k = k * 10 + data.charAt(i) - '0';
						p.right = new TreeNode(k);
					}

					list.add(p.right);
				} else
					i = i + 4;
				i++;
			}
			return root;
		}
	}

		// 还是超时
	public static class Codec2 {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			ArrayList<Integer> li = new ArrayList<Integer>();
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			int i = 0, j = 1;
			while (i < list.size()) {
				j = list.size();
				while (i < j) {
					TreeNode p = list.get(i);
					if (p != null) {
						li.add(p.val);
						if (p.left != null) {
							list.add(p.left);
						} else
							list.add(null);
						if (p.right != null) {
							list.add(p.right);
						} else
							list.add(null);
					} else {
						li.add(null);
					}
					i++;
				}
			}
			return li.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.length() == 0)
				return null;
			ArrayList<Integer> li = d(data);
			TreeNode root = new TreeNode(li.get(0));
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			int i = 1;
			while (i < li.size() && list.size() > 0) {
				TreeNode p = list.get(0);
				list.remove(0);
				if (li.get(i) != null) {
					p.left = new TreeNode(li.get(i));
					list.add(p.left);
				}
				i++;
				if (i < li.size() && li.get(i) != null) {
					p.right = new TreeNode(li.get(i));
					list.add(p.right);
				}
				i++;
			}
			return root;
		}

		public ArrayList<Integer> d(String data) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (data.length() != 0) {
				while (data.charAt(0) != 'n'
						&& !(data.charAt(0) >= '0' && data.charAt(0) <= '9'))
					data = data.substring(1);
				int i = 0, k = 1;
				if (data.charAt(0) == 'n') {
					list.add(null);
					data = data.substring(5);
				} else {
					if (data.charAt(0) == '-') {
						k = -1;
						i++;
					}
					while (i < data.length() && data.charAt(i) != ','
							&& (data.charAt(i) >= '0' && data.charAt(i) <= '9')) {
						k *= data.charAt(i) - '0';
						i++;
					}
					list.add(k);
					if (i == data.length())
						return list;
					data = data.substring(++i);
				}
			}
			return list;
		}
	}

	public static class Codec {
		public String serialize(TreeNode root) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			s(root, result);
			return result.toString();
		}

		private void s(TreeNode root, ArrayList<Integer> result) {
			if (root == null) {
				result.add(null);
				return;
			}
			result.add(root.val);
			s(root.left, result);
			s(root.right, result);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] strArray = data.substring(1, data.length() - 1)
					.split(", ");//字符串分割
			Deque<String> list = new LinkedList<String>(Arrays.asList(strArray));//双向队列
			return d(list);
		}

		private TreeNode d(Deque<String> list) {
			if (list.size() == 0)
				return null;
			String str = list.pop();
			if (str.equals("null"))
				return null;
			TreeNode currentRoot = new TreeNode(Integer.parseInt(str));
			currentRoot.left = d(list);
			currentRoot.right = d(list);
			return currentRoot;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec codec = new Codec();
		TreeNode root = codec.deserialize("[1, 2, 3, null, null, 4, 5]");
		System.out.println(codec.serialize(root));
		print(codec.deserialize(codec.serialize(root)));
	}
}
