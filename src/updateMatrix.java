import java.util.*;


/**
 * Author     : WindAsMe
 * File       : updateMatrix.java
 * Time       : Create on 18-8-6
 * Location   : ../Home/JavaForLeeCode2/updateMatrix.java
 * Function   : LeetCode No.542
 */
public class updateMatrix {


    private static int[][] updateMatrixResult(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }


    // Add the '0' position to list
    // find the min distance
    // TL
    private static int[][] updateMatrixResult1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int[][] ans = new int[matrix.length][matrix[0].length];
        // Save the '0' patch's row and column
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int[] tip = {i, j};
                    list.add(tip);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    int min = Integer.MAX_VALUE;
                    // Calculate the min
                    for (int[] tip : list)
                        min = Math.min(Math.abs(i - tip[0]) + Math.abs(j - tip[1]), min);
                    ans[i][j] = min;
                }
            }
        }
        return ans;
    }


    // This is totally bfs: TL
    private static int[][] updateMatrixResult2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.println("i: " + i + "j: " + j);
                    ans[i][j] = find(i, j, matrix, 0);
                }
            }
        }
        return ans;
    }

    private static int find(int i, int j, int[][] matrix, int path) {
        if (i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == 0)
                return path;
            if (path > matrix.length + matrix[0].length)
                return Integer.MAX_VALUE;
            return Math.min(Math.min(Math.min(find(i + 1, j, matrix, path + 1), find(i - 1, j, matrix, path + 1)), find(i, j + 1, matrix, path + 1)), find(i, j - 1, matrix, path + 1));
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        };

        int[][] ans = updateMatrixResult(matrix);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
