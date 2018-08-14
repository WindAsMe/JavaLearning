/**
 * Author     : WindAsMe
 * File       : baggage.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/baggage.java
 * Function   : 0/1 bag problem
 */
public class baggage {

    private static int bag(int[] w, int[] v, int C) {
        int[][] ans = new int[w.length + 1][C + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= C; j++) {
                if (j < w[i])
                    ans[i][j] = ans[i - 1][j];
                else
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - w[i]] + v[i]);
            }
        }
        return ans[w.length + 1][C + 1];
    }

    public static void main(String[] args) {
        int[] v = {2, 5, 3, 10, 4};
        int[] w  = {1, 3, 2, 6, 2};
        System.out.println(bag(w, v, 12));
    }
}
