public class SwapNodesinPairs {
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

	// 301s
	// public static ListNode swapPairs(ListNode head) {
	// if (head == null || head.next == null)
	// return head;
	// ListNode p = head, k = p;
	// head = p.next;
	// p.next = head.next;
	// head.next = p;
	// k = p;
	// p = p.next;
	// while (p != null) {
	// ListNode q = p.next;
	// if (q != null) {
	// p.next = q.next;
	// q.next = p;
	// k.next = q;
	// k = p;
	// p = p.next;
	// } else
	// break;
	// }
	// return head;
	//}
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;	
		ListNode p = head;
		head = p.next;
		p.next = head.next;
		head.next = p;
		p.next=swapPairs(p.next);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2,3,4,5,6};
		ListNode head = assign(array);
		print(head);
		head = swapPairs(head);
		print(head);
	}

}
