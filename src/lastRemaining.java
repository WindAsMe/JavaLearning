import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : lastRemaining.java
 * Time       : Create on 18-6-14
 * Location   : ../Home/JavaForLeeCode2/lastRemaining.java
 * Function   : LeeCode No.390
 */
public class lastRemaining {

    private static int lastRemainingResult1(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        // Transfer to even
        // f(2k + 1) = f(2k)
        if((n & 0x1) == 0x1){
            n --;
        }
        if(((n - 1) & n) == 0){
            // 2 ^ x
            int index = 0;
            int tmpN = n;
            tmpN = tmpN >>> 1;
            while(tmpN > 0){
                // n = 2 ^ k
                // index represent the k
                index ++;
                tmpN = tmpN >>> 1;
            }
            int ans;
            if((index & 1) == 1){
                // index is odd
                // correspond to f(n) = (2n + 2) / 3,
                // tmpN = 2n
                tmpN=n << 1;
            }
            else{
                // index is even
                // correspond to f(n)=(n + 2) / 3
                // tmpN = n
                tmpN = n;
            }
            // tmpN = n or tmpN = 2n
            ans = (tmpN + 2) / 3;
            return ans;

        }
        else{
            // Ensure n % 2 == 0
            int tmpAns = lastRemainingResult1(n >>> 1);
            return n - 2 * tmpAns + 2;
        }
    }



    // This management is TL
    private static int lastRemainingResult(int n) {
        if (n == 1)
            return 1;
        int[] nums = new int[n / 2];
        for (int i = 0 ; i < n / 2; i ++ ) {
            nums[i] = 2 * (i + 1);
        }
        return getLast(false, nums);
    }

    // If read from left: isLeft = true
    // If read from right: isLeft = false
    private static int getLast(boolean isLeft, int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 1) {
            return nums[0];
        } else {
            int[] temp = new int[nums.length / 2];
            if (isLeft) {
                for (int i = 0 ; i < nums.length / 2 ; i ++ ) {
                    temp[i] = nums[2 * i + 1];
                }
                return getLast(false, temp);
            } else {
                int j = nums.length / 2 - 1;
                for (int i = nums.length - 2 ; i >= 0 ; i -= 2) {
                    temp[j] = nums[i];
                    j --;
                }
                return getLast(true, temp);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(lastRemainingResult1(100000));
    }
}
