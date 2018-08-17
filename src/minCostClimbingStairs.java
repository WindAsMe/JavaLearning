/**
 * Author     : WindAsMe
 * File       : minCostClimbingStairs.java
 * Time       : Create on 18-8-17
 * Location   : ../Home/JavaForLeeCode2/minCostClimbingStairs.java
 * Function   : LeetCode No.746
 */
public class minCostClimbingStairs {

    private static int minCostClimbingStairsResult(int[] cost) {
        if (cost.length < 1)
            return 0;
        int[] ans = new int[cost.length];
        ans[0] = cost[0];
        ans[1] = cost[1];
        for (int i = 2; i < cost.length; i++)
            ans[i] = Math.min(ans[i - 1], ans[i - 2]) + cost[i];
        return ans[ans.length - 1];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairsResult(cost));
    }
}
