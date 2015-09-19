public class RomantoInteger {
	public static int romanToInt(String s) {
		char[] array = s.toCharArray();
		int[] a = new int[s.length()];
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (array[i]) {
			case 'I':
				a[i] = 1;
				break;
			case 'V':
				a[i] = 5;
				break;
			case 'X':
				a[i] = 10;
				break;
			case 'L':
				a[i] = 50;
				break;
			case 'C':
				a[i] = 100;
				break;
			case 'D':
				a[i] = 500;
				break;
			case 'M':
				a[i] = 1000;
				break;
			}
		}
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j < s.length(); j++) {
				if (a[i] < a[j]) {
					a[i] = a[j] - a[i];
					a[j] = 0;
				}
			}
		for (int i = 0; i < s.length(); i++) {
			sum = sum + a[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "MMMCMXCIX";
		int s = romanToInt(x);
		System.out.println(s);
	}
}
