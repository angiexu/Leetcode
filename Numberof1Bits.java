public class Numberof1Bits {
	public static int hammingWeight(int n) {
		int num = 0;
		while (n != 0) {
			n = n & (n - 1);
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(11));
	}

}
