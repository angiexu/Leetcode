package based;

import java.util.Scanner;

public class Mainj {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextInt()) {
			int d = reader.nextInt();
			int sum = reader.nextInt();
			if (1 <= d && d <= 30 && 0 <= sum && sum <= 240) {
				int[][] array = new int[d][2];
				Scanner dt = new Scanner(System.in);
				{
					for (int i = 0; i < d; i++)
						for (int j = 0; j < 2; j++)
							array[i][j] = dt.nextInt();
					int num = 0;
					for (int i = 0; i < d; i++)
						num = num + array[i][1];
					if (num < sum)
						System.out.println("No");
					else {
						System.out.println("Yes");
						int max = (8 < sum - 1 ? 8 : sum - 1);
						System.out.println(1 + " " + max);
					}
				}
			}

		}
	}
}
