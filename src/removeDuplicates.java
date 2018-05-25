/**
 * Author     : WindAsMe
 * File       : removeDuplicates.java
 * Time       : Create on 18-5-25
 * Location   : ../Home/JavaForLeeCode2/removeDuplicates.java
 * Function   : LeeCode No.26
 */
public class removeDuplicates {

    private static int removeDuplicatesResult(int[] nums){
        int flag = 1;
        int length = nums.length;
        for (int i = 0 ; i < nums.length - flag ; i ++ ){
            if (nums[i] == nums[i + 1]){
                length -= 1;
                // Swap the element
                for (int j = i + 1 ; j < nums.length - flag ; j ++ ){
                    nums[j] = nums[j + 1];
                }
                // If element for loop occurs many times
                // Stay and loop
                i -= 1;
                flag += 1;
            }
        }
        for (int i = 0 ; i <= nums.length - flag ; i ++) {
            System.out.println(nums[i]);
        }
        System.out.println("flag:" + flag);
        return length;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,3,3,4,5,5,6};
        System.out.println("length:" + removeDuplicatesResult(nums));
    }
}
