/**
 * Author     : WindAsMe
 * File       : findPeakElement.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/findPeakElement.java
 * Function   : LeeCode No.162
 */
public class findPeakElement {

    private static int findPeakElementResult(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        } else {
            // Different between odd and even
            int lPointer = nums.length / 2 - ((nums.length + 1) % 2);
            int rPointer = nums.length / 2;
            while (lPointer > 0 && rPointer < nums.length - 1){
                System.out.println("l: " + lPointer + " " + "r: " + rPointer);
                if (nums[lPointer] > nums[lPointer + 1] && nums[lPointer] > nums[lPointer - 1]) {
                    return lPointer;
                } else {
                    lPointer -= 1;
                }

                if (nums[rPointer] > nums[rPointer + 1] && nums[rPointer] > nums[rPointer - 1]) {
                    return rPointer;
                } else {
                    rPointer += 1;
                }
            }
            if (nums[0] > nums[1]){
                return 0;
            }
            if (nums[nums.length - 1] > nums[nums.length - 2]){
                return nums.length - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        int[] nums = {3,4,3,2,1};
        System.out.println(findPeakElementResult(nums));
    }
}
