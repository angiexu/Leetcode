package based;

import java.util.Random;

public class Partition {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrays = { 5,4,6,7,8,9,3,2,1};
		int start = 0;
		int end = arrays.length - 1;
		// 随机数{
		int max = end;
		int min = 0;
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		// }
		int index = s;
		s = arrays[index];
		arrays[index] = arrays[end];
		arrays[end] = s;
		int small = start - 1;
		for (index = start; index < end; ++index) {
			if (arrays[index] < arrays[end]) {
				++small;
				if (small != index) {
					s = arrays[index];
					arrays[index] = arrays[small];
					arrays[small] = s;
				}
			}
		}
		++small;
		s = arrays[small];
		arrays[small] = arrays[end];
		arrays[end] = s;
		System.out.println(small);
		for (int i = 0; i < arrays.length; i++)
			System.out.print(arrays[i] + " ");
	}

}
