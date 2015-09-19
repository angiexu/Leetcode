public class HappyNumber {
	public static boolean isHappy(int n) {
		if (n < 9)
			n = n * n;
		while (n > 9) {
			int k = n;
			n = 0;
			while (k > 0) {
				n = n + (k % 10) * (k % 10);
				k = k / 10;
			}
		}
		if (n == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(7));
	}

}
