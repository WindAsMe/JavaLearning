/**
 * Author     : WindAsMe
 * File       : containsNearbyDuplicate.java
 * Time       : Create on 18-9-5
 * Location   : ../Home/JavaForLeeCode2/containsNearbyDuplicate.java
 * Function   : LeetCode No.219
 */
public class containsNearbyDuplicate {

    private static boolean containsNearbyDuplicateResult(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int left = -1;
            int right = -1;
            int max;
            int num = nums[i];
            for (int j = 0; j < i; i++) {
                if (nums[j] == num) {
                    left = i - j;
                    break;
                }
            }
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] == num) {
                    right = j - i;
                    break;
                }
            }
            max = Math.max(left, right);
            if (max > 0 && max <= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyDuplicateResult(nums, 3));
    }
}
