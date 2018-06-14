/**
 * Author     : WindAsMe
 * File       : islandPerimeter.java
 * Time       : Create on 18-6-14
 * Location   : ../Home/JavaForLeeCode2/islandPerimeter.java
 * Function   : LeeCode No.463
 */
public class islandPerimeter {

    private static int islandPerimeterResult(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int n = 4;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) n--;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) n--;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) n--;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) n--;
                    count += n;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
                };
        System.out.println(islandPerimeterResult(grid));
    }
}
