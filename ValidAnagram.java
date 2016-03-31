public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		int[] num = new int[26];
		int n = s.length();
		for (int i = 0; i < n; i++)
			num[s.charAt(i) - 97]++;
		for (int i = 0; i < n; i++)
			num[t.charAt(i) - 97]--;
		for (int i = 0; i < 26; i++)
			if (num[i] != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a", t = "b";
		
		System.out.println(isAnagram(s, t));
	}

}
