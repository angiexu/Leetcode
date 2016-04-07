public class LongestPalindromicSubstring {
	public static String longestPalindrome1(String s) {
		if (s.length() < 2)
			return s;
		String p = null, maxs = null;
		int i = 0, j = 0, max = 0;
		int start = 0, mid = 0, end = 0;
		for (mid = 1; mid < s.length(); mid++) {
			int tag = 0;
			if (s.charAt(mid - 1) == s.charAt(mid)) {
				start = mid - 1;
				end = mid;
				for (i = start, j = end; i >= 0 && j < s.length(); i--, j++) {
					if (s.charAt(i) != s.charAt(j))
						break;
					else
						tag = 1;
				}
			}
			if (tag == 1) {
				p = s.substring(i + 1, j);
				if (max < p.length()) {
					max = p.length();
					maxs = p;
				}
			}
			if (mid < s.length() - 1 && s.charAt(mid - 1) == s.charAt(mid + 1)) {
				start = mid - 1;
				end = mid + 1;
				for (i = start, j = end; i >= 0 && j < s.length(); i--, j++) {
					if (s.charAt(i) != s.charAt(j))
						break;
					else
						tag = 1;
				}
			}
			if (tag == 1) {
				p = s.substring(i + 1, j);
				if (max < p.length()) {
					max = p.length();
					maxs = p;
				}
			}
		}
		return maxs;
	}

	public static String longestPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		String t = sb.reverse().toString();
		int n = s.length();
		int m = t.length();
		int[][] len = new int[n + 1][m + 1];
		int[][] path = new int[n + 1][m + 1];
		longestSubtstring(s, t, len, path);
		StringBuffer pathString = new StringBuffer();
		longestPath(n, m, s, pathString, path);
		return pathString.toString();
	}

	public static void longestSubtstring(String s, String t, int[][] len,
			int[][] path) {
		int n = s.length();
		int m = t.length();
		if (s == null || t == null)
			return;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					len[i][j] = len[i - 1][j - 1] + 1;
					path[i][j] = 1;
				} else if (len[i - 1][j] >= len[i][j - 1]) {
					len[i][j] = len[i - 1][j];
					path[i][j] = 2;
				} else {
					len[i][j] = len[i][j - 1];
					path[i][j] = 3;
				}
	}

	public static void longestPath(int i, int j, String s,
			StringBuffer pathString, int[][] path) {
		if ((i == 0) || (j == 0))
			return;
		if (path[i][j] == 1) {
			longestPath(i - 1, j - 1, s, pathString, path);
			pathString.append(s.charAt(i - 1));
		} else {
			if (path[i][j] == 2)
				longestPath(i - 1, j, s, pathString, path);
			else
				longestPath(i, j - 1, s, pathString, path);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbcb";
		// System.out.println(s.length());
		System.out.println(longestPalindrome(s));
	}

}
