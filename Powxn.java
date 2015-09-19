public class Powxn {
	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 1)
			return 1;
		if (x == -1)
			if (n % 2 != 0)
				return -1;
			else
				return 1;
		double num = x;
		int time = n;
		if (n < 0)
			time = -n;
		for (int i = 1; i < time && num != 0;) {
			if (time > 2 * i) {
				num = num * num;
				i = i * 2;
			} else {
				num = num * x;
				i++;
			}
		}
		if (n < 0)
			num = 1 / num;
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 13.62608;
		int b = -3;
		System.out.println(Math.pow(a, b));
		System.out.println(myPow(a, b));
	}

}
