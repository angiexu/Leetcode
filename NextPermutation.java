import java.util.Arrays;

public class NextPermutation {
	// 299s
	// public static void nextPermutation(int[] num) {
	// if (num.length < 2)
	// return;
	// for (int i = num.length - 1; i > 0; i--)
	// if (num[i] > num[i - 1]) {
	// change(num, i - 1);
	// return;
	// }
	// Arrays.sort(num);
	// return;
	// }
	//
	// public static void change(int[] num, int i-1) {
	// int k = num[i-1];
	// Arrays.sort(num, i-1, num.length);
	// int j = 0;
	// for (j = i-1; j < num.length; j++)
	// if (num[j] > k)
	// break;
	// k = num[j];
	// for (int i = j; i > i-1; i--)
	// num[i] = num[i - 1];
	// num[i-1] = k;
	// return;
	// }

	// 292s
	public static void nextPermutation(int[] num) {
		if (num.length < 2)
			return;
		for (int i = num.length - 1; i > 0; i--)
			if (num[i] > num[i - 1]) {
				int k = num[i - 1];
				Arrays.sort(num, i - 1, num.length);
				int j = 0;
				for (j = i - 1; j < num.length; j++)
					if (num[j] > k)
						break;
				k = num[j];
				for (int t = j; t > i - 1; t--)
					num[t] = num[t - 1];
				num[i - 1] = k;
				return;
			}
		Arrays.sort(num);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 2, 0, 3, 0, 1, 2, 4 };
		nextPermutation(num);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]);
	}

}
