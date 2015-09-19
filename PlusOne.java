public class PlusOne {
	public static int[] plusOne(int[] digits) {
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		if (digits[digits.length - 1] < 10)
			return digits;
		for (int i = digits.length - 1; i > 0; i--) {
			if (digits[i] >= 10) {
				digits[i - 1] = digits[i - 1] + 1;
				digits[i] = digits[i] - 10;
			}
		}
		if (digits[0] >= 10) {
			int[] plus = new int[digits.length + 1];
			plus[1] = digits[0] - 10;
			plus[0] = 1;
			for (int i = digits.length - 1; i > 0; i--)
				plus[i + 1] = digits[i];
			return plus;
		} else
			return digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 9, 9, 9 };
		digits=plusOne(digits);
		for (int i = 0; i < digits.length; i++)
			System.out.print(digits[i] + " ");
	}

}
