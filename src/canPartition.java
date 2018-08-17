import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : canPartition.java
 * Time       : Create on 18-8-6
 * Location   : ../Home/JavaForLeeCode2/canPartition.java
 * Function   : LeetCode No.416
 */
public class canPartition {

    private static boolean canPartitionResult(int[] nums) {
        // Length < 2 || sum is minus:
        // return false
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (nums.length < 2 || sum % 2 == 1)
            return false;
        Arrays.sort(nums);
        System.out.println(sum);
        if (sum - nums[nums.length - 1] < nums[nums.length - 1])
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums[i], sum / 2, i, nums))
                return true;
        }
        return false;
    }

    private static boolean dfs(int sub, int target, int index, int[] nums) {
        if (sub == target)
            return true;
        else if (sub > target)
            return false;
        else {
            if (index < nums.length) {
                for (int i = index + 1; i < nums.length; i++) {
                    if (dfs(sub + nums[i], target, i, nums))
                        return true;
                }
            }
            return false;
        }
    }


    private static boolean canPartitionResult1(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (nums.length < 2 || sum % 2 == 1)
            return false;
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; --i)
                dp[i] = dp[i] || dp[i - num];
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,97,95};
        System.out.println(canPartitionResult1(nums));
    }

}
