import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : flipAndInvertImage.java
 * Time       : Create on 18-8-23
 * Location   : ../Home/JavaForLeeCode2/flipAndInvertImage.java
 * Function   : LeetCode No.832
 */
public class flipAndInvertImage {

    // O(n^2)
    private static int[][] flipAndInvertImageResult1(int[][] A) {
        for (int i = 0; i < A.length; i++)
            A[i] = f(A[i]);
        return A;
    }

    private static int[] f(int[] a) {
        int l = a.length;
        int[] res = new int[l];
        for (int i = 0; i < l; i++)
            res[i] = (a[l - i - 1] + 1) % 2;
        return res;
    }

    // O(2*n^2)
    private static int[][] flipAndInvertImageResult(int[][] A) {
        if (A.length == 0 || A[0].length == 0)
            return A;
        int row = A.length;
        int column = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][column - j - 1];
                A[i][column - j - 1] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                A[i][j] = A[i][j] == 1 ? 0 : 1;
        }

        // for (int[] a : A)
        //     System.out.println(Arrays.toString(a));
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
        int[][] ans = flipAndInvertImageResult(A);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
