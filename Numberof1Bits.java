public class Numberof1Bits {
	public static int hammingWeight(int n) {
		int num = 0;
		String s = Integer.toBinaryString(n).toString();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '1')
				num++;
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(11));
	}

}
