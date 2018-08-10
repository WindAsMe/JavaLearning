import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : matrixScore.java
 * Time       : Create on 18-8-10
 * Location   : ../Home/JavaForLeeCode2/matrixScore.java
 * Function   : LeetCode No.861
 */
public class matrixScore {

    private static int matrixScoreResult(int[][] A) {
        int sum = 0;
        if (A.length == 0 || A[0].length == 0)
            return 0;
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < a.length; i++)
                    a[i] = a[i] == 1 ? 0 : 1;
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            int zero = 0;
            int one = 0;
            for (int[] aA : A) {
                if (aA[i] == 0)
                    zero++;
                else
                    one++;
            }
            if (zero > one)
                convert(A, i);
        }

        for (int[] a : A) {
            int len = a.length - 1;
            for (int i : a) {
                sum += Math.pow(2, len) * i;
                len--;
            }
        }
        for (int[] a : A)
            System.out.println(Arrays.toString(a));
        return sum;
    }

    private static void convert(int[][] A, int index) {
        for (int i = 0 ; i < A.length; i++)
            A[i][index] = A[i][index] == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        System.out.println(matrixScoreResult(A));
    }
}
