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
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;
        for (int i = nums.length - 1 ; i >= 0 ; i -- ) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int i = nums.length - 1 ; i >= 0 ; i -- ) {
            System.out.print(sum + " ");
             if (sum + nums[i] >= s) {
                 count ++;
                 return count;
             } else {
                 sum += nums[i];
                 count ++;
             }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLenResult(213, num));
    }
}
