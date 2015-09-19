public class LongestCommonPrefix {
	// 第一种：貌似不对
	public static String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		char[][] array = new char[strs.length][];
		String s = "";
		for (int i = 0; i < strs.length; i++) {
			array[i] = strs[i].toCharArray();
		}
		if (array[0].length == 0)
			return "";
		char[] a = new char[array[0].length];
		try {
			for (int j = 0; j < array[0].length; j++)
				for (int i = 1; i < array.length; i++) {
					if (array[0][j] == array[i][j])
						a[j] = array[0][j];
					else {
						s = String.valueOf(a);
						return s;
					}
				}
		} catch (Exception e) {
			s = String.valueOf(a);
			return s;
		}
		s = String.valueOf(a);
		return s;
	}

	// 第二种
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int min = Math.min(s.length(), strs[i].length());
			int j = 0;
			while (j < min && s.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			s = s.substring(0, j);
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "abdds", "abdde", "abc" };
		String s = longestCommonPrefix(strs);
		System.out.println(s);
	}

}
