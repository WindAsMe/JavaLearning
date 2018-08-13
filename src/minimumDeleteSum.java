import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : minimumDeleteSum.java
 * Time       : Create on 18-8-13
 * Location   : ../Home/JavaForLeeCode2/minimumDeleteSum.java
 * Function   : LeetCode No.712
 */
public class minimumDeleteSum {

    private static int minimumDeleteSumResult(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] ans = new int[c1.length + 1][c2.length + 1];
        for (int i = 1; i <= c1.length; i++)
            ans[i][0] = ans[i - 1][0] + c1[i - 1];
        for (int i = 1; i <= c2.length; i++)
            ans[0][i] = ans[0][i - 1] + c2[i - 1];


        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                int cost = 0;
                if (c1[i - 1] != c2[j - 1])
                    cost = c1[i - 1] + c2[j - 1];
                ans[i][j] = Math.min(ans[i - 1][j] + c1[i - 1], ans[i][j - 1] + c2[j - 1]);
                ans[i][j] = Math.min(ans[i][j], ans[i - 1][j - 1] + cost);
            }
        }

        for (int[] a : ans)
            System.out.println(Arrays.toString(a));

        return ans[c1.length][c2.length];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSumResult("delete", "leet"));
    }
}
