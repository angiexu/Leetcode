package based;

public class FullArray {
	public static void print(char[] num) {
		int i = 0;
		while (num[i] == '0' && num[i] != '\0')
			i++;
		while (num[i] != '\0')
			System.out.print(num[i++]);
		System.out.println();
	}

	public static void fullArray(int n) {
		if (n <= 0)
			return;
		char[] num = new char[n + 1];
		num[n] = '\0';
		for (int i = 0; i < 10; i++) {
			num[0] = (char) (i + '0');
			full(num, n, 0);
		}
	}

	public static void full(char[] num, int length, int index) {
		if (index == length - 1) {
			print(num);
			return;
		}
		for (int i = 0; i < 10; i++) {
			num[index + 1] = (char) (i + '0');
			full(num, length, index + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fullArray(3);
	}

}
