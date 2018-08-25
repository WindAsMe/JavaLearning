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
            while (i > 0) {
                if (seats[i] == 1)
                    break;
                else
                    i--;
            }
            return seats[i] == 1 ? index - i : Integer.MAX_VALUE;
        } else {
            int i = index;
            while (i < seats.length - 1) {
                if (seats[i] == 1)
                    break;
                else
                    i++;
            }
            return seats[i] == 1 ? i - index : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosestResult(seats));
    }
}
