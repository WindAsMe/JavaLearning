/**
 * Author     : WindAsMe
 * File       : change.java
 * Time       : Create on 18-8-7
 * Location   : ../Home/JavaForLeeCode2/change.java
 * Function   : LeetCode No.518
 */
public class change {

    private static int changeResult(int amount, int[] coins) {
        if (coins.length == 0)
            return 0;
        int[] ans = new int[1];
        for (int i = 0; i < coins.length; i++)
            valid(coins[i], amount, coins, ans, i);
        return ans[0];
    }

    private static void valid(int account, int target, int[] coins, int[] ans, int index) {
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
        System.out.println(changeResult(5, coins));
    }
}
