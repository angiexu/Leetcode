import java.util.Hashtable;

public class TwoSum {
	// 第一种
	// public static int[] twoSum(int[] numbers, int target) {
	// int []index ={0,0};
	// int mid = target/2;
	// int m = 0, result = 0;
	// for (int s = 0 ; s < numbers.length ; s++)
	// { if (numbers[s] >= mid)
	// { m = s;
	// break;
	// }
	//
	// }
	// for (int i = m ; i >= 0 && result == 0 ; i--)
	// {
	// for (int j = m+1 ; j < numbers.length ; j++)
	// {
	// if (numbers[i] + numbers[j] == target)
	// { index[0] = i+1 ;
	// index[1] = j+1 ;
	// result = 1;
	// break;
	// }
	// else if (numbers[i] + numbers[j] > target)
	// break;
	//
	// }
	//
	// }
	// return index;
	// }

	// 第二种
	// public static void quickSort(int[][] numbers, int start, int end) {
	// if (start < end) {
	// int base = numbers[start][0]; // 选定的基准值（第一个数值作为基准值）
	// int temp, tem; // 记录临时中间值
	// int i = start, j = end;
	// do {
	// while ((numbers[i][0] < base) && (i < end))
	// i++;
	// while ((numbers[j][0] > base) && (j > start))
	// j--;
	// if (i <= j) {
	// temp = numbers[i][0];
	// tem = numbers[i][1];
	// numbers[i][0] = numbers[j][0];
	// numbers[i][1] = numbers[j][1];
	// numbers[j][0] = temp;
	// numbers[j][1] = tem;
	// i++;
	// j--;
	// }
	// } while (i <= j);
	// if (start < j)
	// quickSort(numbers, start, j);
	// if (end > i)
	// quickSort(numbers, i, end);
	// }
	// }
	//
	// public static int[] twoSum(int[] numbers, int target) {
	// int[][] array = new int[numbers.length][2];
	// for (int k = 0; k < numbers.length; k++) {
	// array[k][1] = k;
	// array[k][0] = numbers[k];
	// }
	// if (numbers.length < 5000)
	// quickSort(array, 0, numbers.length - 1);
	//
	// int[] index = { 0, 0 };
	// int mid = target / 2;
	// int m = 0, result = 0, mt = 0;
	// for (int s = 0; s < numbers.length; s++) {
	// if (array[s][0] > mid) {
	// m = s;
	// mt = m;
	// break;
	// } else if (mid == array[s][0]) {
	// m = s;
	// mt = m + 1;
	// break;
	// }
	//
	// }
	//
	// for (int i = m; i >= 0 && result == 0; i--) {
	// for (int j = mt; j < numbers.length; j++) {
	// if (array[i][0] + array[j][0] == target) {
	// index[0] = array[i][1] + 1;
	// index[1] = array[j][1] + 1;
	// result = 1;
	// break;
	// } else if (array[i][0] + array[j][0] < target)
	// mt = j;
	// else if (array[i][0] + array[j][0] > target)
	//
	// break;
	//
	// }
	//
	// }
	// if (index[0] > index[1]) {
	// int s = index[1];
	// index[1] = index[0];
	// index[0] = s;
	//
	// }
	// return index;
	// }

	// 第三种
	// public static void quickSort(int[] numbers, int start, int end) {
	// if (start < end) {
	// int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
	// int temp; // 记录临时中间值
	// int i = start, j = end;
	// do {
	// while ((numbers[i] < base) && (i < end))
	// i++;
	// while ((numbers[j] > base) && (j > start))
	// j--;
	// if (i <= j) {
	// temp = numbers[i];
	// numbers[i] = numbers[j];
	// numbers[j] = temp;
	// i++;
	// j--;
	// }
	// } while (i <= j);
	// if (start < j)
	// quickSort(numbers, start, j);
	// if (end > i)
	// quickSort(numbers, i, end);
	// }
	// }
	//
	// public static int[] twoSum(int[] numbers, int target) {
	// int[] array = new int[numbers.length];
	// for (int k = 0; k < numbers.length; k++) {
	// array[k] = numbers[k];
	// }
	//
	// quickSort(array, 0, numbers.length - 1);
	//
	// int[] index = { 0, 0 };
	// int mid = target / 2;
	// int m = 0, result = 0, mt = 0;
	// for (int s = 0; s < numbers.length; s++) {
	// if (array[s] > mid) {
	// m = s;
	// mt = m;
	// break;
	// } else if (mid == array[s]) {
	// m = s;
	// mt = m + 1;
	// break;
	// }
	// }
	// int target1 = 0, target2 = 0;
	// for (int i = m; i >= 0 && result == 0; i--) {
	// for (int j = mt; j < numbers.length; j++) {
	// if (array[i] + array[j] == target) {
	// result = 1;
	// target1 = array[i];
	// target2 = array[j];
	// break;
	// } else if (array[i] + array[j] < target) {
	// mt = j;
	// } else if (array[i] + array[j] > target)
	// break;
	// }
	// }
	// int flag = 0;
	// for (int i = 0; i < numbers.length; i++) {
	// if (numbers[i] == target1 || numbers[i] == target2)
	// if (flag == 0) {
	// index[0] = i + 1;
	// flag = 1;
	// } else
	// index[1] = i + 1;
	// }
	// return index;
	// }

	// 第四种
	public static int[] twoSum(int[] numbers, int target) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int[] result = { 0, 0 };
		for (int i = 0; i < numbers.length; i++) {
			ht.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int gap = target - numbers[i];
			if (ht.get(gap) != null && ht.get(gap) > i) {
				result[0] = i + 1;
				result[1] = ht.get(gap) + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 4, 3, 2, 8 };
		int target = 6;
		int[] temp = twoSum(numbers, target);
		for (int i = 0; i < 2; i++)
			System.out.println(temp[i]);

	}

}
