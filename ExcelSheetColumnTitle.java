public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		String s = "";
		while (n != 0) {
			if (n % 26 == 0) {
				s = "Z" + s;
				n = n / 26 - 1;
			} else {
				s = (char) (n % 26 + 64) + s;
				n = n / 26;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(27));
	}

}
