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
        if (nums.length <= 1)
            return 0;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i ++ ) {
            if (nums[i] != i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7};
        System.out.println(missingNumberResult(nums));
    }
}
