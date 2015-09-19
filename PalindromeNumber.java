public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length() / 2; i++) {
			if (array[i] != array[s.length() - i - 1])
				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 123334521;
		System.out.println(isPalindrome(x));

	}

}
