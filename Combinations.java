import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations {
	@SuppressWarnings("unchecked")
	// 四位数以上组合时出错
	// public static List<List<Integer>> combine(int n, int k) {
	// List<List<Integer>> list = new ArrayList<List<Integer>>();
	// for (int j = 1; j < n - k + 2; j++) {// 开始位置
	// List<Integer> l = new ArrayList<Integer>();
	// List<List<Integer>> li = new ArrayList<List<Integer>>();
	// int i = j;
	// for (; l.size() < k; i++) {
	// l.add(i);
	// }
	// li.add(l);
	// for (; i <= n; i++) {
	// List<Integer> ls = (ArrayList<Integer>) (((ArrayList<Integer>) l)
	// .clone());
	// ls.set(k - 1, i);
	// li.add(ls);
	// }
	// list.addAll(li);
	// if(k==1)
	// break;
	// while (li.size() > 1) {
	// li.remove(0);
	// for (int t = k - 2; t > 0; t--) {
	// Iterator<List<Integer>> it = li.iterator();
	// int m = 0;
	// while (it.hasNext()) {
	// List<Integer> ls = it.next();
	// List<Integer> lss = (ArrayList<Integer>) (((ArrayList<Integer>) ls)
	// .clone());
	// if (lss.get(t) < lss.get(t + 1) - 1) {
	// lss.set(t, lss.get(t) + 1);
	// list.add(lss);
	// li.set(m, lss);
	// m++;
	// }
	// }
	// }
	// }
	// }
	// return list;
	// }
	public static List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int j = 1; j < n - k + 2; j++) {// 开始位置
			List<Integer> l = new ArrayList<Integer>();
			List<List<Integer>> li = new ArrayList<List<Integer>>();
			int i = j;
			for (; l.size() < k; i++) {
				l.add(i);
			}
			li.add(l);
			for (; i <= n; i++) {
				List<Integer> ls = (ArrayList<Integer>) (((ArrayList<Integer>) l)
						.clone());
				ls.set(k - 1, i);
				li.add(ls);
			}
			list.addAll(li);
			if (k == 1)
				break;
			li.remove(0);
			minit(list, li, n, k);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> minit(List<List<Integer>> list,
			List<List<Integer>> li, int n, int k) {
		if (li.size() < 1)
			return list;
		else {
			for (int t = k - 2; t > 0; t--) {
				Iterator<List<Integer>> it = li.iterator();
				int m = 0;
				while (it.hasNext()) {
					List<Integer> ls = it.next();
					List<Integer> lss = (ArrayList<Integer>) (((ArrayList<Integer>) ls)
							.clone());
					if (lss.get(t) < lss.get(t + 1) - 1) {
						lss.set(t, lss.get(t) + 1);
						if (!list.contains(lss))
							list.add(lss);
						li.set(m, lss);
						m++;
					}
				}
				List<List<Integer>> lis = (ArrayList<List<Integer>>) (((ArrayList<List<Integer>>) li)
						.clone());
				lis.remove(0);
				minit(list, lis, n, k);

			}
		}
		return list;
	}

	// 时间太长
	// public static List<List<Integer>> combine(int n, int k) {
	// List<List<Integer>> list = new ArrayList<List<Integer>>();
	// int j = 1;
	// List<Integer> l = new ArrayList<Integer>();
	// List<List<Integer>> li = new ArrayList<List<Integer>>();
	// int i = j;
	// for (; l.size() < k; i++) {
	// l.add(i);
	// }
	// li.add(l);
	// for (; i <= n; i++) {
	// List<Integer> ls = (ArrayList<Integer>) (((ArrayList<Integer>) l)
	// .clone());
	// ls.set(k - 1, i);
	// li.add(ls);
	// }
	// list.addAll(li);
	// li.remove(0);
	// minit(list, li, n, k);
	// return list;
	// }

	public static List<List<Integer>> combine3(int n, int k) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		lists.add(list);
		for (int i = 1; i <= k; i++)
			lists = permute(lists, n, k, i);
		return lists;
	}

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> permute(List<List<Integer>> lists, int n,
			int k, int m) {
		List<List<Integer>> list = (ArrayList<List<Integer>>) (((ArrayList<List<Integer>>) lists)
				.clone());
		lists.clear();
		for (int i = m; i <= n; i++) {// 数
			Iterator<List<Integer>> it = list.iterator();
			while (it.hasNext()) {
				List<Integer> l = new ArrayList<Integer>(it.next());
				if (l.size() < 1 || (i > l.get(m - 2) && !l.contains(i))) {
					l.add(i);
					lists.add(l);
				}
			}
		}
		return lists;
	}

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for (int i = 1; i <= n - k + 1; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			lists.add(list);
		}
		for (int i = 2; i <= k; i++) {
			List<List<Integer>> li = (ArrayList<List<Integer>>) (((ArrayList<List<Integer>>) lists)
					.clone());
			lists.clear();
			for (int j = i; j <= n; j++) {// 数
				Iterator<List<Integer>> it = li.iterator();
				while (it.hasNext()) {
					List<Integer> l = new ArrayList<Integer>(it.next());
					if (j > l.get(i - 2) && !l.contains(j)) {
						l.add(j);
						lists.add(l);
					}
				}
			}
		}
		return lists;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = combine(6, 4);
		Iterator<List<Integer>> it = list.iterator();
		System.out.println(list.size());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
