/**
 * Author     : WindAsMe
 * File       : removeElement.java
 * Time       : Create on 18-5-28
 * Location   : ../Home/JavaForLeeCode2/removeElement.java
 * Function   : LeeCode No.27
 */
public class removeElement {

    private static int removeElementResult(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int currentLength = nums.length;
        for (int i = 0 ; i < currentLength - 1; i ++ ){
            if (nums[i] == val){
                for (int j = i + 1 ; j < currentLength ; j ++ ){
                    nums[j - 1] = nums[j];
                }
                // Preventing the after movement
                // The next value == val
                i -= 1;
                currentLength -= 1;
            }
        }
        if (nums[currentLength - 1] == val){
            currentLength -= 1;
        }

        for (int i = 0 ; i < currentLength ; i ++ )
            System.out.println(nums[i]);
        return currentLength;
    }

    public static void main(String[] args){
        int[] nums = {};
        System.out.println("length" + removeElementResult(nums, 0));
    }
}
