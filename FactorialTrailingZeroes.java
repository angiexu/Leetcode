public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		int num = 0;
		while (n != 0) {
			num = num + (n / 5);
			n = n / 5;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(50));
	}

}
