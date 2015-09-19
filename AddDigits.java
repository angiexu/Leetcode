public class AddDigits {
	public static int addDigits(int num) {
		while (num >= 10) {
			int n = 0;
			while (num >= 10) {
				n = n + num % 10;
				num = num / 10;
				if (num < 10)
					n = n + num;
			}
			num = n;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(0));
	}
}
