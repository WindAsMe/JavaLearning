/**
 * Author     : WindAsMe
 * File       : maxSlidingWindow.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/maxSlidingWindow.java
 * Function   : LeeCode No.239
 */
public class maxSlidingWindow {

    private static int[] maxSlidingWindowResult(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] sum = new int[nums.length - k + 1];
        for (int i = 0 ; i <= nums.length - k ; i ++ ){
            int big = nums[i];
            for (int j = i ; j < i + k ; j ++ ){
                big = nums[j] > big ? nums[j] : big;
            }
            sum[i] = big;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] need = {};
        int[] num = maxSlidingWindowResult(need, 0);
        for (int i = 0 ; i < num.length ; i ++ ){
            System.out.print(num[i] + " ");
        }
    }
}
