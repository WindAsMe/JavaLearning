import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : maximumGap.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/maximumGap.java
 * Function   : LeetCode No.164
 */
public class maximumGap {

    // time: O(3n) -> O(n)  space: O(n)
    // Cache Exceeding
    private static int maximumGapResult1(int[] nums) {
        int max = -1;
        for (int i : nums)
            max = max > i ? max : i;
        int[] helper = new int[max + 1];
        for (int i : nums)
            helper[i]++;
        // System.out.println(Arrays.toString(helper));
        int pre = -1;
        int ans = 0;
        for (int i = 0; i < helper.length; i++) {
            if (pre == -1 && helper[i] != 0)
                pre = i;
            else if (helper[i] != 0) {
                ans = ans > i - pre ? ans : i - pre ;
                pre = i;
            }
        }
        return ans;
    }

    // time: O(n * log(n))  space: O(1)
    private static int maximumGapResult(int[] nums) {
        if (nums.length < 1)
            return 0;
        int max = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            max = max > nums[i] - nums[i - 1] ? max : nums[i] - nums[i - 1];
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(maximumGapResult1(nums));
    }
}
