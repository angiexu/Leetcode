public class LongestPalindromicSubstring {
	// public static String longestPalindrome(String s) {
	// if (s.length() < 2)
	// return s;
	// String p = null, maxs = null;
	// int i = 0, j = 0, k = 0, max = 0;
	// int start = 0, end = s.length() - 1;
	// while (start != s.length() - 1) {
	// int tag = 0;
	// end = s.length() - 1;
	// for (k = end; k >= 0 && k != start; k--) {
	// if (s.charAt(k) == s.charAt(start)) {
	// end = k;
	// // 判断当前字符串是否回文
	// for (i = start, j = end; i < s.length() && j >= 0; i++, j--) {
	// if (s.charAt(i) != s.charAt(j)) {
	// break;
	// } else {
	// if (i == j || i == j - 1) {
	// p = s.substring(start, end + 1);
	// if (p.length() > max) {
	// max = p.length();
	// maxs = p;
	// tag = 1;
	// break;
	// }
	// }
	// }
	// }
	// }
	// if (tag == 1)
	// break;
	// }
	// start++;
	// if (max > (s.length() - start) || max == s.length())
	// break;
	// }
	// return maxs;
	// }
	public static String longestPalindrome(String s) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "abb";
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// System.out.println(s.length());
		System.out.println(longestPalindrome(s));
	}

}
