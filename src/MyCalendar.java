import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : MyCalendar.java
 * Time       : Create on 18-8-16
 * Location   : ../Home/JavaForLeeCode2/MyCalendar.java
 * Function   : LeetCode No.729
 */
public class MyCalendar {

        static class Solution {

        private List<int[]> list;

        public Solution() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] i : list) {
                if ((start < i[0] && end > i[0]) || (start >= i[0] && start < i[1]))
                    return false;
            }
            list.add(new int[]{start, end});
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.book(47,50));
        System.out.println(solution.book(33,41));
        System.out.println(solution.book(39,45));
        System.out.println(solution.book(33,42));
        System.out.println(solution.book(25,32));
        System.out.println(solution.book(26,35));
        System.out.println(solution.book(19,25));
        System.out.println(solution.book(3,8));
        System.out.println(solution.book(8,13));
        System.out.println(solution.book(18,27));
    }
}
