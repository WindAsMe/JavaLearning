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
        if (nums.length < 2)
            return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums[i], sum - nums[i], i, nums, nums[i] > sum - nums[i]))
                return true;
        }
        return false;
    }

    private static boolean dfs(int left, int right, int index, int[] nums, boolean bigger) {
        if (left == right)
            return true;
        if (index < nums.length) {
            for (int i = index + 1; i < nums.length; i++) {
                if (bigger != left + nums[i] > right - nums[i])
                    break;
                if (dfs(left + nums[i], right - nums[i], i, nums, left + nums[i] > right - nums[i]))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]  nums = {28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,18,66,62,55,19,2,67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,58,55,73,74,97,49,71,42,26,8,87,99,1,16,79};
        System.out.println(canPartitionResult(nums));
    }

}
