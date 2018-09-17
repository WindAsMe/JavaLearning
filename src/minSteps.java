/**
 * Author     : WindAsMe
 * File       : minSteps.java
 * Time       : Create on 18-9-17
 * Location   : ../Home/JavaForLeeCode2/minSteps.java
 * Function   : LeetCode No.650
 */
public class minSteps {

    private static int minStepsResult(int n) {
        if (n < 2)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i)
            dp[i] = i;
        for (int i = 4; i <= n; ++i) {
            for (int j = i / 2; j >= 2; --j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minStepsResult(12));
    }
}
