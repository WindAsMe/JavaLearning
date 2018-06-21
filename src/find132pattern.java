import java.util.*;

/**
 * Author     : WindAsMe
 * File       : find132pattern.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/find132pattern.java
 * Function   :
 */
public class find132pattern {

    private static boolean find132patternResult(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        // Iteration from end to begin
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < third) {
                return true;
            } else while (!stack.empty() && nums[i] > stack.peek()) {
                third = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // Brute force: TL
//    private static boolean find132patternResult(int[] nums) {
//        if (nums.length <= 2) {
//            return false;
//        } else {
//            int temp1 = nums[0];
//            int index = 0;
//            while (index <= nums.length - 2) {
//                for (int i = index + 1; i < nums.length; i++) {
//                    if (nums[i] > temp1) {
//                        int temp2 = nums[i];
//                        for (int j = i + 1 ; j < nums.length ; j ++ ) {
//                            if (temp2 > nums[j] && nums[j] > temp1) {
//                                //System.out.println("temp1: " + temp1 + " temp2: " + temp2 + " num[j]: " + nums[j]);
//                                return true;
//                            }
//                        }
//                    }
//                }
//                index ++;
//                temp1 = nums[index];
//            }
//            return false;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(find132patternResult(nums));
    }
}
