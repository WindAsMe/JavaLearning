/**
 * Author     : WindAsMe
 * File       : findCircleNum.java
 * Time       : Create on 18-9-13
 * Location   : ../Home/JavaForLeeCode2/findCircleNum.java
 * Function   : LeetCode No.547
 */
public class findCircleNum {

    private static int findCircleNumResult(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 0) {
                    count++;
                    dfs(M, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int row, int column) {
        if (M[row][column] == 1) {
            M[row][column] = 0;
            dfs(M,row + 1, column);
            dfs(M, row, column + 1);
        }
    }
}
