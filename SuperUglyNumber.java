public class SuperUglyNumber {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] indexs = new int[primes.length];
		int[] nums = new int[n];//sequence of the first n super ugly numbers given primes
		nums[0] = 1;
		for (int i = 1; i < n; ++i) {
			int min = nums[indexs[0]] * primes[0];
			for (int j = 1; j < primes.length; ++j) {
				int temp = nums[indexs[j]] * primes[j];
				if (min > temp & temp > 0)
					min = temp;
			}
			nums[i] = min;
			for (int j = 0; j < primes.length; ++j) {
				if (nums[indexs[j]] * primes[j] == min)
					++indexs[j];
			}
		}
		return nums[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] primes = { 2, 7, 13, 19 };
		System.out.println(nthSuperUglyNumber(12, primes));
	}
}
