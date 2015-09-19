public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if ((s.length() != 0 && p.length() == 0))
			return false;
		if (s.length() == 0 && p.length() == 0)
			return true;
		if (p.length() == 1)
			if (s.equals(p) || (p.charAt(0) == '.' && s.length() == 1))
				return true;
			else
				return false;
		if (p.charAt(1) != '*') {
			if (s.length() > 0
					&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
				return isMatch(s.substring(1), p.substring(1));
			else
				return false;
		} else {// p.charAt(1) == '*'
			while (s.length() > 0
					&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		}// p.charAt(1) == '*'
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		String p = ".*..a*";
		System.out.println(isMatch(s, p));
	}

}
