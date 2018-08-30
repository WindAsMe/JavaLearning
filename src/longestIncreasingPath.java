import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : longestIncreasingPath.java
 * Time       : Create on 18-8-30
 * Location   : ../Home/JavaForLeeCode2/longestIncreasingPath.java
 * Function   : LeetCode No.329
 */
public class longestIncreasingPath {

    private static int longestIncreasingPathResult(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int max = 0;
        int[][] ans = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                bfs(ans, matrix, i, j, row, column, 1, 0);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                max = max > ans[i][j] ? max : ans[i][j];
        }
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
        return max;
    }

    private static void bfs(int[][] ans, int[][] matrix, int i, int j, int row, int column, int len, int pre) {
        if (i >= 0 && i < row && j >= 0 && j < column && matrix[i][j] > pre) {
            bfs(ans, matrix, i - 1, j, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i + 1, j, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i, j - 1, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i, j + 1, row, column, len + 1, matrix[i][j]);
        } else
            ans[i][j] = len > ans[i][j] ? len : ans[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPathResult(nums));
    }
}
