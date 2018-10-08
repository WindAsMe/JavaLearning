/**
 * Author     : WindAsMe
 * File       : largestTriangleArea.java
 * Time       : Create on 18-10-8
 * Location   : ../Home/JavaForLeeCode2/largestTriangleArea.java
 * Function   : LeetCode No.812
 */
public class largestTriangleArea {

    private static double largestTriangleAreaResult(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int z = j + 1; z < points.length; z++) {
                    if (isTriangle(points[i], points[j], points[z])) {
                        double l1 = Math.sqrt(Math.pow(points[z][1] - points[j][1], 2) + Math.pow(points[z][0] - points[j][0], 2));
                        double l2 = Math.sqrt(Math.pow(points[z][1] - points[i][1], 2) + Math.pow(points[z][0] - points[i][0], 2));
                        double l3 = Math.sqrt(Math.pow(points[j][1] - points[i][1], 2) + Math.pow(points[j][0] - points[i][0], 2));
                        double p = (l1 + l2 + l3) / 2;
                        max = Math.max(Math.sqrt(p * (p - l1) * (p - l2) * (p - l3)), max);
                    }
                }
            }
        }
        return max;
    }

    private static boolean isTriangle(int[] p1, int[] p2, int[] p3) {
        return (p3[0] - p2[0] != 0 || p2[0] - p1[0] != 0) && (p3[0] - p1[0] != 0 || p2[0] - p1[0] != 0) && (p3[1] - p2[1] != 0 || p2[1] - p1[1] != 0) && (p3[1] - p1[1] != 0 || p2[1] - p1[1] != 0) && (p3[0] - p2[0] == 0 || p2[0] - p1[0] == 0 || p3[0] - p1[0] == 0 || p3[1] - p2[1] == 0 || p2[1] - p1[1] == 0 || p3[1] - p1[1] == 0 || (p3[1] - p2[1]) / (p3[0] - p2[0]) != (p2[1] - p1[1]) / (p2[0] - p1[0]));
    }

    public static void main(String[] args) {
        int[][] p = {{10,7},{0,4},{5,7}};
        System.out.println(largestTriangleAreaResult(p));
    }
}
