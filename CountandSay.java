public class CountandSay {
	// 第一种Memory Limit Exceeded
	// public static String countAndSay(int n) {
	// String s = "1";
	// for (int i = 1; i < n; i++)
	// s = countSay(s);
	// return s;
	//
	// }
	// public static String countSay(String s) {
	// char[] array = s.toCharArray();
	// char[] a = new char[2 * array.length];
	// int tag = 0;
	// for (int i = 0; i < array.length; i++) {
	// int m = 1;
	// while (i < array.length - 1)
	// if (array[i] == array[i + 1]) {
	// m++;
	// i++;
	// } else
	// break;
	// a[tag] = (char) (m + 48);
	// tag++;
	// a[tag] = array[i];
	// tag++;
	// }
	// s = String.valueOf(a);
	// return s;
	// }
	// 第二种
	// public static String countAndSay(int n) {
	// if (n == 1)
	// return "1";
	// else {
	// String s = String.valueOf(n);
	// char[] array = s.toCharArray();
	// char[] a = new char[2 * array.length];
	// int tag = 0;
	// for (int i = 0; i < array.length; i++) {
	// int m = 1;
	// while (i < array.length - 1)
	// if (array[i] == array[i + 1]) {
	// m++;
	// i++;
	// } else
	// break;
	// a[tag] = (char) (m + 48);
	// tag++;
	// a[tag] = array[i];
	// tag++;
	// }
	// int x = Integer.parseInt(String.valueOf(a));
	// return countAndSay(x-1);
	// }
	//
	// }
	// 第三种
	public static String countAndSay(int n) {
		String s = "1";
		if (n > 1) {
			for (int i = 1; i < n; i++) {
				char[] array = s.toCharArray();
				char[] a = new char[2 * array.length];
				int tag = 0;
				for (int j = 0; j < array.length; j++) {
					int m = 1;
					while (j < array.length - 1)
						if (array[j] == array[j + 1]) {
							m++;
							j++;
						} else
							break;
					a[tag] = (char) (m + 48);
					tag++;
					a[tag] = array[j];
					tag++;
				}
				char[] b = new char[tag];
				for (int l = 0; l < b.length; l++)
					b[l] = a[l];
				s = String.valueOf(b);
			}
		}

		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		System.out.println(countAndSay(n));

	}

}
