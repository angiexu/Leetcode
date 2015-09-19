public class ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (haystack.length() < needle.length())
			return -1;
		int start = 0;
		String hay = haystack;
		while (hay.length() >= needle.length()) {
			int i = 0;
			while (i < hay.length() && hay.charAt(i) != needle.charAt(0))
				i++;
			start = start + i;
			if (hay.substring(i).length() < needle.length())
				return -1;
			if (hay.substring(i, i + needle.length()).equals(needle))
				return start;
			else {
				hay = (haystack.substring(start + 1));
				if (hay.length() < needle.length())
					return -1;
				start = start + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "adfedfe", needle = "";
		System.out.println(strStr(haystack, needle));
	}

}
