import java.util.Arrays;
import java.util.Comparator;

/**
 * Author     : WindAsMe
 * File       : eraseOverlapIntervals.java
 * Time       : Create on 18-6-20
 * Location   : ../Home/JavaForLeeCode2/eraseOverlapIntervals.java
 * Function   : LeeCode No.435
 */
public class eraseOverlapIntervals {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // 1. Arrays.sort() the Intervals
    // Judgement
    private static int eraseOverlapIntervalsResult(Interval[] intervals) {

        if (intervals.length <= 1) {
            return 0;
        }
        // Sort by end raise
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        for (Interval temp : intervals) {
            System.out.print(temp.start + " " + temp.end);
            System.out.println();
        }

        // Comparing the last end and current begin
        int length = intervals.length;
        int count = 1;
        int last = 0;
        for (int i = 1; i < length; i++) {
            if (intervals[last].end <= intervals[i].start) {
                count ++;
                last = i;
            }
        }
        return length - count;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1,17), new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,15)};
        System.out.println(eraseOverlapIntervalsResult(intervals));
    }

}
