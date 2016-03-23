package based;
public class twoArray {
	public static void merge(int[] arrays1, int[] arrays2) {
		int i1 = 0, i2 = arrays1.length - 1, j = arrays2.length - 1;
		while (arrays1[i1] != 0)
			i1++;
		i1--;
		while (i1 >= 0 && j >= 0) {
			while (j >= 0 && arrays2[j] > arrays1[i1])
				arrays1[i2--] = arrays2[j--];
			if (j < 0)
				return;
			while (i1 >= 0 && arrays2[j] < arrays1[i1])
				arrays1[i2--] = arrays1[i1--];
		}
		while (j >= 0)
			arrays1[i2--] = arrays2[j--];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrays1 = new int[8];
		arrays1[0] = 5;
		arrays1[1] = 7;
		arrays1[2] = 9;
		arrays1[3] = 11;
		int[] arrays2 = { 6, 8, 10, 12 };
		merge(arrays1, arrays2);
		for (int i = 0; i < arrays1.length; i++) {
			System.out.print(arrays1[i] + " ");
		}
	}

}
