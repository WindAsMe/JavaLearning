/**
 * Author     : WindAsMe
 * File       : searchMatrix.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/searchMatrix.java
 * Function   : LeeCode No.74
 */
public class searchMatrix {

    // The most efficient algorithm
    // Hash Algorithm
    private static boolean searchMatrixResult(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int row = 0;
        for (; row < matrix.length - 1 ; row ++ ){
            if (matrix[row][0] <= target && matrix[row + 1][0] > target){
                for (int temp = 0 ; temp < matrix[0].length ; temp ++ ){
                    if (matrix[row][temp] == target){
                        return true;
                    }
                }
                return false;
            }
        }
        // For the last row
        for (int temp = 0 ; temp < matrix[0].length ; temp ++ ){
            if (matrix[row][temp] == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix  = {{}};
        System.out.println(searchMatrixResult(matrix, 19));
    }
}
