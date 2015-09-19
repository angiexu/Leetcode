import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalsTriangle {
//	 public static List<List<Integer>> generate(int numRows) {
//	 List<List<Integer>> list = new ArrayList<List<Integer>>();
//	 if(numRows == 0)
//	 return list;
//		List<Integer> li = new ArrayList<Integer>(), lii = new ArrayList<Integer>();
//	 li.add(1);
//	 lii.add(1);
//	 list.add(lii);
//	 for (int i = 1; i < numRows; i++) {
//	 List<Integer> lis = new ArrayList<Integer>();
//	 lis.addAll(getlist(li));
//	 list.add(lis);
//	 }
//	 return list;
//	 }
//	
//	 public static List<Integer> getlist(List<Integer> list) {
//	 int a = 0, b = 1;
//	 for (int j = 1; j < list.size(); j++) {
//	 a = list.get(j);
//	 list.set(j, list.get(j) + b);
//	 b = a;
//	 }
//	 list.add(1);
//	 return list;
//	 }
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return list;
		List<Integer> li = new ArrayList<Integer>(), lii = new ArrayList<Integer>();
		li.add(1);
		lii.add(1);
		list.add(lii);
		for (int i = 1; i < numRows; i++) {
			List<Integer> lis = new ArrayList<Integer>();
			int a = 0, b = 1;
			for (int j = 1; j < li.size(); j++) {
				a = li.get(j);
				li.set(j, li.get(j) + b);
				b = a;
			}
			li.add(1);
			lis.addAll(li);
			list.add(lis);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = generate(13);
		Iterator<List<Integer>> itt = list.iterator();
		while (itt.hasNext()) {
			List<Integer> li = itt.next();
			Iterator<Integer> it = li.iterator();
			while (it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		}
	}
}
