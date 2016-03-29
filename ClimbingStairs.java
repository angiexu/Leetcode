public class ClimbingStairs {
	public static int climbStairs1(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public static int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] arrays = new int[n + 1];
		arrays[1] = 1;
		arrays[2] = 2;
		for (int i = 3; i <= n; i++) {
			arrays[i] = arrays[i - 1] + arrays[i - 2];
		}
		return arrays[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(44));
	}

}
