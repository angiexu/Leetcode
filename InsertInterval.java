import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {
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

	public static List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {
		if (newInterval == null)
			return intervals;
		if (intervals.size() < 1) {
			intervals.add(newInterval);
			return intervals;
		}
		if (intervals.get(0).start >= newInterval.start) {
			intervals.add(0, newInterval);
		} else if (intervals.get(intervals.size() - 1).start < newInterval.start) {
			intervals.add(newInterval);
		} else
			for (int i = 0; i < intervals.size(); i++) {
				if (intervals.get(i).start >= newInterval.start) {
					intervals.add(i, newInterval);
					break;
				}
			}
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
		int[] array = { 1, 5 };
		List<Interval> intervals = new ArrayList<Interval>();
		for (int i = 0; i < array.length; i = i + 2) {
			Interval a = new Interval(array[i], array[i + 1]);
			intervals.add(a);
		}
		Interval newInterval = new Interval(2, 7);
		insert(intervals, newInterval);
		Iterator<Interval> it = intervals.iterator();
		while (it.hasNext()) {
			Interval a = it.next();
			System.out.println(a.start + " " + a.end);
		}
	}
}
