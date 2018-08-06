import java.util.Arrays;
import java.util.stream.IntStream;

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
        if (nums.length < 2)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;

        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums[i], sum - nums[i], i, nums))
                return true;
        }
        return false;
    }

    private static boolean dfs(int left, int right, int index, int[] nums) {
        System.out.println("left: " + left + " right: " + right);
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


    private static boolean canPartitionResult1(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;
        int half = sum / 2;
        return dfs(half, nums.length, nums);
    }

    private static boolean dfs(int w, int s, int[] nums) {
        return w == 0 || w >= 0 && s != 0 && (dfs(w - nums[s - 1], s - 1, nums) || dfs(w, s - 1, nums));
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,5,5,7};
        System.out.println(canPartitionResult1(nums));
    }

}
