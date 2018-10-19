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
        int[] ans = new int[2];
        for (int i = 0; i < A.length; i++) {
            int aSum = arraySum(A, i);
            for (int j = 0; j < B.length; j++) {
                int bSum = arraySum(B, j);
                if (aSum + B[j] == bSum + A[i]) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    return ans;
                }
            }
        }
        return null;
    }

    private static int arraySum(int[] Candies, int index) {
        int sum = 0;
        for (int i : Candies)
            sum += i;
        return sum - Candies[index];
    }

    public static void main(String[] args) {
        int[] A = {1, 1};
        int[] B = {2, 2};
        System.out.println(Arrays.toString(fairCandySwapResult(A, B)));
    }
}
