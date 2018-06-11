import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : missingNumber.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/missingNumber.java
 * Function   : LeeCode No.268
 */
public class missingNumber {

    private static int missingNumberResult(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i ++ ) {
            if (nums[i] != i) {
                return i;
            }
        }
        return 0;
    }
}
