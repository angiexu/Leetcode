public class ReverseLinkedListII {
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

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode start = head, end = head, s = start, e = end.next;
		if (m != 1)
			while (m > 1) {
				s = start;
				start = start.next;
				m--;
			}
		while (n > 1) {
			end = e;
			e = e.next;
			n--;
		}
		if (start != head)
			s.next = end;
		else
			head = end;
		ListNode p = start, q = p.next, t = end;
		if (e != null)
			start.next = e;
		while (p != end && p != null) {
			p.next = null;
			p.next = t.next;
			t.next = p;
			p = q;
			q = q.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5, 6 };
		ListNode head = assign(array);
		head = reverseBetween(head, 3, 6);
		print(head);
	}

}
