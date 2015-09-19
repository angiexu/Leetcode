public class ReverseBits {
	public static int reverseBits(int n) {
		char[] s = new char[32];
		String k = Integer.toBinaryString(n);
		for (int i = 0; i < k.length(); i++)
			s[i + 32 - k.length()] = k.charAt(i);
		int i = 0, j = s.length - 1;
		while (i < j) {
			char a = s[i];
			s[i] = s[j];
			s[j] = a;
			i++;
			j--;
		}
		i = 0;
		n = 0;
		while (i < 32) {
			int tag = 0;
			if (s[i] == '1')
				tag = 1;
			n = n * 2 + tag;
			i++;
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(43261596));
	}
}
