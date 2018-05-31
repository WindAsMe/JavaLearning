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

    public static void main(String[] args){
        System.out.println(uniquePathsResult(51, 9));
    }
}
