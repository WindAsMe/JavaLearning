/**
 * Author     : WindAsMe
 * File       : pivotIndex.java
 * Time       : Create on 18-8-15
 * Location   : ../Home/JavaForLeeCode2/pivotIndex.java
 * Function   : LeetCode No.724
 */
public class pivotIndex {

    private static int pivotIndexResult(int[] nums) {
        int sum = 0;
        int left = 0;
        for (int num : nums)
            sum += num;
        if (sum - nums[0] == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            if (left * 2 == sum - nums[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,0,1,1};
        System.out.println(pivotIndexResult(nums));
    }
}
