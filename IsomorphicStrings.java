import java.util.HashMap;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		boolean bo = true;
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(t.charAt(i) + "0")) {
				if (map.containsValue(s.charAt(i) + "0"))
					return false;
				map.put(t.charAt(i) + "0", s.charAt(i) + "0");
			} else {
				if (!map.get(t.charAt(i) + "0").equals(s.charAt(i) + "0"))
					return false;
			}
		}
		return bo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "b", t = "b";
		System.out.println(isIsomorphic(s, t));
	}

}
