/**
 * Author     : WindAsMe
 * File       : minPathSum.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/minPathSum.java
 * Function   : LeeCode No.64
 */
public class minPathSum {

    private static int minPathSumResult(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;

        if (x == 0){
            return 0;
        } else if (x == 1){
            int min = 0;
            for (int i = 0 ; i < y ; i ++ ){
                min += grid[i][0];
            }
            return min;
        } else if (y == 1){
            int min = 0;
            for (int i = 0 ; i < x ; i ++ ){
                min += grid[0][i];
            }
            return min;
        } else {
            int[][] result = new int[y][x];
            result[y - 1][x - 1] = grid[y - 1][x - 1];

            // Initiation
            for (int i = x - 2 ; i >= 0 ; i -- ){
                result[y - 1][i] = grid[y - 1][i] + result[y - 1][i + 1];
            }
            for (int i = y - 2 ; i >= 0 ; i -- ){
                result[i][x - 1] = grid[i][x - 1] + result[i + 1][x - 1];
            }


            for (int i = x - 2 ; i >= 0 ; i -- ){
                for (int j = y - 2 ; j >= 0 ; j -- ){
                    // Reversed iteration
                    // Greedy Algorithm:
                    // Result[][] save the min route
                    result[j][i] = Math.min(result[j + 1][i], result[j][i + 1]) + grid[j][i];
                }
            }
            return result[0][0];

        }
    }


    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSumResult(grid));
    }
}
