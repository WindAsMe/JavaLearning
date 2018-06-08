
/**
 * Author     : WindAsMe
 * File       : rob.java
 * Time       : Create on 18-6-8
 * Location   : ../Home/JavaForLeeCode2/rob.java
 * Function   : LeeCode No.213
 */
public class rob {

    private static int robResult(int[] nums) {
        // If nums.length() == 3: return the biggest one
        if (nums.length <= 0 ) {
            return 0;
        } else if (nums.length <= 3) {
            int biggest = nums[0];
            for (int num : nums) {
                biggest = biggest > num ? biggest : num;
            }
            return biggest;
        } else {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            sum[1] = nums[1];
            int i = 2;
            for (; i < nums.length; i ++ ) {
                sum[i] = Math.max(sum[i - 2] + nums[i], sum[i - 1]);
            }

            return Math.max(sum[i - 1], nums[i - 1]);
        }

    }

    public static void main(String[] args) {
        //int[] num = {29,83,62,52,7,44,33,11,88,5,3,21,12};
        int[] num = {1,5,11,15,9,6,4,7};
        System.out.println(robResult(num));
    }

}
