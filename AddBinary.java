public class AddBinary {
	// 第一种，211
	// public static String addBinary(String a, String b) {
	// char[] ar = a.toCharArray();
	// char[] br = b.toCharArray();
	// int x = 0, y = 0, t = 0;
	// // x小，y大
	// if (ar.length < br.length) {
	// x = ar.length;
	// y = br.length;
	// } else {
	// x = br.length;
	// y = ar.length;
	// }
	// char[] array = new char[y + 1];
	// array[y] = '0';
	// int i = 0, j = 0, k = 0;
	// for (i = ar.length - 1, j = br.length - 1, k = y; i >= 0 && j >= 0; i--,
	// j--, k--) {
	// if ((ar[i] == '0' && br[j] == '0' && array[k] == '1')
	// || (ar[i] == '0' && br[j] == '1' && array[k] == '0')
	// || (ar[i] == '1' && br[j] == '0' && array[k] == '0')) {
	// array[k] = '1';
	// array[k - 1] = '0';
	// } else if ((ar[i] == '1' && br[j] == '0' && array[k] == '1')
	// || (ar[i] == '1' && br[j] == '1' && array[k] == '0')
	// || (ar[i] == '0' && br[j] == '1' && array[k] == '1')) {
	// array[k] = '0';
	// array[k - 1] = '1';
	// } else if ((ar[i] == '1' && br[j] == '1' && array[k] == '1')) {
	// array[k] = '1';
	// array[k - 1] = '1';
	// } else if ((ar[i] == '0' && br[j] == '0' && array[k] == '0')) {
	// {
	// array[k] = '0';
	// array[k - 1] = '0';
	// }
	// }
	// }
	// if (i >= 0)
	// for (i = i, k = k; i >= 0; i--, k--) {
	// if ((ar[i] == '0' && array[k] == '1')
	// || (ar[i] == '1' && array[k] == '0')) {
	// array[k] = '1';
	// array[k - 1] = '0';
	// } else if (ar[i] == '1' && array[k] == '1') {
	// array[k] = '0';
	// array[k - 1] = '1';
	// } else if ((ar[i] == '0' && array[k] == '0')) {
	// array[k] = '0';
	// array[k - 1] = '0';
	// }
	// }
	// else if (j >= 0)
	// for (j = j, k = k; j >= 0; j--, k--) {
	// if ((br[j] == '0' && array[k] == '1')
	// || (br[j] == '1' && array[k] == '0')) {
	// array[k] = '1';
	// array[k - 1] = '0';
	// } else if (br[j] == '1' && array[k] == '1') {
	// array[k] = '0';
	// array[k - 1] = '1';
	// } else if ((br[j] == '0' && array[k] == '0')) {
	// array[k] = '0';
	// array[k - 1] = '0';
	// }
	// }
	// while (t < array.length && array[t] != '1')
	// t++;
	// int n = array.length - t;
	// if (n == 0)
	// return "0";
	// char[] arr = new char[n];
	// for (i = 0, j = t; i < arr.length; i++, j++)
	// arr[i] = array[j];
	// String s = String.valueOf(arr);
	// return s;
	// }
	// 第二种，223s
	// public static String addBinary(String a, String b) {
	// char[] ar = null;
	// char[] br = null;
	// int x = 0, y = 0, t = 0;
	// // x小，y大 ar小，br大
	// if (a.length() < b.length()) {
	// ar = a.toCharArray();
	// br = b.toCharArray();
	// } else {
	// ar = b.toCharArray();
	// br = a.toCharArray();
	// }
	// x = ar.length;
	// y = br.length;
	// char[] array = new char[y + 1];
	// array[y] = '0';
	// int i = 0, j = 0, k = 0;
	// for (i = ar.length - 1, j = br.length - 1, k = y; i >= 0; i--, j--, k--)
	// {
	// if ((ar[i] == '0' && br[j] == '0' && array[k] == '1')
	// || (ar[i] == '0' && br[j] == '1' && array[k] == '0')
	// || (ar[i] == '1' && br[j] == '0' && array[k] == '0')) {
	// array[k] = '1';
	// array[k - 1] = '0';
	// } else if ((ar[i] == '1' && br[j] == '0' && array[k] == '1')
	// || (ar[i] == '1' && br[j] == '1' && array[k] == '0')
	// || (ar[i] == '0' && br[j] == '1' && array[k] == '1')) {
	// array[k] = '0';
	// array[k - 1] = '1';
	// } else if ((ar[i] == '1' && br[j] == '1' && array[k] == '1')) {
	// array[k] = '1';
	// array[k - 1] = '1';
	// } else if ((ar[i] == '0' && br[j] == '0' && array[k] == '0')) {
	// {
	// array[k] = '0';
	// array[k - 1] = '0';
	// }
	// }
	// }
	// if (j >= 0)
	// for (j = j, k = k; j >= 0; j--, k--) {
	// if ((br[j] == '0' && array[k] == '1')
	// || (br[j] == '1' && array[k] == '0')) {
	// array[k] = '1';
	// array[k - 1] = '0';
	// } else if (br[j] == '1' && array[k] == '1') {
	// array[k] = '0';
	// array[k - 1] = '1';
	// } else if ((br[j] == '0' && array[k] == '0')) {
	// array[k] = '0';
	// array[k - 1] = '0';
	// }
	// }
	// while (t < array.length && array[t] != '1')
	// t++;
	// int n = array.length - t;
	// if (n == 0)
	// return "0";
	// char[] arr = new char[n];
	// for (i = 0, j = t; i < arr.length; i++, j++)
	// arr[i] = array[j];
	// String s = String.valueOf(arr);
	// return s;
	// }

	public static String addBinary(String a, String b) {
		char[] ar = null;
		char[] br = null;
		int y = 0, t = 0;
		// x小，y大 ar小，br大
		if (a.length() < b.length()) {
			ar = a.toCharArray();
			br = b.toCharArray();
		} else {
			ar = b.toCharArray();
			br = a.toCharArray();
		}
		y = br.length;
		char[] array = new char[y + 1];
		array[y] = '0';
		int i = 0, j = 0, k = 0;
		for (i = ar.length - 1, j = br.length - 1, k = y; i >= 0; i--, j--, k--) {
			int l = (int) (ar[i] - 48) + (int) (br[j] - 48)
					+ (int) (array[k] - 48);
			if (l == 1) {
				array[k] = '1';
				array[k - 1] = '0';
			} else if (l == 2) {
				array[k] = '0';
				array[k - 1] = '1';
			} else if (l == 3) {
				array[k] = '1';
				array[k - 1] = '1';
			} else if (l == 0) {
				{
					array[k] = '0';
					array[k - 1] = '0';
				}
			}
		}
		if (j >= 0)
			for (; j >= 0; j--, k--) {
				int l = ((int) (br[j] - 48) + (int) (array[k] - 48));
				if (l == 1) {
					array[k] = '1';
					array[k - 1] = '0';
				} else if (l == 2) {
					array[k] = '0';
					array[k - 1] = '1';
				} else if (l == 0) {
					array[k] = '0';
					array[k - 1] = '0';
				}
			}
		while (t < array.length && array[t] != '1')
			t++;
		int n = array.length - t;
		if (n == 0)
			return "0";
		char[] arr = new char[n];
		for (i = 0, j = t; i < arr.length; i++, j++)
			arr[i] = array[j];
		String s = String.valueOf(arr);
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		// String a = "11";
		// String b = "1";
		System.out.println(addBinary(a, b));
	}

}
