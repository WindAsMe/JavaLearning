import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : updateMatrix.java
 * Time       : Create on 18-8-6
 * Location   : ../Home/JavaForLeeCode2/updateMatrix.java
 * Function   : LeetCode No.542
 */
public class updateMatrix {

    private static int[][] updateMatrixResult(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    ans[i][j] = find(i, j, matrix, 0);
                }
            }
        }
        return ans;
    }

    private static int find(int i, int j, int[][] matrix, int path) {
        if (i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == 0)
                return path;
            if (path > matrix.length + matrix[0].length)
                return Integer.MAX_VALUE;
            return Math.min(Math.min(Math.min(find(i + 1, j, matrix, path), find(i - 1, j, matrix, path)), find(i, j + 1, matrix, path)), find(i, j - 1, matrix, path));
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int[][] ans = updateMatrixResult(matrix);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
