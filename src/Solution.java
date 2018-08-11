import java.util.Random;

/**
 * Author     : WindAsMe
 * File       : Solution.java
 * Time       : Create on 18-8-11
 * Location   : ../Home/JavaForLeeCode2/Solution.java
 * Function   : LeetCode No.384
 */
public class Solution {

    private int[] nums = null;
    private Random random = null;
    public Solution(int[] nums) {
        this.nums = nums.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int i = 1; i < nums.length; i++){
            int j = random.nextInt(i + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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