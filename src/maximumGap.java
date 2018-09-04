import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : maximumGap.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/maximumGap.java
 * Function   : LeetCode No.164
 */
public class maximumGap {

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
        int[] nums = {3,6,9,1};
        System.out.println(maximumGapResult(nums));
    }
}
