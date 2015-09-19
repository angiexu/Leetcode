public class IntersectionofTwoLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode assign(int[] array) {
		if (array.length == 0)
			return null;
		ListNode head = new ListNode(array[0]), p = head;
		for (int i = 1; i < array.length; i++) {
			p.next = new ListNode(array[i]);
			p = p.next;
		}
		return head;
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p = headA, q = headB, headC = null, t = headC;
		while (p != null && q != null)
			if (p.val < q.val)
				p = p.next;
			else if (p.val > q.val) {
				q = q.next;
			} else {
				headC = q;
				q = q.next;
				p = p.next;
				break;
			}
		if (headC == null)
			return headC;
		t = headC;
		while (p != null && q != null) {
			if (p.val < q.val) {
				t.next = p;
				t = p;
				p = p.next;
			} else if (p.val > q.val) {
				t.next = q;
				t = q;
				q = q.next;
			} else
				q = q.next;
		}
		if (p == null)
			t.next = q;
		if (p != null)
			t.next = p;
		return headC;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 6, 7, 8, 9, 10, 11, 12, 13 }, { 1, 2, 3, 4, 5, } };
		ListNode[] list = new ListNode[array.length];
		for (int i = 0; i < array.length; i++) {
			list[i] = assign(array[i]);
		}
		for (int i = 0; i < list.length; i++)
			print(list[i]);
		System.out.println();
		ListNode head2 = getIntersectionNode(list[0], list[1]);
		print(head2);
	}

}
