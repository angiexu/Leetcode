package based;

import java.util.Scanner;

public class Main3 {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextInt()) {
			int n = reader.nextInt();
			int b = reader.nextInt();
			int[] arrays = new int[n + 1];
			if (1 <= b && b <= n && n <= 1000000000) {
				for (int i = 0; i <= n + 1; i++) {
					if (i == b)
						continue;
					int amaxdif = Math.abs(b - i) - 1;
					int start = i - amaxdif;
					if (start < 0)
						start = 0;
					int end = i + amaxdif;
					if (end > n)
						end = n;
					for (int j = start; j <= end; j++) {
						arrays[j]++;
					}
				}
				int max = n, num = arrays[n];
				for (int i = n; i >= 0; i--)
					if (arrays[i] >= num) {
						num = arrays[i];
						max = i;
					}
				System.out.println(max);
			}
		}
	}
}