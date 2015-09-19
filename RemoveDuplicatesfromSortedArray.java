import java.util.Iterator;
import java.util.Hashtable;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	// 第一种：超时
	// public static int removeDuplicates(int[] A) {
	// if ( A.length < 2 )
	// return A.length;
	// int n = 0;
	// n = A.length;
	// Arrays.sort(A);
	// for (int i = 0; i < n-1; i++) {
	// if (A[i] == A[i + 1]) {
	// for (int j = i + 1; j < n-1; j++) {
	// A[j] = A[j + 1];
	//
	// }
	// n--;
	// A[n] = 0;
	// }
	// }
	// return n;
	// }
	// 第二种

	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		for (int i = 0; i < A.length; i++) {
			ht.put(A[i], "tag" + A[i]);
		}
		int[] B = new int[ht.size()];
		int k = 0;

		for (Iterator<Integer> it = ht.keySet().iterator(); it.hasNext();) {
			Integer key = (Integer) it.next();
			B[k] = key;
			k++;
		}
		Arrays.sort(B);
		for (int i = 0; i < B.length; i++)
			A[i] = B[i];
		return ht.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 2 };
		int n = removeDuplicates(A);
		System.out.println(n);

	}

}
