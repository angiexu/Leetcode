package based;

public class ReverseList {

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
		if (head == null || head.next == null)
			return head;
		ListNode p = head.next, q = p.next;
		head.next = null;
		while (p != null) {
			q = p.next;
			p.next = head;
			head = p;
			p = q;
		}
		return head;
	}

	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList2(head.next);
		p.next = head;
		head.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5 };
		ListNode head = assign(array);
		reverseList2(head);
		print(head);
	}

}
