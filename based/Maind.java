package based;

import java.util.Scanner;

public class Maind {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String m = reader.nextLine();
			String n = null;
			if ('a' <= m.charAt(0) && m.charAt(0) <= 'h' && '1' <= m.charAt(1)
					&& m.charAt(1) <= '8') {
				Scanner re = new Scanner(System.in);
				n = re.next();
				if ('a' <= n.charAt(0) && n.charAt(0) <= 'h'
						&& '1' <= n.charAt(1) && n.charAt(1) <= '8') {
					
				}
			}

			System.out.println(m + n);
		}
	}
}