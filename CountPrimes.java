public class CountPrimes {
	public static int countPrimes(int n) {
		int num = 0;
		for (int j = 2; j < n; j++) {
			int tag = 0;
			if ((j != 2 && j % 2 == 0) || (j != 3 && j % 3 == 0)
					|| (j != 5 && j % 5 == 0) || (j != 7 && j % 7 == 0))
				continue;
			for (int i = 11; i < Math.sqrt(j) + 1; i = i + 2)
				if (j % i == 0) {
					tag = 1;
					break;
				}
			if (tag == 0) {
				num++;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10000));
	}

}
