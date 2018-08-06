/**
 * Author     : WindAsMe
 * File       : canPartition.java
 * Time       : Create on 18-8-6
 * Location   : ../Home/JavaForLeeCode2/canPartition.java
 * Function   : LeetCode No.416
 */
public class canPartition {

    private static boolean canPartitionResult(int[] nums) {
        if (nums.length < 2)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums[i], sum - nums[i], i, nums))
                return true;
        }
        return false;
    }

    private static boolean dfs(int left, int right, int index, int[] nums) {
        if (left == right)
            return true;
        if (index < nums.length) {
            for (int i = index + 1; i < nums.length; i++) {
                if (dfs(left + nums[i], right - nums[i], i, nums))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]  nums = {1,2,2,5};
        System.out.println(canPartitionResult(nums));
    }

}
