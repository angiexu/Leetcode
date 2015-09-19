public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 358s
	// public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	// if (l1 == null)
	// return l2;
	// if (l2 == null)
	// return l1;
	// ListNode p = null, q = null;
	// if (l1.val < l2.val) {
	// p = l1;
	// q = l2;
	// } else {
	// p = l2;
	// q = l1;
	// l1 = p;
	// }
	// ListNode p1 = p, q1 = q;
	// while (p.next != null && q != null) {
	// q1 = q;
	// q = q.next;
	// while (p.next != null && p.next.val < q1.val) {
	// p1 = p;
	// p = p.next;
	// }
	// q1.next = p.next;
	// p.next = q1;
	// p1 = p;
	// p = q1;
	//
	// }
	// if (q != null)
	// p.next = q;
	// return l1;
	// }
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = l1, q = l2;
		if (l1.val < l2.val) {
			l1 = p;
			p = p.next;
		} else {
			l1 = q;
			q = q.next;
		}
		l2 = l1;
		while (p != null && q != null) {
			if (p.val <= q.val) {
				l2.next = p;
				l2 = p;
				p = p.next;
			} else {
				l2.next = q;
				l2 = q;
				q = q.next;
			}
		}
		if (p == null)
			l2.next = q;
		if (p != null)
			l2.next = p;
		return l1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode p = l1;
		int[] array1 = { };
		int[] array2 = { 3, 5 };
		for (int i = 0; i < array1.length; i++) {
			p.next = new ListNode(array1[i]);
			p = p.next;
		}
		ListNode q = l2;
		for (int i = 0; i < array2.length; i++) {
			q.next = new ListNode(array2[i]);
			q = q.next;
		}
		p = mergeTwoLists(l1, l2);
		while (p != null) {
			System.out.print(p.val + "  ");
			p = p.next;
		}
		System.out.println();
	}
}
