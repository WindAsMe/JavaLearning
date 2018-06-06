import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : maximalSquare.java
 * Time       : Create on 18-6-6
 * Location   : ../Home/JavaForLeeCode2/maximalSquare.java
 * Function   : LeeCode No.221
 */
public class maximalSquare {

    // If use iteration:
    // The stack save way
    private static class Tuple{
        private int row;
        private int column;
        Tuple(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    //--------------------------------------------------------------
    private static int maximalSquareResult(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        } else if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        } else {
            int maxArea = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++ ) {
                    if (matrix[i][j] == '1') {
                        maxArea = Math.max(findMaxArea(i, j, matrix), maxArea);
                    }
                }
            }
            return maxArea;
        }
    }

    // Iterate from left top to right button
    // So only the right and down need judge
    private static int findMaxArea(int i, int j, char[][] matrix) {
        int tempI = i + 1;
        int tempJ = j + 1;
        while (tempI <= matrix.length - 1 && tempJ <= matrix[0].length - 1) {
            // System.out.println("current information:" + temp + "(" + i + "," + j + ")");
            if (matrix[tempI][tempJ] == '1') {
                for (int step = 1 ; step <= tempI - i ; step ++ ) {
                    if (matrix[tempI - step][tempJ] != '1' || matrix[tempI][tempJ - step] != '1') {
                        return (tempI - i) * (tempJ - j);
                    }
                }
                tempI ++;
                tempJ ++;
            } else {
                return (tempI - i) * (tempJ - j);
            }
        }
        return (tempI - i) * (tempJ - j);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','0','1'},
                {'1','1','1','1'}
//                {'0','1','1','0','0','1','0','1','0','1'},
//                {'0','0','1','0','1','0','1','0','1','0'},
//                {'1','0','0','0','0','1','0','1','1','0'},
//                {'0','1','1','1','1','1','1','0','1','0'},
//                {'0','0','1','1','1','1','1','1','1','0'},
//                {'1','1','0','1','0','1','1','1','1','0'},
//                {'0','0','0','1','1','0','0','0','1','0'},
//                {'1','1','0','1','1','0','0','1','1','1'},
//                {'0','1','0','1','1','0','1','0','1','1'}
        };
        System.out.println(maximalSquareResult(matrix));
    }
}
