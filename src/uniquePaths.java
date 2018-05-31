/**
 * Author     : WindAsMe
 * File       : uniquePaths.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/uniquePaths.java
 * Function   : LeeCode No.62
 */
public class uniquePaths {

    // Recursion
    private static int uniquePathsResult(int m, int n){
        // System.out.println("running: " + "( " + m + " , " + n + " )");
        if (m < 1 || n < 1){
            return 0;
        } else if (m == 1 || n == 1){
            return 1;
        } else {
            int x = 0;
            int y = 0;
            int sum = 0;
            x += 1;
            sum += uniquePathsResult(m - x, n);
            y += 1;
            sum += uniquePathsResult(m, n - y);
            return sum;
        }

    }

    // Iteration
    private static int uniquePathsResult2(int m, int n){
        int[][] result = new int[m][n];
        for (int i = 0 ; i < m ; i ++ )
            result[i][0] = 1;
        for (int i = 0 ; i < n ; i ++ )
            result[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                result [i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(uniquePathsResult2(7, 3));
    }
}
