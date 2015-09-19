public class DeleteNodeinaLinkedList {
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

//	public static void deleteNode(ListNode node) {
//		ListNode p = node;
//		while (node.next != null) {
//			node.val = node.next.val;
//			p = node;
//			node = node.next;
//		}
//		p.next = null;
//	}
	public static void deleteNode(ListNode node) {
		node.val=node.next .val;
		node.next=node.next .next ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4 };
		ListNode head = assign(array);
		ListNode node = head;
		int n = 3;
		while (n > 1) {
			node = node.next;
			n--;
		}
		deleteNode(node);
		print(head);
	}

}
