/**
 * Author     : WindAsMe
 * File       : wiggleMaxLength.java
 * Time       : Create on 18-8-16
 * Location   : ../Home/JavaForLeeCode2/wiggleMaxLength.java
 * Function   : LeetCode No.376
 */
public class wiggleMaxLength {

    private static int wiggleMaxLengthResult(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int[] ans = new int[nums.length];
        boolean[] flag = new boolean[nums.length];
        ans[0] = 1;
        ans[1] = 2;
        flag[0] = true;
        flag[1] = nums[1] - nums[0] > 0;
        for (int i = 2; i < nums.length; i++) {
            flag[i] = nums[i] - nums[i - 1] > 0;
            if (flag[i] == flag[i - 1])
                ans[i] = ans[i - 1];
            else
                ans[i] = ans[i - 1] + 1;
        }
        return ans[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7,2 ,5};
        System.out.println(wiggleMaxLengthResult(nums));
    }
}
