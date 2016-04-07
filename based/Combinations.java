package based;

import java.util.ArrayList;
import java.util.Iterator;

public class Combinations {
	public static ArrayList<String> combine(char[] s) {
		ArrayList<String> perS = new ArrayList<String>();
		if (s.length == 0)
			return perS;
		int n = s.length;
		char[] num = new char[n];
		for (int i = 0; i < n; i++) {
			num[0] = s[i];
			full(s, num, n, i, perS);
		}
		return perS;
	}

	public static void full(char[] s, char[] num, int length, int index,
			ArrayList<String> perS) {
		if (index == length - 1) {
			perS.add(String.valueOf(num));
			return;
		}
		int n = s.length;
		for (int i = 0; i < n; i++) {
			num[index + 1] = s[i];
			full(s, num, length, index + 1, perS);
		}
	}

	public static ArrayList<String> permute(char[] s) {
		ArrayList<String> perS = new ArrayList<String>();
		int n = s.length;
		if (n == 0)
			return perS;
		for (int begin = 0; begin < n; begin++)
			full(s, begin, perS);
		return perS;
	}

	public static void full(char[] s, int begin, ArrayList<String> perS) {
		int n = s.length;
		perS.add(String.valueOf(s).substring(0, begin));
		for (int i = begin + 1; i < n; i++) {
			char temp = s[i];
			s[i] = s[begin];
			s[begin] = temp;
			full(s, begin + 1, perS);
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
