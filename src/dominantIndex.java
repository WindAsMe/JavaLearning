/**
 * Author     : WindAsMe
 * File       : dominantIndex.java
 * Time       : Create on 18-8-17
 * Location   : ../Home/JavaForLeeCode2/dominantIndex.java
 * Function   : LeetCode No.747
 */
public class dominantIndex {

    private static int dominantIndexResult(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int first = nums[0] > nums[1] ? nums[0] : nums[1];
        int second = nums[0] <= nums[1] ? nums[0] : nums[1];
        int flag = nums[0] > nums[1] ? 0 : 1;
        for (int i = 2; i < nums.length; i++) {
           if (nums[i] > first) {
                second = first;
                first = nums[i];
                flag = i;
            }
            if (nums[i] > second && nums[i] < first)
                second = nums[i];
           System.out.println("first: " + first + " second: " + second);
        }
        return first >= 2 * second ? flag : -1;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,2,3};
        System.out.println(dominantIndexResult(nums));
    }
}
