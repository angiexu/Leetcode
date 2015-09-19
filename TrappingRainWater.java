public class TrappingRainWater {
	// public static int trap(int[] height) {
	// if (height.length <= 1)
	// return 0;
	// int water = 0;
	// for (int k = 1; k < height.length - 1; k++) {
	// int i = k - 1, j = k + 1;
	// while (i > 0 && height[k] < height[i] && height[i] < height[i - 1])
	// i--;
	// while (j < height.length - 1 && height[k] < height[j]
	// && height[j] < height[j + 1])
	// j++;
	// if (height[k] < height[i] && height[k] < height[j]) {
	// water = water + calculate(height, i, j);
	// k = j;
	// }
	// }
	// return water;
	// }
	//
	// public static int calculate(int[] height, int i, int j) {
	// int water = 0;
	// if (height[i] > height[i + 1] && height[i + 1] > height[j])
	// i++;
	// if (height[j] > height[j - 1] && height[j - 1] > height[i])
	// j--;
	// water = ((height[i] < height[j]) ? height[i] : height[j]) * (j - i - 1);
	// i++;
	// j--;
	// while (i <= j) {
	// water = water - height[i];
	// i++;
	// }
	// return water;
	// }

	public static int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int water = 0;
		int start = 0;
		int end = height.length - 1;
		int A = Math.min(height[start], height[end]);
		// start end 记录最右边和最左边的位置
		// A记录当前的高度，每次移动一位，更新最大的盛水量。
		while (start < end) {
			if (height[start] < height[end]) {
				water += Math.max(A - height[start + 1], 0);
				A = Math.max(A, Math.min(height[start + 1], height[end]));
				++start;
			} else {
				water += Math.max(A - height[end - 1], 0);
				A = Math.max(A, Math.min(height[start], height[end - 1]));
				--end;
			}
		}
		return water;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

}
