public class ReverseLinkedList {
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

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode p = head, q = head;
		while (p.next != null)
			p = p.next;
		while (p != q) {
			head = head.next;
			q.next = p.next;
			p.next = q;
			q = head;
		}
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5 };
		ListNode head = assign(array);
		head = reverseList(head);
		print(head);
	}

}
