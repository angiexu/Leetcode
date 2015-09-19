public class RemoveNthNodeFromEndofList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// public static ListNode removeNthFromEnd(ListNode head, int n) {
	// ListNode faster = head;
	// ListNode slower = head;
	// while (n > 0 && faster != null) {
	// faster = faster.next;
	// n--;
	// }
	// if (faster == null)
	// return head.next;
	//
	// while (faster.next != null) {
	// faster = faster.next;
	// slower = slower.next;
	// }
	// slower.next = slower.next.next;
	// return head;
	// }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
		int x = 0;
		while (p != null) {
			x++;
			p = p.next;
		}
		if (x <= n)
			head = head.next;
		else {
			int k = x - n - 1;
			p = head;
			while (k > 0) {
				p = p.next;
				k--;
			}
			p.next = p.next.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode p = head;
		for (int i = 2; i < 6; i++) {
			p.next = new ListNode(i);
			p = p.next;
		}
		p = head;
		while (p != null) {
			System.out.print(p.val);
			p = p.next;
		}
		System.out.println();
		removeNthFromEnd(head, 1);
		p = head;
		while (p != null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
}
