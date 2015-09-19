import java.util.LinkedList;
import java.util.List;

public class IntegertoRoman {
	public static List<String> remove(List<String> h) {
		if (h.size() < 3)
			return h;
		else {
			int i = 1;
			String a = h.get(0);
			while (i < h.size() && a == h.get(i))
				i++;
			if (i < 4)
				return remove(h.subList(i, h.size()));
			else {
				for (i = 0; i < 4; i++)
					h.remove(a);
				if (a == "I") {
					h.add(0, "I");
					h.add(1, "V");
				}
				if (a == "X") {
					h.add(0, "X");
					h.add(1, "L");
				}
				if (a == "C") {
					h.add(0, "C");
					h.add(1, "D");
				}
				return remove(h.subList(2, h.size()));
			}
		}
	}

	public static List<String> remove2(List<String> h) {
		if (h.size() < 3)
			return h;
		if (h.get(0) == "M" || h.get(0) == "C" || h.get(0) == "X"
				|| h.get(0) == "I")
			return remove2(h.subList(1, h.size()));
		if (h.get(0) == h.get(2) && h.get(0) != h.get(1)) {
			String a = h.get(0);
			h.remove(0);
			h.remove(1);
			if (a == "L")
				h.add(1, "C");
			if (a == "D")
				h.add(1, "M");
			if (a == "V")
				h.add(1, "X");
			return remove2(h.subList(2, h.size()));
		}
		return remove2(h.subList(1, h.size()));
	}

	public static String intToRoman(int num) {
		List<String> h = new LinkedList<String>();
		while (num > 0) {
			while (num >= 1000) {
				h.add("M");
				num = num - 1000;
			}
			if (num >= 500) {
				h.add("D");
				num = num - 500;
			}
			while (num >= 100) {
				h.add("C");
				num = num - 100;
			}
			if (num >= 50) {
				h.add("L");
				num = num - 50;
			}
			while (num >= 10) {
				h.add("X");
				num = num - 10;
			}
			if (num >= 5) {
				h.add("V");
				num = num - 5;
			}
			while (num >= 1) {
				h.add("I");
				num = num - 1;
			}
		}
		remove(h);
		remove2(h);
		String s = (String) h.get(0);
		for (int i = 1; i < h.size(); i++)
			s = s + h.get(i);
		return s;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 49;
		System.out.println(intToRoman(num));

	}

}
