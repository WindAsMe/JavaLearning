/**
 * Author     : WindAsMe
 * File       : numSubarrayProductLessThanK.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/numSubarrayProductLessThanK.java
 * Function   : LeetCode No.713
 */
public class numSubarrayProductLessThanK {

    private static int numSubarrayProductLessThanKResult(int[] nums, int k) {
        int[] count = {0};
        for (int i = 0; i < nums.length; i++)
            dfs(count, k, nums[i], i, nums);
        return count[0];
    }

    private static void dfs(int[] count, int k, int cur, int index, int[] nums) {
        if (cur < k) {
            count[0]++;
            if (index + 1 < nums.length)
                dfs(count, k, cur * nums[index + 1], index + 1, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanKResult(nums, 100));
    }
}
