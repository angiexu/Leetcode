public class RemoveLinkedListElements {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val)
			head = head.next;
		ListNode p = head, q = p;
		while (p != null) {
			if (p.val == val) {
				q.next = p.next;
				p = q.next;
			} else {
				q = p;
				p = p.next;
			}
		}
		return head;
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
		int array[] = { 1 };
		ListNode head = assign(array);
		print(head);
		int val = 1;
		head = removeElements(head, val);
		print(head);
	}

}
