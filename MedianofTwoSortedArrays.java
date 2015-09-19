public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int n1 = 0, n2 = 0, mid = (A.length + B.length) / 2, tag = 0;
		if (B.length == 0) {
			if (A.length % 2 == 0)
				return (double) (A[A.length / 2 - 1] + A[A.length / 2]) / 2;
			else
				return A[A.length / 2];
		} else if (A.length == 0) {
			if (B.length % 2 == 0)
				return (double) (B[B.length / 2 - 1] + B[B.length / 2]) / 2;
			else
				return B[B.length / 2];
		}
		for (int i = 0, j = 0; mid >= 0; mid--) {
			if ((A[i] < B[j] || tag == 2) && tag != 1) {
				n2 = n1;
				n1 = A[i];
				i++;
			} else if ((A[i] >= B[j] || tag == 1) && tag != 2) {
				n2 = n1;
				n1 = B[j];
				j++;
			}
			if (i == A.length) {
				i = A.length - 1;
				tag = 1;
			}
			if (j == B.length) {
				j = B.length - 1;
				tag = 2;
			}
		}
		if ((A.length + B.length) % 2 != 0)
			return n1;
		return (double) (n1 + n2) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int[] B = { 10 };
		System.out.println(findMedianSortedArrays(A, B));
	}

}
