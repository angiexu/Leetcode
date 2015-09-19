import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Anagrams {
	public static List<String> anagrams(String[] strs) {
		List<String> list = new ArrayList<String>();
		if (strs.length <= 1)
			return list;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HashMap<String, Integer> num = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] array;
			array = strs[i].toCharArray();
			Arrays.sort(array);
			if (num.containsKey(String.valueOf(array)))
				num.put(String.valueOf(array),
						num.get(String.valueOf(array)) + 1);
			else
				num.put(String.valueOf(array), 1);
			map.put(i, String.valueOf(array));
		}
		for (Entry<String, Integer> entry : num.entrySet()) {
			if (entry.getValue() > 1)
				for (Entry<Integer, String> entry1 : map.entrySet())
					if (entry.getKey().equals(entry1.getValue()))
						list.add(strs[entry1.getKey()]);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "", "c" };
		List<String> list = anagrams(strs);
		Iterator<String> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
