import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : fairCandySwap.java
 * Time       : Create on 18-10-19
 * Location   : ../Home/JavaForLeeCode2/fairCandySwap.java
 * Function   : LeetCode No.888
 */
public class fairCandySwap {

    private static int[] fairCandySwapResult(int[] A, int[] B) {
        int aSum = arraySum(A);
        int bSum = arraySum(B);
        int[] ans = new int[2];
        for (int a : A) {
            for (int b :B) {
                if (aSum - a + b == bSum - b + a) {
                    ans[0] = a;
                    ans[1] = b;
                    return ans;
                }
            }
        }
        return null;
    }

    private static int arraySum(int[] Candies) {
        int sum = 0;
        for (int i : Candies)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {2, 3};
        System.out.println(Arrays.toString(fairCandySwapResult(A, B)));
    }
}
