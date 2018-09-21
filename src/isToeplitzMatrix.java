/**
 * Author     : WindAsMe
 * File       : isToeplitzMatrix.java
 * Time       : Create on 18-9-21
 * Location   : ../Home/JavaForLeeCode2/isToeplitzMatrix.java
 * Function   : LeetCode No.766
 */
public class isToeplitzMatrix {

    private static boolean isToeplitzMatrixResult(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        if (matrix.length == 1 || matrix[0].length == 1)
            return true;
        int i = matrix.length - 2;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 2) {
            if (i == 0) {
                int flag = matrix[i][j];
                for (int row = i, column = j; row < matrix.length && column < matrix[0].length; row++, column++) {
                    System.out.print("flag: " + flag + " matrix: " + matrix[row][column] + " ");
                    if (matrix[row][column] != flag)
                        return false;
                }
                System.out.println();
                j++;
            } else {
                int flag = matrix[i][j];
                for (int row = i, column = j; row < matrix.length && column < matrix[0].length; row++, column++) {
                    System.out.print("flag: " + flag + " matrix: " + matrix[row][column] + " ");
                    if (matrix[row][column] != flag)
                        return false;
                }
                System.out.println();
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix =  {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(isToeplitzMatrixResult(matrix));
    }
}
