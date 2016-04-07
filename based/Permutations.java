package based;

import java.util.ArrayList;
import java.util.Iterator;

public class Permutations {
	public static ArrayList<String> permute(char[] s) {
		ArrayList<String> perS = new ArrayList<String>();
		if (s.length == 0)
			return perS;
		per(s, 0, perS);
		return perS;
	}

	public static void per(char[] s, int begin, ArrayList<String> perS) {
		int n = s.length;
		if (begin == n) {
			perS.add(String.valueOf(s));
			return;
		}
		for (int i = begin; i < n; i++) {
			char temp = s[i];
			s[i] = s[begin];
			s[begin] = temp;
			per(s, begin + 1, perS);
			temp = s[i];
			s[i] = s[begin];
			s[begin] = temp;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = { 'a', 'b', 'c' };
		ArrayList<String> perS = permute(s);
		Iterator<String> it = perS.iterator();
		System.out.println(perS.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
