import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
//超时
//public class ContainerWithMostWater {
//	public static int maxArea(List<Integer> height) {
//		int lenght = 0, Area = 0;
//		for (int i = 0; i < height.size(); i++)
//			for (int j = i + 1; j < height.size(); j++) {
//				if (height.get(i) > height.get(j))
//					lenght = height.get(j);
//				else
//					lenght = height.get(i);
//				if (lenght * (j - i) > Area)
//					Area = lenght * (j - i);
//			}
//		return Area;
//	}

public class ContainerWithMostWater {
	public static int maxArea(List<Integer> height) {
		int left = 0, right = height.size() - 1, Area = 0;
		while (left < right)
			if (height.get(left) > height.get(right)) {
				Area = Math.max(Area, (right - left) * height.get(right));
				right--;
			} else {
				Area = Math.max(Area, (right - left) * height.get(left));
				left++;
			}
		return Area;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> height = new ArrayList<Integer>();
		int[] array = { 1, 2, 3, 4 };
		for (int i = 0; i < array.length; i++)
			height.add(array[i]);
		Iterator<Integer> it = height.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		System.out.println(maxArea(height));

	}
}
