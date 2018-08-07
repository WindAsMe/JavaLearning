/**
 * Author     : WindAsMe
 * File       : checkSubarraySum.java
 * Time       : Create on 18-8-7
 * Location   : ../Home/JavaForLeeCode2/checkSubarraySum.java
 * Function   : LeetCode No.523
 */
public class checkSubarraySum {

    private static boolean checkSubarraySumResult(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                sum += nums[i1];
                if (sum % k == 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        System.out.println(checkSubarraySumResult(nums, 6));
    }
}
