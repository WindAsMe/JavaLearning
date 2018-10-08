/**
 * Author     : WindAsMe
 * File       : largestTriangleArea.java
 * Time       : Create on 18-10-8
 * Location   : ../Home/JavaForLeeCode2/largestTriangleArea.java
 * Function   : LeetCode No.812
 */
public class largestTriangleArea {

    private static double largestTriangleAreaResult(int[][] points) {
        double area = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points)
                    area = Math.max(area, 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]));
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] p = {{10,7},{0,4},{5,7}};
        System.out.println(largestTriangleAreaResult(p));
    }
}
