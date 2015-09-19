import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		if (path.length() < 2)
			return path;
		Stack<String> k = new Stack<String>();
		for (int i = 1; i < path.length(); i++) {
			String s = "";
			while (i < path.length() && path.charAt(i) != '/') {
				s = s + path.charAt(i);
				i++;
			}
			if (!s.equals(".") && !s.equals("") && !s.equals(".."))
				k.push(s);
			else if (s.equals("..") && !k.empty())
				k.pop();
		}
		String p = "";
		if (k.empty())
			return "/";
		while (!k.empty())
			p = "/" + k.pop() + p;
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/home//foo/";
		System.out.println(simplifyPath(path));
	}
}
