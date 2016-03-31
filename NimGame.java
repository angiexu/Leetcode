public class NimGame {
	public static boolean canWinNim(int n) {
		if (n % 4 != 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(44));
	}

}
