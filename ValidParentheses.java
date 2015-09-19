public class ValidParentheses {
	public static boolean isValid(String s) {
		boolean a = true;
		char[] array = new char[s.length()];
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char k = s.charAt(i);
			if (k == '(' || k == '{' || k == '[') {
				array[j] = k;
				j++;
			} else if (j != 0
					&& ((k == ')' && array[j - 1] == '(')
							|| (k == '}' && array[j - 1] == '{') || (k == ']' && array[j - 1] == '[')))
				j--;
			else
				a = false;
		}
		if (j > 0)
			a = false;
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()[]";
		System.out.println(isValid(s));
	}

}