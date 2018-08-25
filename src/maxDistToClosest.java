import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : maxDistToClosest.java
 * Time       : Create on 18-8-25
 * Location   : ../Home/JavaForLeeCode2/maxDistToClosest.java
 * Function   : LeetCode No.849
 */
public class maxDistToClosest {

    private static int maxDistToClosestResult(int[] seats) {
        int len = seats.length;
        int[] ans = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1)
                ans[i] = -1;
            else
                ans[i] = Math.min(find(seats, i, true), find(seats, i, false));
        }
        System.out.println(Arrays.toString(ans));
        for (int i : ans)
            max = i > max ? i : max;
        return max;
    }

    private static int find(int[] seats, int index, boolean left) {
        if (left) {
            int i = index;
            for (; i >= 0; i--) {
                if (seats[i] == 1)
                    break;
            }
            return i == index ? Integer.MAX_VALUE : index - i;
        } else {
            int i = index;
            for (; i < seats.length; i++) {
                if (seats[i] == 1)
                    break;
            }
            return i == index ? Integer.MAX_VALUE : i - index;
        }
    }

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosestResult(seats));
    }
}
