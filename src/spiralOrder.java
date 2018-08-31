import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : spiralOrder.java
 * Time       : Create on 18-8-31
 * Location   : ../Home/JavaForLeeCode2/spiralOrder.java
 * Function   : LeetCode No.54
 */
public class spiralOrder {

    private static List<Integer> spiralOrderResult(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int rowBegin = 0;
        int rowEnd = m - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; ++i)
                list.add(matrix[rowBegin][i]);
            rowBegin++;
            if (rowBegin > rowEnd)
                break;
            for (int i = rowBegin; i <= rowEnd; ++i)
                list.add(matrix[i][colEnd]);
            colEnd--;
            if (colBegin > colEnd)
                break;
            for (int i = colEnd; i >= colBegin; --i)
                list.add(matrix[rowEnd][i]);
            rowEnd--;
            if (rowBegin > rowEnd)
                break;
            for (int i = rowEnd; i>= rowBegin; --i)
                list.add(matrix[i][colBegin]);
            colBegin++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrderResult(matrix).toString());
    }
}
