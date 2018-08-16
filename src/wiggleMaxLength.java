import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : wiggleMaxLength.java
 * Time       : Create on 18-8-16
 * Location   : ../Home/JavaForLeeCode2/wiggleMaxLength.java
 * Function   : LeetCode No.376
 */
public class wiggleMaxLength {

    // Greedy Algorithm
    private static int wiggleMaxLengthResult(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        int len = nums.length;
        int ans = len;
        int flag = 0;
        for(int i = 1; i < len; i++) {
            if(nums[i] - nums[i - 1] == 0)
                ans--;
            else if(nums[i]-nums[i-1]>0) {
                if (flag == 1)
                    ans--;
                else
                    flag = 1;
            }
            else if(nums[i]-nums[i-1]<0) {
                if (flag == -1)
                    ans--;
                else
                    flag = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(wiggleMaxLengthResult(nums));
    }
}
