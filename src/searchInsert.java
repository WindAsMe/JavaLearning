/**
 * Author     : WindAsMe
 * File       : searchInsert.java
 * Time       : Create on 18-5-29
 * Location   : ../Home/JavaForLeeCode2/searchInsert.java
 * Function   : LeeCode No.35
 */
public class searchInsert {

    private static int searchInsertResult(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        } else if (nums.length == 1){
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (target <= nums[0]){
                return 0;
            }
            int i;
            for (i = 0; i < nums.length - 1 ; i ++ ){
                if (nums[i] == target){
                    return i;
                } else if (nums[i] < target && nums[i + 1] > target){
                    return i + 1;
                }
            }
            if (nums[i] >= target){
                return i;
            } else {
                return i + 1;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 3};
        System.out.println(searchInsertResult(nums, 7));
    }
}
