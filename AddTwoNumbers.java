public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		ListNode p1 = p;
		while (p != null && q != null) {
			p.val = p.val + q.val;
			p1 = p;
			while (p1.val >= 10 && p1 != null) {
				p1.val = p1.val - 10;
				if (p1.next != null)
					p1.next.val = p1.next.val + 1;
				else
					p1.next = new ListNode(1);
				p1 = p1.next;
			}
			p1 = p;
			p = p.next;
			q = q.next;
		}
		if (p == null && q != null)
			p1.next = q;
		return l1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		ListNode p = l1;
		ListNode q = l2;
		int[] arry1 = { 9 };
		int[] arry2 = {};
		for (int i = 0; i < arry1.length; i++) {
			p.next = new ListNode(arry1[i]);
			p = p.next;
		}
		for (int i = 0; i < arry2.length; i++) {
			q.next = new ListNode(arry2[i]);
			q = q.next;
		}
		p = l1;
		q = l2;
		while (p != null) {
			System.out.print(p.val);
			p = p.next;
		}
		System.out.println();
		while (q != null) {
			System.out.print(q.val);
			q = q.next;
		}
		System.out.println();
		addTwoNumbers(l1, l2);
		p = l1;
		while (p != null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
}
