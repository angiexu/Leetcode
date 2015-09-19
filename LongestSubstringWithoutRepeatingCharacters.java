public class LongestSubstringWithoutRepeatingCharacters {
	// 最后一个超时
	// public static int lengthOfLongestSubstring(String s) {
	// if (s.length() <= 1)
	// return s.length();
	// int n = 0, i = 0, num = 0;
	// char a;
	// char[] array = s.toCharArray();
	// Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	// while (i < s.length()) {
	// if (ht.get(String.valueOf(array[i])) == null) {
	// ht.put(String.valueOf(array[i]), i);
	// num++;
	// i++;
	// } else {
	// i = ht.get(String.valueOf(array[i]))+1;
	// if (n < num)
	// n = num;
	// num = 0;
	// ht.clear();
	// }
	// }
	// if (n < num)
	// n = num;
	// return n;
	// }
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1)
			return 1;
		int n = 1;
		boolean[] exist = new boolean[256];
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// 存在s[i]：ch
			if (exist[ch]) {
				// i - start：两个ch之间的字符长，其中包含一个ch
				n = Math.max(n, i - start);
				// 字符串中ch之前的字符标记不存在，从ch后开始查重
				for (int k = start; k < i; k++) {
					if (s.charAt(k) == ch) {
						start = k + 1;
						break;
					}
					exist[s.charAt(k)] = false;
				}
			} else
				exist[ch] = true;
		}
		n = Math.max(n, s.length() - start);
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabc";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
