import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : flipAndInvertImage.java
 * Time       : Create on 18-8-23
 * Location   : ../Home/JavaForLeeCode2/flipAndInvertImage.java
 * Function   : LeetCode No.832
 */
public class flipAndInvertImage {

    private static int[][] flipAndInvertImageResult(int[][] A) {
        if (A.length == 0 || A[0].length == 0)
            return A;
        int row = A.length;
        int column = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][column - j];
                A[i][column - j] = temp;
            }
        }

        for (int[] a : A)
            System.out.println(Arrays.toString(a));
        return null;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        flipAndInvertImageResult(A);
    }
}
