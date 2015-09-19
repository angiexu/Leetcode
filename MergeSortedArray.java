import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n) {
		for (int i = 0; i < n; i++)
			A[i + m] = B[i];
		Arrays.sort(A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4, n = 5;
		int[] A = new int[m + n];
		int[] B = new int[n];
		merge(A, m, B, n);
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i]);
	}

}
