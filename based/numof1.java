package based;

public class numof1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((-8& flag) != 0)
				count++;
			flag = flag << 1;
		}
		System.out.println(count);
	}
}
