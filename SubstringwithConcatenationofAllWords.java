import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	// Map。clone无效
	// public static List<Integer> findSubstring(String s, String[] words) {
	// List<Integer> list = new LinkedList();
	// HashMap<String, Integer> map = new HashMap<String, Integer>();
	// for (int j = 0; j < words.length; j++)
	// if (map.containsKey(words[j]))
	// map.put(words[j], map.get(words[j]) + 1);
	// else
	// map.put(words[j], 1);
	// for (int i = 0; i <= s.length() - words[0].length() * words.length; i++)
	// {
	// HashMap<String, Integer> mm = (HashMap) map.clone();
	// String ss = s.substring(i, i + words[0].length() * words.length);
	// int j = 0;
	// while (j < words.length) {
	// String sss = (ss.substring(words[0].length() * j,
	// words[0].length() * (j + 1)));
	// if (map.containsKey(sss)) {
	// if (map.get(sss) > 1)
	// map.put(sss, map.get(sss) - 1);
	// else
	// map.remove(sss);
	// j++;
	// } else
	// break;
	// if (j == words.length)
	// list.add(i);
	// }
	// }
	// return list;
	// }

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new LinkedList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int j = 0; j < words.length; j++)
			if (map.containsKey(words[j]))
				map.put(words[j], map.get(words[j]) + 1);
			else
				map.put(words[j], 1);
		for (int i = 0; i <= s.length() - words[0].length() * words.length; i++) {
			String ss = s.substring(i, i + words[0].length() * words.length);
			@SuppressWarnings("unchecked")
			boolean b = find(ss, (Map<String, Integer>) map.clone(), words.length,
					words[0].length());
			if (b)
				list.add(i);
		}
		return list;
	}

	private static boolean find(String ss, Map<String, Integer> map, int wl,
			int w0l) {
		int j = 0;
		while (j < wl) {
			String sss = (ss.substring(w0l * j, w0l * (j + 1)));
			if (map.containsKey(sss)) {
				if (map.get(sss) > 1)
					map.put(sss, map.get(sss) - 1);
				else
					map.remove(sss);
				j++;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> list = findSubstring(s, words);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
