/**
 * Author     : WindAsMe
 * File       : numMagicSquaresInside.java
 * Time       : Create on 18-8-25
 * Location   : ../Home/JavaForLeeCode2/numMagicSquaresInside.java
 * Function   : LeetCode No.840
 */
public class numMagicSquaresInside {

    private static int numMagicSquaresInsideResult(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isValid(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    private static boolean isValid(int[][] grid, int i, int j) {
        return grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15 &&
                grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15 &&
                grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15 &&
                grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15 &&
                grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15 &&
                grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };
        System.out.println(numMagicSquaresInsideResult(grids));
    }
}
