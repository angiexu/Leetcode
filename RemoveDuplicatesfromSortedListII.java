public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode p = head, q = head;
		while (head != null && head.next != null && head.val == head.next.val) {
			while (p != null && p.val == head.val)
				p = p.next;
			head = p;
		}
		while (p != null && p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				q = p.next;
				while (q != null && p.next.val == q.val)
					q = q.next;
				p.next = q;
			} else
				p = p.next;
		}
		return head;
	}

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3 };
		ListNode head = assign(array);
		head = deleteDuplicates(head);
		print(head);
	}
}
