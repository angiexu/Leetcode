import java.util.Stack;

public class LongestValidParentheses {
	// public static int longestValidParentheses(String s) {
	// int n = 0, max = 0;
	// for (int k = 0; k < s.length() - 1; k++) {
	// int i = 0, j = 0;
	// for (i = k, j = k + 1; i >= 0 && j < s.length(); i--, j++)
	// if (!((s.charAt(i) == '(' && s.charAt(j) == ')') || (s
	// .charAt(i) == ')' && s.charAt(j) == '(')))
	// break;
	// n = j - i - 1;
	// int t = 0;
	// if (i != j - 1)
	// while (s.substring(i + 1, j).charAt(t) == ')') {
	// n = n - 2;
	// t++;
	// }
	// if (n > max)
	// max = n;
	// }
	// return max;
	// }
	// 超时
	// public static int longestValidParentheses(String s) {
	// int n = 0, max = 0;
	// Stack<String> stack = new Stack<String>();
	// for (int i = 0, j = 0; i < s.length(); i++) {
	// stack.clear();
	// for (j = i; j < s.length(); j++) {
	// if (s.charAt(j) == '(')
	// stack.push("(");
	// else if (!stack.isEmpty() && stack.peek() == "(")
	// stack.pop();
	// else
	// break;
	// if (stack.size() > s.length() - j - 1)
	// break;
	// }
	// n = j - i;
	// if (stack.isEmpty() && n > max)
	// max = n;
	// if (max > s.length() - i)
	// break;
	// }
	// return max;
	// }
	public static int longestValidParentheses(String s) {
		int n = 0, max = 0, last = -1;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (!stack.isEmpty())
						n = i-stack.peek();
					else
						n = i - last;
					if (n > max)
						max = n;
				} else
					last = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()(())";
		System.out.println(longestValidParentheses(s));
	}

}
