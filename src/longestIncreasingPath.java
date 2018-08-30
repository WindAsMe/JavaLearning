import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : longestIncreasingPath.java
 * Time       : Create on 18-8-30
 * Location   : ../Home/JavaForLeeCode2/longestIncreasingPath.java
 * Function   : LeetCode No.329
 */
public class longestIncreasingPath {

    private static int longestIncreasingPathResult1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] results = new int[row][column];
        // use the -1 to mark
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                results[i][j] = -1;
        }
        int longest = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (results[i][j] == -1) {
                    results[i][j] = helper(matrix, results, i, j);
                    longest = longest >= results[i][j] ? longest : results[i][j];
                }
            }
        }
        return longest;
    }

    private static int helper(int[][] matrix, int[][] res,int row, int col) {
        int longest = 0;
        if (res[row][col] != -1)
            return res[row][col];
        if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) {
            int lower = helper(matrix, res, row - 1, col);
            longest = longest >= lower ? longest : lower;
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            int upper = helper(matrix, res, row + 1, col);
            longest = longest >= upper ? longest : upper;
        }
        if (col-1 >= 0 && matrix[row][col - 1] > matrix[row][col]){
            int left = helper(matrix, res, row, col - 1);
            longest = longest >= left ? longest : left;
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] > matrix[row][col]){
            int right = helper(matrix, res, row, col + 1);
            longest = longest >= right ? longest : right;
        }
        res[row][col] = longest + 1;
        return longest + 1;
    }


    private static int longestIncreasingPathResult(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int max = 0;
        int[][] ans = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = -1;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                bfs(ans, matrix, i, j, row, column, 1, 0);
                max = max > ans[i][j] ? max : ans[i][j];
            }
        }
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
        return max;
    }

    private static void bfs( int[][] ans, int[][] matrix, int i, int j, int row, int column, int len, int pre) {
        if (i >= 0 && i < row && j >= 0 && j < column && ans[i][j] == -1 && matrix[i][j] > pre) {
            ans[i][j] = len;
            bfs(ans, matrix, i - 1, j, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i + 1, j, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i, j - 1, row, column, len + 1, matrix[i][j]);
            bfs(ans, matrix, i, j + 1, row, column, len + 1, matrix[i][j]);
        } else if (i >= 0 && i < row && j >= 0 && j < column)
            ans[i][j] = ans[i][j] > len ? ans[i][j] : len;
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
