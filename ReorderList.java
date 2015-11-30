public class ReorderList {
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

	// 超时
	// public static void reorderList(ListNode head) {
	// if (head == null)
	// return;
	// while (head != null) {
	// if (head.next == null || head.next.next == null)
	// return;
	// ListNode p = head;
	// while (p.next.next != null)
	// p = p.next;
	// ListNode q = p.next;
	// p.next = null;
	// q.next = head.next;
	// head.next = q;
	// head = head.next.next;
	// }
	// }

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		int num = 0;
		ListNode p = head;
		while (p != null) {
			num++;
			p = p.next;
		}
		p = head;
		num = num / 2;
		while (num > 0) {
			p = p.next;
			num--;
		}
		ListNode q = p.next, h = q.next;
		p.next = null;
		p = q;
		if (h == null) {
			p.next = head.next;
			head.next = p;
			return;
		}
		while (h.next != null)
			h = h.next;
		while (q != h) {
			q = p.next;
			p.next = h.next;
			h.next = p;
			p = q;
		}
		p = h;
		q = head;
		while (h != null) {
			h = p.next;
			p.next = q.next;
			q.next = p;
			q = p.next;
			p = h;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5 };
		ListNode head = assign(array);
		print(head);
		reorderList(head);
		print(head);
	}
}
