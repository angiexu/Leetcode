public class ReverseInteger {
	// 第一种
	public static int reverse1(long x) {
		if (x > 2147483647 || x < -2147483648)
			return 0;
		String s = String.valueOf(x);
		char[] array = s.toCharArray();
		char[] a = new char[s.length()];
		int m = 0;
		if (x < 0) {
			m = 1;
			a[0] = '-';
		}
		for (int i = m, j = s.length() - 1; i < s.length(); i++, j--)
			a[i] = array[j];
		String ss = String.valueOf(a);
		int x1 = 0;
		try {
			x1 = Integer.parseInt(ss);
		} catch (Exception e) {
			return 0;
		}
		return x1;
	}

	// 第二种
	public static int reverse(int x) {
		if (x > 2147483647 || x < -2147483648)
			return 0;
		int res = 0;
		while (x != 0) {
			int tag = res;
			if (tag != res * 10 / 10)
				return 0;
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -2147483648;
		int y = reverse1(x);
		System.out.println(y);
	}

}
