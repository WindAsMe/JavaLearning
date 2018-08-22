import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : transpose.java
 * Time       : Create on 18-8-22
 * Location   : ../Home/JavaForLeeCode2/transpose.java
 * Function   : LeetCode No.867
 */
public class transpose {

    private static int[][] transposeResult(int[][] A) {
        if (A.length == 0 || A[0].length == 0)
            return A;
        int row = A.length;
        int column = A[0].length;
        int[][] ans = new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] ans = transposeResult(A);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));

    }
}
