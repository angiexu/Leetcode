import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	static Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval s1, Interval s2) {
			return s1.start - s2.end;
		}
	};

	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 0; i < intervals.size() - 1; i++) {
			Interval a = intervals.get(i), b = intervals.get(i + 1);
			if (a.start <= a.end && a.end < b.start && b.start <= b.end)
				continue;
			else {
				int start = 0, end = 0;
				if (a.start == b.start && a.end < b.end) {
					start = a.start;
					end = b.end;
				} else if (a.end >= b.start) {
					start = a.start;
					end = Math.max(a.end, b.end);
				}
				Interval c = new Interval(start, end);
				intervals.add(i, c);
				intervals.remove(i + 1);
				intervals.remove(i + 1);
				i--;
			}
		}
		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 221, 234, 432, 436, 170, 185, 305, 323, 462, 470, 292,
				306, 366, 369, 13, 25, 278, 290, 355, 359, 232, 237, 304, 316,
				111, 117, 41, 51, 258, 261, 198, 210, 416, 418, 276, 295, 318,
				331, 57, 57, 261, 262, 246, 254, 264, 276, 492, 494, 264, 272,
				138, 146, 365, 368, 220, 229, 289, 290, 259, 267, 384, 401,
				232, 245, 440, 448, 92, 110, 294, 295, 390, 405, 202, 210, 35,
				54, 100, 108, 213, 217, 228, 240, 212, 217, 147, 151, 274, 290,
				45, 58, 336, 338, 343, 351, 287, 302, 429, 440, 393, 396, 232,
				247, 130, 136, 123, 141, 105, 121, 398, 409, 292, 298, 375,
				380, 423, 425, 289, 307, 458, 465, 83, 90, 321, 327, 67, 75,
				61, 77, 339, 345, 71, 74, 293, 295, 209, 218, 220, 227, 345,
				363, 338, 355, 96, 109, 494, 513, 235, 251, 69, 74, 323, 328,
				44, 60, 283, 295, 456, 473, 108, 115, 3, 15, 70, 79, 234, 245,
				418, 424, 298, 313, 276, 292, 252, 256, 201, 220, 243, 251,
				235, 240, 334, 344, 170, 188, 406, 419, 342, 356, 150, 153,
				361, 367, 335, 338, 155, 156, 414, 419, 227, 240, 40, 55, 201,
				205, 79, 94, 243, 257, 43, 61, 191, 200 };
		List<Interval> intervals = new ArrayList<Interval>();
		for (int i = 0; i < array.length; i = i + 2) {
			Interval a = new Interval(array[i], array[i + 1]);
			intervals.add(a);
		}
		merge(intervals);
		Iterator<Interval> it = intervals.iterator();
		while (it.hasNext()) {
			Interval a = it.next();
			System.out.println(a.start + " " + a.end);
		}
	}
}
