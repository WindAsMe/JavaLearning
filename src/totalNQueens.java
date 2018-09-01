/**
 * Author     : WindAsMe
 * File       : totalNQueens.java
 * Time       : Create on 18-9-1
 * Location   : ../Home/JavaForLeeCode2/totalNQueens.java
 * Function   : LeetCode No.52
 */
public class totalNQueens {

    private static int totalNQueensResult(int n) {
        int[] ans = {0};
        for (int i = 0; i < n; i++) {
            boolean[][] helper = new boolean[n][n];
            helper[0][i] = true;
            dfs(n, ans, helper, 0);
        }
        return ans[0];
    }

    private static void dfs(int n, int[] ans, boolean[][] helper, int row) {
        for (int i = 0; i < n; i++) {
            if (valid(helper, row + 1, i, n)) {
                if (row + 1 == n - 1)
                    ans[0]++;
                else {
                    boolean[][] copy = helper.clone();
                    copy[row + 1][i] = true;
                    dfs(n, ans, copy, row + 1);
                }
            }
        }
    }

    private static boolean valid(boolean[][] helper, int row, int column, int n) {
        for (int i = 0; i < n; i++) {
            if (helper[row][i] || helper[i][column])
                return false;
        }
        int i = 1;
        while (row + i < n && row - i >= 0 && column + i < n && column + i >= 0) {
            if (helper[row + i][column + i] || helper[row - i][column - i] || helper[row + i][column - i] || helper[row - i][column + i])
                return false;
            else
                i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueensResult(2));
    }
}
