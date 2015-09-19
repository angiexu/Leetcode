import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		List<String> l = new ArrayList<String>();
		if (digits.length() == 0)
			return l;
		String[] array = new String[digits.length()];
		for (int i = 0; i < digits.length(); i++) {
			switch (digits.charAt(i)) {
			case '1':
				array[i] = null;
				break;
			case '2':
				array[i] = "abc";
				break;
			case '3':
				array[i] = "def";
				break;
			case '4':
				array[i] = "ghi";
				break;
			case '5':
				array[i] = "jkl";
				break;
			case '6':
				array[i] = "mno";
				break;
			case '7':
				array[i] = "pqrs";
				break;
			case '8':
				array[i] = "tuv";
				break;
			case '9':
				array[i] = "wxyz";
				break;
			}
		}
		String s = null;
		for (int i = 0; i < array[0].length(); i++)
			l.add(array[0].charAt(i) + "");
		for (int i = 1; i < array.length; i++) {
			while (l.get(0).toString().length() == i) {
				s = l.get(0).toString();
				l.remove(s);
				for (int k = 0; k < array[i].length(); k++)
					l.add(s + array[i].charAt(k));
			}
		}
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "272";
		List<String> l = letterCombinations(digits);
		Iterator<String> it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
