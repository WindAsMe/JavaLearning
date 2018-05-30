/**
 * Author     : WindAsMe
 * File       : maxSubArray.java
 * Time       : Create on 18-5-30
 * Location   : ../Home/JavaForLeeCode2/maxSubArray.java
 * Function   : LeeCode No.53
 */
public class maxSubArray {

    private static int maxSubArrayResult(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = sum>0?(sum+nums[i]):nums[i];
            max =sum>max?sum:max;
        }
        return max;
    }

    private static int maxSub(int[] nums){
        int sum = 0;
        int max = 0;
        for (int i = 0 ; i < nums.length ; i ++ ){
            sum = sum > 0 ? nums[0] + sum : nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSub(nums));
    }
}
