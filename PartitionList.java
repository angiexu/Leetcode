public class PartitionList {
	// public static ListNode partition(ListNode head, int x) {
	// ListNode p = null, q = head, t = head, tag = head, tail = tag, h = new
	// ListNode(
	// 0);
	// if (tag.val == x) {
	// q = tag.next;
	// } else {
	// tag = t.next;
	// while (tag.val != x) {
	// t = tag;
	// tag = t.next;
	// }
	// t.next = tag.next;
	// }
	// tag.next = null;
	// h.next = head;
	// head = tag;
	// tail = tag;
	// head.next = null;
	// tail.next = null;
	// while (q != null) {
	// p = q.next;
	// if (q.val < x) {
	// q.next = tag;
	// head.next = q;
	// head = q;
	// }
	// if (q.val >= x) {
	// tail.next = q;
	// tail = tail.next;
	// }
	// q = p;
	// }
	// head = h.next;
	// tail.next = null;
	// return head;
	// }

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

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode p = head, q = head, tag = head;
		if (head.val < x) {
			while (tag != null && tag.next != null && tag.next.val < x) {
				q = tag;
				tag = tag.next;
			}
		} else {
			while (p != null && p.next != null && p.next.val >= x)
				p = p.next;
			if (p == null)
				return head;
			tag = p.next;
			while (tag != null && tag.next != null && tag.next.val < x)
				tag = tag.next;
			if (tag == null)
				return head;
			q = p.next;
			p.next = tag.next;
			tag.next = head;
			head = q;
		}
		q = tag;
		p = q.next;
		while (q.next != null) {
			p = q.next;
			if (p.val < x) {
				q.next = p.next;
				p.next = tag.next;
				tag.next = p;
				tag = tag.next;
				p = q;
			} else
				q = q.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 4 };
		ListNode head = assign(array);
		print(head);
		head = partition(head, 3);
		print(head);
	}

}
