/**
 * Author     : WindAsMe
 * File       : dominantIndex.java
 * Time       : Create on 18-8-17
 * Location   : ../Home/JavaForLeeCode2/dominantIndex.java
 * Function   : LeetCode No.747
 */
public class dominantIndex {

    private static int dominantIndexResult(int[] nums) {
        if (nums.length < 2)
            return -1;
        int first = nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0] <= nums[1] ? nums[0] : nums[1];
        int flag = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                first = i;
            }
        }
        return first >= 2 * second ? flag : -1;
    }


    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        System.out.println(dominantIndexResult(nums));
    }
}
