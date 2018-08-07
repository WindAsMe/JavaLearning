import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : change.java
 * Time       : Create on 18-8-7
 * Location   : ../Home/JavaForLeeCode2/change.java
 * Function   : LeetCode No.518
 */
public class change {

    private static int changeResult2(int amount, int[] coins) {
        int[] a = new int[amount + 1];
        a[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++)
                a[i] += a[i - coin];
            System.out.println(Arrays.toString(a));
        }
        return a[amount];
    }

    // DP problem
    private static int changeResult1(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    // Brutal proceeding: TL
    private static int changeResult(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;
        int[] ans = new int[1];
        for (int i = 0; i < coins.length; i++)
            valid(coins[i], amount, coins, ans, i);
        return ans[0];
    }

    // Here index is important
    // If no index, the Algorithm will add the duplications
    private static void valid(int account, int target, int[] coins, int[] ans, int index) {
        System.out.println(account);
        if (account == target) {
            ans[0]++;
            return;
        }
        if (account > target)
            return;
        for (int i = index; i < coins.length; i++)
            valid(account + coins[i], target, coins, ans, i);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(changeResult2(5, coins));
    }
}
