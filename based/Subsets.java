package based;

import java.util.ArrayList;
import java.util.Iterator;

public class Subsets {
	public static ArrayList<String> subset(char[] s) {
		ArrayList<String> subS = new ArrayList<String>();
		int n = s.length;
		if (n == 0)
			return subS;
		for (int count = 0; count <= n; count++)
			set(s, 0, count, new String(), subS);
		return subS;
	}

	public static void set(char[] s, int begin, int count, String t,
			ArrayList<String> subS) {
		if (t.length() == count) {
			subS.add(t);
			return;
		}
		for (int i = begin; i < s.length; i++) {
			t = t + s[i];
			set(s, i + 1, count, t, subS);
			t = t.substring(0, t.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = { 'a', 'b', 'c', 'd' };
		ArrayList<String> subS = subset(s);
		Iterator<String> it = subS.iterator();
		System.out.println(subS.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
