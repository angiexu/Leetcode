public class RotateList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
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

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode p = head, q = head;
		if (head == null || k == 0)
			return head;
		int n = 1;
		while (p.next != null) {
			n++;
			p = p.next;
		}
		while (k > n)
			k = k - n;
		int s = n - k - 1;
		while (s != 0 && q.next != null) {
			s--;
			q = q.next;
		}
		p.next = head;
		head = q.next;
		q.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1 };
		ListNode head = assign(array);
		head = rotateRight(head, 1);
		print(head);
	}

}
