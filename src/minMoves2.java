import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : minMoves2.java
 * Time       : Create on 18-6-16
 * Location   : ../Home/JavaForLeeCode2/minMoves2.java
 * Function   : LeeCode No.462
 */
public class minMoves2 {

    // Find the middle
    private static int minMoves2Result(int[] nums) {
        int n = nums.length;
        if( n <= 1 ){
            return 0;
        }
        else {
            // Find the middle number
            Arrays.sort(nums);
            int mean = nums[n / 2];
            int i;
            // Movement step
            int res = 0;
            for( i = 0 ; i < n ; i ++ ){
                res += Math.abs(nums[i]-mean);
            }
            return res;
        }
    }

    // It's not true to find the average
    // The number needed is middle
//    private static int minMoves2Result(int[] nums) {
//        double average =  sum(nums) / nums.length;
//        int count = 0;
//
//        System.out.println("average" + average + "  " + (int) (average + 1));
//
//        if (average - (int) average >= 0.5) {
//            System.out.println("here");
//            for (int num : nums) {
//                count += Math.abs((int) (average + 1) - num);
//            }
//            return count;
//        } else {
//            System.out.println("here1");
//            for (int num : nums) {
//                count += Math.abs((int) average - num);
//            }
//            return count;
//        }
//    }
//
//    private static double sum(int[] nums) {
//        long sum = 0;
//        for (int a : nums) {
//            sum += a;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7,8,9,6,5,3,6,6,7,66,2};
        System.out.println(minMoves2Result(nums));

    }
}
