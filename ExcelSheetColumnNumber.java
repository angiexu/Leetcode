public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int n = 0;
		for (int i = 0; i < s.length(); i++)
			n = n * 26 + (int) s.charAt(i) - 64;
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AB"));
	}

}
