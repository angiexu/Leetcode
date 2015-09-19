public class StringtoInteger {
	public static int myAtoi(String str) {
		if (str.length() < 1)
			return 0;
		int n = 0, i = 0, j = 0, tag = 0, k = 0;
		char[] array = new char[str.length()];
		while (str.charAt(k) == ' ' || str.charAt(k) == '0')
			k++;
		for (i = k; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				array[j] = str.charAt(i);
				j++;
			} else if (str.charAt(i) == '-') {
				array[j] = str.charAt(i);
				j++;
				tag++;
			} else if (str.charAt(i) == '+') {
				tag++;
			} else
				break;

			if (tag == 2)
				return 0;
		}
		if (j == 0)
			return 0;
		char[] a = new char[j];
		for (i = 0; i < a.length; i++)
			a[i] = array[i];
		if (j == 1 && a[0] == '-')
			return 0;
		try {
			n = Integer.parseInt(String.valueOf(a));
		} catch (NumberFormatException e) {
			if (a[0] == '-')
				return -2147483648;
			else
				return 2147483647;
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "  +0 123";
		// String str ="- hku";
		System.out.println(myAtoi(str));
	}

}
