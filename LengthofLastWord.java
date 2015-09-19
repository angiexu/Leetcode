public class LengthofLastWord {
	// 第一种：200s
	public static int lengthOfLastWord(String s) {
		int n = 0;
		int k = 0;
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (array[i] == ' ') {
				k = 0;
			} else {
				k++;
			}
			if (k != 0)
				n = k;
		}
		return n;
	}

	// 第二种：210s
	// public static int lengthOfLastWord(String s) {
	// int n = 0;
	// char[] array = s.toCharArray();
	// for (int i = s.length()-1; i >= 0; i--) {
	// if (array[i] != ' ')
	// n++;
	// else {
	// if (n != 0)
	// break;
	// }
	// }
	// return n;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  a";
		System.out.println(lengthOfLastWord(s));

	}

}
