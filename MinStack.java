import java.util.Stack;

public class MinStack {
	private static  Stack<Object> stack = new Stack<>();
	private static  Stack<Object> minstack = new Stack<>();

	public static  void push(int x) {
		stack.push(x);
		if (minstack.isEmpty() || (int) minstack.peek() >= x)
			minstack.push(x);
	}

	public  void pop() {
		if (!stack.isEmpty()) {
			int x = (int) stack.pop();
			if (x == (int) minstack.peek())
				minstack.pop();
		}
	}

	public static  int top() {
		return (int) stack.peek();
	}

	public static  int getMin() {
		return (int) minstack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(-1);
		int x = top();
		System.out.println(x);
		x = getMin();
		System.out.println(x);
		;
	}

}
