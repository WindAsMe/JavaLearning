/**
 * Author     : WindAsMe
 * File       : maxProduct.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/maxProduct.java
 * Function   : LeeCode No.152
 */
public class maxProduct {

    private static int maxProductResult(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int res = nums[0];
        int [] minlist = new int [2];
        int [] maxlist = new int [2];
        for (int i = 0; i < 2; i++){
            minlist[i] = nums[0];
            maxlist[i] = nums[0];
        }
        for (int i = 1; i < n; i++){
            minlist[i % 2] = nums[i];
            maxlist[i % 2] = nums[i];
            if (nums[i] > 0){
                maxlist[i % 2] = Math.max(maxlist[i % 2], maxlist[(i - 1) % 2] * nums[i]);
                minlist[i % 2] = Math.min(minlist[i % 2], minlist[(i - 1) % 2] * nums[i]);
            }
            else {
                maxlist[i % 2] = Math.max(maxlist[i % 2], minlist[(i - 1) % 2] * nums[i]);
                minlist[i % 2] = Math.min(minlist[i % 2], maxlist[(i - 1) % 2] * nums[i]);
            }
            res = Math.max(res, maxlist[i % 2]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {-2, -2, -1, 3, 4};
        System.out.println(maxProductResult(nums));
    }

}
