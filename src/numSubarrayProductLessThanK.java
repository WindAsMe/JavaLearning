/**
 * Author     : WindAsMe
 * File       : numSubarrayProductLessThanK.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/numSubarrayProductLessThanK.java
 * Function   : LeetCode No.713
 */
public class numSubarrayProductLessThanK {

    // Slide window
    private static int numSubarrayProductLessThanKResult1(int[] nums, int k) {
        if ( k <= 1)
            return 0;
        int n = nums.length;
        long p = 1L;
        int i = 0, total = 0;
        for (int j = 0; j < n; j++){
            p *= nums[j];
            while (p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
        }
        return total;
    }

    // Recursion: TL
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
        System.out.println(numSubarrayProductLessThanKResult1(nums, 100));
    }
}
