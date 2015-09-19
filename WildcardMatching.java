import java.util.Arrays;

public class WildcardMatching {
	// public static boolean isMatch(String s, String p) {
	// if (s.length() == 0)
	// if (p.length() == 0 || p.equals("*"))
	// return true;
	// else
	// return false;
	// if (p.length() == 0 && s.length() > 0)
	// return false;
	// if (p.length() == 1)
	// if (s.equals(p) || p.charAt(0) == '?'
	// || (p.charAt(0) == '?' && s.length() == 1))
	// return true;
	// else
	// return false;
	// if (p.charAt(0) == '?')
	// return isMatch(s.substring(1), p.substring(1));
	// else if (p.charAt(0) == '*') {
	// while (s.length() > 0 && s.charAt(0) != p.charAt(1))
	// s = s.substring(1);
	// return isMatch(s, p.substring(1));
	// } else {
	// if (s.charAt(0) != p.charAt(0))
	// return false;
	// else
	// return isMatch(s, p.substring(1));
	// }
	// }
	// public static boolean isMatch(String s, String p) {
	// while (s.length() != 0 || p.length() != 0) {
	// if (s.length() == 0)
	// if (p.length() == 0 || p.equals("*"))
	// return true;
	// else
	// return false;
	// if (p.length() == 0 && s.length() > 0)
	// return false;
	// if (p.length() == 1)
	// if (s.equals(p) || p.charAt(0) == '?'
	// || (p.charAt(0) == '?' && s.length() == 1))
	// return true;
	// else
	// return false;
	// if (p.charAt(0) == '?') {
	// s = s.substring(1);
	// p = p.substring(1);
	// } else if (p.charAt(0) == '*') {
	// while (s.length() > 0 && s.charAt(0) != p.charAt(1))
	// s = s.substring(1);
	// p = p.substring(1);
	// } else {
	// if (s.charAt(0) != p.charAt(0))
	// return false;
	// else {
	// s = s.substring(1);
	// p = p.substring(1);
	// }
	// }
	// }
	// return true;
	// }
	public static boolean isMatch(String s, String p) {
		int ls = s.length();
		int lp = p.length();
		if (ls == 0 && lp == 0)
			return true;
		else if (ls != 0 && lp == 0)
			return false;
		String[] strarr = p.split("[\\*]+", 0);
		if (strarr.length == 0)
			return true;
		boolean firstneedmatch = !p.startsWith("*");
		boolean lastneedmatch = !p.endsWith("*");
		if (!firstneedmatch)
			strarr = Arrays.copyOfRange(strarr, 1, strarr.length);
		if (strarr.length == 0)
			return true;
		int base = 0;
		for (int i = 0; i < strarr.length; i++) {
			if (base > ls - strarr[i].length())
				return false;
			if (i == 0 && firstneedmatch)
				base = -1;
			else if (i == strarr.length - 1 && lastneedmatch)
				base = -2;
			base = getMatchedIdx(s, strarr[i], base);
			if (base == -1)
				return false;
			if (i == strarr.length - 1 && lastneedmatch && base != ls)
				return false;
		}
		return true;
	}

	public static int getMatchedIdx(String s, String pat, int base) {
		char[] sch = s.toCharArray();
		char[] pch = pat.toCharArray();
		int ls = sch.length;
		int lp = pch.length;
		if (base == -1) {
			for (int i = 0; i < lp; i++) {
				if (pch[i] != '?' && pch[i] != sch[i])
					return -1;
			}
			return lp;
		} else if (base == -2) {
			base = ls - lp;
			for (int i = 0; i < lp; i++) {
				if (pch[i] != '?' && pch[i] != sch[base + i])
					return -1;
			}
			return ls;
		} else {
			int limit = ls - lp;
			for (; base <= limit; base++) {
				for (int i = 0; i < lp; i++) {
					if (pch[i] != '?' && pch[i] != sch[base + i])
						break;
					if (i == lp - 1)
						return base + lp;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aab", "c*a*b"));
	}

}
