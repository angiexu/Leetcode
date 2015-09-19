import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
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

	// public static ListNode[] sublist(ListNode[] lists, int i) {
	// ListNode[] list = new ListNode[lists.length - i];
	// for (int j = 0; j < lists.length - i; j++)
	// list[j] = lists[j + i];
	// return list;
	// }
	// 堆排序
	// public static void heapSort(ListNode[] lists) {
	// buildHeap(lists);// 构建堆
	// int n = lists.length;
	// int i = 0;
	// for (i = n - 1; i >= 1; i--) {
	// swap(lists, 0, i);
	// heapify(lists, 0, i);
	// }
	// }
	// public static void buildHeap(ListNode[] lists) {
	// int n = lists.length;// 数组中元素的个数
	// for (int i = n / 2 - 1; i >= 0; i--)
	// heapify(lists, i, n);
	// }
	// public static void heapify(ListNode[] lists, int idx, int max) {
	// int left = 2 * idx + 1;// 左孩子的下标（如果存在的话）
	// int right = 2 * idx + 2;// 左孩子的下标（如果存在的话）
	// int largest = 0;// 寻找3个节点中最大值节点的下标
	// if (left < max && lists[left].val > lists[idx].val)
	// largest = left;
	// else
	// largest = idx;
	// if (right < max && lists[right].val > lists[largest].val)
	// largest = right;
	// if (largest != idx) {
	// swap(lists, largest, idx);
	// heapify(lists, largest, max);
	// }
	// }
	// public static void swap(ListNode[] lists, int i, int j) {
	// ListNode temp = null;
	// temp = lists[i];
	// lists[i] = lists[j];
	// lists[j] = temp;
	// }
	// public static ListNode mergeKLists(ListNode[] lists) {
	// ListNode head = new ListNode(0), p = head;
	// int i = 0;
	// for (int j = 0; j < lists.length; j++)
	// if (lists[j] == null) {
	// for (int k = i; k < j; k++)
	// if (lists[k] != null) {
	// lists[j] = lists[k];
	// break;
	// }
	// i++;
	// }
	// lists = sublist(lists, i);
	// while (lists.length > 0) {
	// heapSort(lists);
	// p.next = lists[0];
	// p = p.next;
	// lists[0] = lists[0].next;
	// if (lists[0] == null)
	// lists = sublist(lists, 1);
	// }
	// return head.next;
	// }
	// 无重复元素可用map排序
	// public static ListNode mergeKLists(ListNode[] lists) {
	// ListNode head = new ListNode(0), p = head;
	// SortedMap<Integer, ListNode> map = new TreeMap<Integer, ListNode>();
	// for (int i = 0; i < lists.length; i++)
	// if (lists[i] != null)
	// map.put(lists[i].val, lists[i]);
	// while (!map.isEmpty()) {
	// p.next = map.get(map.firstKey());
	// p = p.next;
	// map.remove(map.firstKey());
	// if (p.next != null)
	// map.put(p.next.val, p.next);
	// }
	// return head.next;
	// }
	static class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode o1, ListNode o2) {
			if (o1.val < o2.val)
				return -1;
			else if (o1.val == o2.val)
				return 0;
			else
				return 1;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,
				new ListNodeComparator());
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 0; i < lists.length; i++)
			if (lists[i] != null)
				pq.add(lists[i]);
		while (pq.size() > 0) {
			p.next = pq.poll();
			p = p.next;
			if (p.next != null)
				pq.add(p.next);
		}
		return head.next;
	}

	public static ListNode mergeKLists2(ListNode[] lists) {
		int j = 0;
		ListNode head = null;
		for (int i = 0; i < lists.length; i++)
			if (lists[i] != null) {
				head = lists[i];
				j = i;
				break;
			}
		for (int i = j + 1; i < lists.length; i++)
			if (lists[i] != null)
				head = mergeTwoLists(head, lists[i]);
		return head;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = l1, q = l2;
		if (l1.val < l2.val) {
			l1 = p;
			p = p.next;
		} else {
			l1 = q;
			q = q.next;
		}
		l2 = l1;
		while (p != null && q != null) {
			if (p.val <= q.val) {
				l2.next = p;
				l2 = p;
				p = p.next;
			} else {
				l2.next = q;
				l2 = q;
				q = q.next;
			}
		}
		if (p == null)
			l2.next = q;
		if (p != null)
			l2.next = p;
		return l1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 1, 1, 2 }, { 3, 5, 8 } };
		ListNode[] list = new ListNode[array.length];
		for (int i = 0; i < array.length; i++) {
			list[i] = assign(array[i]);
		}
		for (int i = 0; i < list.length; i++)
			print(list[i]);
		System.out.println();
//		ListNode head = mergeKLists(list);
//		print(head);
		ListNode head2 = mergeKLists2(list);
		print(head2);
	}
}
