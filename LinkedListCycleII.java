public class LinkedListCycleII {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
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

	public static ListNode detectCycle1(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode p = head, q = head, begin = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				while (begin != p) {
					q = p.next;
					while (p != q) {
						if (q == begin)
							return begin;
						q = q.next;
					}
					begin = begin.next;
				}
				return begin;
			}
		}
		return null;
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode p = head, q = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				while (head != p) {
					head = head.next;
					p = p.next;
				}
				return p;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3, 2, 0, -4, 6, 9, 3 };
		ListNode head = assign(array);
		ListNode p = head.next.next, q = p.next;
		while (q.next != null)
			q = q.next;
		q.next = p;
		p = detectCycle(head);
		if (p == null)
			System.out.println("no cycle");
		else
			System.out.println(p.val);
	}
}
