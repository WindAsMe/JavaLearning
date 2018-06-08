import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : minSubArrayLen.java
 * Time       : Create on 18-6-8
 * Location   : ../Home/JavaForLeeCode2/minSubArrayLen.java
 * Function   : LeeCode No.209
 */
public class minSubArrayLen {

    private static int minSubArrayLenResult(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;


    }

    public static void main(String[] args) {
        int[] num = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLenResult(213, num));
    }
}
