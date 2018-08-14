import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : baggage.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/baggage.java
 * Function   : 0/1 bag problem
 */
public class baggage {

    private static int bag(int[] w, int[] v, int C) {
        // The array is [Object's length + 1][Capacity + 1]
        // Every step array[i][j] means:
        // The Capacity is j, and you face the w[i], v[i] Object
        int[][] ans = new int[w.length + 1][C + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= C; j++) {
                // If you're lack of Capacity
                if (j < w[i - 1])
                    ans[i][j] = ans[i - 1][j];
                // If you're spacious
                else
                    // Comparing with the head or carry out the before
                    // You can do this because every step is OPTIMUM
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }

        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
        return ans[w.length][C];
    }

    public static void main(String[] args) {
        int[] v = {2, 5, 3, 10, 4};
        int[] w  = {1, 3, 2, 6, 2};
        System.out.println(bag(w, v, 12));
    }
}
