/**
 * Author     : WindAsMe
 * File       : projectionArea.java
 * Time       : Create on 18-10-13
 * Location   : ../Home/JavaForLeeCode2/projectionArea.java
 * Function   : LeetCode No.883
 */
public class projectionArea {

    private static int projectionAreaResult(int[][] grid) {
        if (grid == null)
            return 0;
        int hang = grid.length;
        int lie = grid[0].length;
        int down =0;
        int main = 0;
        int left = 0;
        for (int i = 0; i < hang; i++) {
            int main_mid = 0;
            int left_mid = 0;
            for (int j = 0; j < lie; j++) {
                if(grid[i][j]>0)
                    down++;
                if (grid[i][j] > main_mid)
                    main_mid = grid[i][j];
                if (grid[j][i] > left_mid)
                    left_mid = grid[j][i];
            }
            left = left_mid + left;
            main = main_mid + main;
        }
        return left + main + down;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        System.out.println(projectionAreaResult(grid));
    }
}
