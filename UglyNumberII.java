public class UglyNumberII {
	public static int nthUglyNumber2(int n) {
		int[] arrays = new int[n];
		int i = 0, j = 0, k = 0;
		arrays[0] = 1;
		int next = 1;
		while (next < n) {
			int min = Math.min(arrays[i] * 2, arrays[j] * 3);
			min = Math.min(arrays[k] * 5, min);
			while (next < n && arrays[i] * 2 <= min) {
				if (arrays[i] * 2 == arrays[next - 1]) {
					i++;
					continue;
				}
				arrays[next++] = arrays[i++] * 2;
			}
			while (next < n && arrays[j] * 3 <= min) {
				if (arrays[j] * 3 == arrays[next - 1]) {
					j++;
					continue;
				}
				arrays[next++] = arrays[j++] * 3;
			}
			while (next < n && arrays[k] * 5 <= min) {
				if (arrays[k] * 5 == arrays[next - 1]) {
					k++;
					continue;
				}
				arrays[next++] = arrays[k++] * 5;
			}
		}
		return arrays[n - 1];
	}

	public static int nthUglyNumber(int n) {
		int[] arrays = new int[n];
		int i = 0, j = 0, k = 0;
		arrays[0] = 1;
		int next = 1;
		while (next < n) {
			int min = Math.min(arrays[i] * 2, arrays[j] * 3);
			min = Math.min(arrays[k] * 5, min);
			arrays[next++] = min;
			while (next < n && arrays[i] * 2 <= min)
				i++;
			while (next < n && arrays[j] * 3 <= min)
				j++;
			while (next < n && arrays[k] * 5 <= min)
				k++;
		}
		return arrays[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(10));
	}
}
