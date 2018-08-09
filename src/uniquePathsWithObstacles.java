/**
 * Author     : WindAsMe
 * File       : uniquePathsWithObstacles.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/uniquePathsWithObstacles.java
 * Function   : LeeCode No.63
 */
public class uniquePathsWithObstacles {

    private static int uniquePathsWithObstaclesResult(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        if (y == 0){
            return 0;
        } else if (y == 1) {
            for (int[] anObstacleGrid : obstacleGrid) {
                if (anObstacleGrid[0] == 1)
                    return 0;
            }
            return 1;
        } else if (x == 1) {
            for (int i = 0; i < y; i++) {
                if (obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        } else {
            int[][] sum = new int[x][y];
            int temp = 1;
            for (int i = y - 1; i >= 0; i--) {
                if (obstacleGrid[x - 1][i] == 1) {
                    temp = 0;
                    sum[x - 1][i] = temp;
                } else {
                    sum[x - 1][i] = temp;
                }
            }
            temp = 1;
            for (int i = x - 1; i >= 0; i--) {
                if (obstacleGrid[i][y - 1] == 1) {
                    temp = 0;
                    sum[i][y - 1] = temp;
                } else {
                    sum[i][y - 1] = temp;
                }
            }
            sum[x - 1][y - 1] = Math.max(sum[x - 1][y - 2], sum[x - 2][y - 1]);


            for (int i = x - 2; i >= 0; i--) {
                for (int j = y - 2; j >= 0; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        sum[i][j] = 0;
                    } else {
                        sum[i][j] = sum[i + 1][j] + sum[i][j + 1];
                    }
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(sum[i][j]);
                }
                System.out.println();
            }

            return sum[0][0];
        }
    }

    public static void main(String[] args){
        int[][] path = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
                };
        System.out.println(uniquePathsWithObstaclesResult(path));
    }
}
