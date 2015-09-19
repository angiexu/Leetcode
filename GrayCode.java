import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			list.add(0);
			return list;
		}
		List<String> l = new ArrayList<String>();
		String str = "0";
		l.add(str);
		str = "1";
		l.add(str);
		for (int i = 1; i < n; i++) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<String> ls = (List<String>) ((ArrayList) l).clone();
			l.clear();
			int size = ls.size();
			String s;
			Iterator<String> it = ls.iterator();
			while (it.hasNext()) {
				s = "0" + it.next();
				l.add(String.valueOf(s));
			}
			it = ls.iterator();
			while (it.hasNext()) {
				s = "1" + it.next();
				l.add(size, String.valueOf(s));
			}
		}
		Iterator<String> it = l.iterator();
		while (it.hasNext())
			list.add(Integer.parseInt(it.next(), 2));
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = grayCode(3);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
