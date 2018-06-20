import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author     : WindAsMe
 * File       : findRightInterval.java
 * Time       : Create on 18-6-20
 * Location   : ../Home/JavaForLeeCode2/findRightInterval.java
 * Function   : LeeCode No.436
 */
public class findRightInterval {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private static int[] findRightIntervalResult(Interval[] intervals) {
        int[] result = new int[intervals.length];

        java.util.NavigableMap<Integer, Integer> map = new TreeMap<>();
        // Map.put(start, index)
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1,17), new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,15)};
        System.out.println(Arrays.toString(findRightIntervalResult(intervals)));
    }
}
