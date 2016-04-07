package based;

//import java.util.*;

public class HUI {
	public static int LCS1(String s, String r) {
		if (s.length() == 0 || r.length() == 0)
			return 0;
		if (s.charAt(0) != r.charAt(0))
			return Math.max(LCS1(s.substring(1), r), LCS1(s, r.substring(1)));
		else
			return 1 + LCS1(s.substring(1), r.substring(1));
	}

	public static String LCS(String s) {
		String t = new StringBuffer(s).reverse().toString();
		int n = s.length();
		int m = t.length();
		int[][] len = new int[n + 1][m + 1];
		int[][] path = new int[n + 1][m + 1];
		LCSL(s, t, len, path);
		System.out.println(len[n][m]);
		StringBuffer ps = new StringBuffer();
		LCSP(n, m, s, ps, path);
		return ps.toString();
	}

	public static void LCSL(String s, String t, int[][] len, int[][] path) {
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

	public static void LCSP(int i, int j, String s, StringBuffer ps,
			int[][] path) {
		if (i == 0 || j == 0)
			return;
		if (path[i][j] == 1) {
			LCSP(i - 1, j - 1, s, ps, path);
			ps.append(s.charAt(i - 1));
		} else if (path[i][j] == 2)
			LCSP(i - 1, j, s, ps, path);
		else
			LCSP(i, j - 1, s, ps, path);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cabhbeaf";
		String sr = " f";
		// Scanner sc = new Scanner(System.in);
		// String s = sc.nextLine();
		// StringBuffer sb = new StringBuffer(s);
		// String sr = sb.reverse().toString();
		System.out.println(LCS1(s, sr));
		System.out.println(LCS(s));
	}
}
