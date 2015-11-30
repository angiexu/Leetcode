import java.util.ArrayList;
import java.util.List;

public class BullsandCows {
	public static String getHint(String secret, String guess) {
		String result = "";
		int a = 0, b = 0;
		List<String> la = new ArrayList<String>(), lb = new ArrayList<String>();

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) != guess.charAt(i)) {
				la.add(String.valueOf(secret.charAt(i)));
				lb.add(String.valueOf(guess.charAt(i)));
			} else
				a++;
		}

		result = result + String.valueOf(a) + "A";

		for (int i = 0; i < lb.size(); i++)
			if (la.contains(lb.get(i))) {
				la.remove(lb.get(i));
				b++;
			}
		result = result + String.valueOf(b) + "B";
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("1807", "7810"));
	}
}
