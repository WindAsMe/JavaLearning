import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : lastRemaining.java
 * Time       : Create on 18-6-14
 * Location   : ../Home/JavaForLeeCode2/lastRemaining.java
 * Function   : LeeCode No.390
 */
public class lastRemaining {

    private static int lastRemainingResult(int n) {
        if (n == 1)
            return 1;
        int[] nums = new int[n / 2];
        for (int i = 0 ; i < n / 2; i ++ ) {
            nums[i] = 2 * (i + 1);
        }
        return getLast(false, nums);
    }

    // If read from left: isLeft = true
    // If read from right: isLeft = false
    private static int getLast(boolean isLeft, int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 1) {
            return nums[0];
        } else {
            int[] temp = new int[nums.length / 2];
            if (isLeft) {
                for (int i = 0 ; i < nums.length / 2 ; i ++ ) {
                    temp[i] = nums[2 * i + 1];
                }
                return getLast(false, temp);
            } else {
                int j = nums.length / 2 - 1;
                for (int i = nums.length - 2 ; i >= 0 ; i -= 2) {
                    temp[j] = nums[i];
                    j --;
                }
                return getLast(true, temp);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(lastRemainingResult(1000000000));
    }
}
