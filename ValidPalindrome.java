public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		boolean bo = true;
		int i = 0, j = s.length() - 1;
		s = s.toLowerCase();
		while (i < j) {
			if ((s.charAt(i) < 'a' || s.charAt(i) > 'z')
					&& (s.charAt(i) < '0' || s.charAt(i) > '9'))
				i++;
			else if ((s.charAt(j) < 'a' || s.charAt(j) > 'z')
					&& (s.charAt(j) < '0' || s.charAt(j) > '9'))
				j--;
			else {
				if (s.charAt(i) == s.charAt(j)) {
					i++;
					j--;
				} else {
					bo = false;
					break;
				}
			}
		}
		return bo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1a3";
		System.out.println(isPalindrome(s));
	}

}
