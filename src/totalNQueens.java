/**
 * Author     : WindAsMe
 * File       : totalNQueens.java
 * Time       : Create on 18-9-1
 * Location   : ../Home/JavaForLeeCode2/totalNQueens.java
 * Function   : LeetCode No.52
 */
public class totalNQueens {

    public int totalNQueens(int n) {
        boolean[] leftCordinal = new boolean[n*2-1],
                rightCordinal= new boolean[n*2-1],
                vertical = new boolean[n];
        int result = 0;
        return totalNQueens(0, n, result, vertical, leftCordinal, rightCordinal);
    }

    public int totalNQueens(int current, int n, int result, boolean[] vertical, boolean[] leftCordinal, boolean[] rightCordinal){
        if(current == n){
            return ++result;
        }

        for(int i = 0 ; i<n ; i++){
            if(vertical[i] || leftCordinal[i+current] || rightCordinal[i-current+n-1]){
                continue;
            }
            vertical[i] = true;
            leftCordinal[i+current] = true;
            rightCordinal[i-current+n-1] = true;
            result = totalNQueens(current+1, n, result, vertical, leftCordinal, rightCordinal);
            vertical[i] = false;
            leftCordinal[i+current] = false;
            rightCordinal[i-current+n-1] = false;
        }
        return result;
    }


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
        for (int i = 0; i < row; i++) {
            if (helper[i][column])
                return false;
        }
        for (int i = 0; i < column; i++) {
            if (helper[row][i])
                return false;
        }
        //int i = 1;
//        while (row + i < n && column + i < n) {
//            if (helper[row + i][column + i])
//                return false;
//            else
//                i++;
//        }
//        i = 1;
//        while (row - i >= 0 && column - i >= 0) {
//            if (helper[row - i][column - i])
//                return false;
//            else
//                i++;
//        }
//        i = 1;
//        while (row - i >= 0 && column + i < n) {
//            if (helper[row - i][column + i])
//                return false;
//            else
//                i++;
//        }
//        i = 1;
//        while (row + i < n && column - i >= 0) {
//            if (helper[row + i][column - i])
//                return false;
//            else
//                i++;
//        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueensResult(8));
    }
}
