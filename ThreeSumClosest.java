import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target) {
		if (num.length < 3)
			return 0;
		int closest = num[0] + num[1] + num[2], sum = 0;
		Arrays.sort(num);
		for (int n = 0; n < num.length; n++) {
			if (n > 0 && num[n] == num[n - 1])
				continue;
			int i = n + 1, j = num.length - 1;
			while (i < j) {
				sum = num[n] + num[i] + num[j];
				if (sum > target) {
					if (Math.abs(closest - target) > Math.abs(sum - target))
						closest = sum;
					j--;
					while (num[j] == num[j + 1] && j > i)
						j--;
				} else if (sum < target) {
					if (Math.abs(closest - target) > Math.abs(sum - target))
						closest = sum;
					i++;
					while (num[i] == num[i - 1] && i < j)
						i++;
				} else
					return sum;
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(threeSumClosest(num, target));
	}

}
