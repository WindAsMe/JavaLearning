/**
 * Author     : WindAsMe
 * File       : searchMatrix2.java
 * Time       : Create on 18-6-8
 * Location   : ../Home/JavaForLeeCode2/searchMatrix2.java
 * Function   : LeeCode No.240
 */
public class searchMatrix2 {

    private static boolean searchMatrix2Result(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int layer = 0;
        int begin = 0;
        int end = matrix[0].length - 1;
        while (layer < matrix.length) {
            if (matrix[layer][begin] > target || matrix[layer][end] < target) {
                layer ++;
            } else {
                int index = 0;
                while (index <= end) {
                    if (matrix[layer][index] > target) {
                        break;
                    } else if (matrix[layer][index] < target) {
                        index ++;
                    } else {
                        return true;
                    }
                }
                layer ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2},{20}
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix2Result(matrix, 20));

    }
}
