public class LinkedListCycle {
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

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode p = head, q = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
			if (p == q)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2 };
		ListNode head = assign(array);
		System.out.println(hasCycle(head));
	}
}
