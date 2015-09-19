public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		if (A.length == 0)
			return A.length;
		int n = A.length, flag = A.length;
		int[] b = new int[1];
		for (int i = 0; i < flag;) {
			if (A[i] == elem) {
				A[i] = A[n - 1];
				A[n - 1] = b[0];
				flag = n - 1;
				n--;
			} else
				i++;
		}
		if (n == 0)
			A[0] = b[0];
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 4, 4, 0, 1, 0, 2 };
		int n = removeElement(A, 0);
		System.out.println(n);

	}

}
