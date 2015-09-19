public class ReverseNodesinkGroup {
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
		ListNode head = new ListNode(array[0]), p = head;
		for (int i = 1; i < array.length; i++) {
			p.next = new ListNode(array[i]);
			p = p.next;
		}
		return head;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2)
			return head;
		ListNode p = head;
		for (int i = 0; i < k; i++) {
			if (p != null)
				p = p.next;
			else
				return head;
		}
		p = head.next;
		ListNode q = head;
		for (int i = 0; i < k - 1; i++) {
			q.next = p.next;
			p.next = head;
			head = p;
			p = q.next;
		}
		q.next = reverseKGroup(p, k);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1,2,3};
		ListNode head = assign(array);
		int k = 2;
		print(head);
		head = reverseKGroup(head, k);
		print(head);
	}

}
