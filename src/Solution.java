/**
 * Author     : WindAsMe
 * File       : Solution.java
 * Time       : Create on 18-8-11
 * Location   : ../Home/JavaForLeeCode2/Solution.java
 * Function   : LeetCode No.384
 */
public class Solution {

    private static int[] nums;
    public Solution(int[] nums) {
        this.nums = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public static int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public static int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = ans.length - 1 ; i > 0 ; i -- ) {
            int temp = ans[i];
            int index = (int) (Math.random() * i);
            ans[index] = temp;
            ans[i] = ans[index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */