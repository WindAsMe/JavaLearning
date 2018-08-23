import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : isRectangleOverlap.java
 * Time       : Create on 18-8-23
 * Location   : ../Home/JavaForLeeCode2/isRectangleOverlap.java
 * Function   : LeetCode No.836
 */
public class isRectangleOverlap {

    private static boolean isRectangleOverlapResult(int[] rec1, int[] rec2) {
        // (rec[0], rec[1]): (x1, y1)
        // (rec[2], rec[3]): (x2, y2)
        int[] point1 = {(rec1[0] + rec1[2]) / 2, (rec1[1] + rec1[3] ) / 2};
        int[] point2 = {(rec2[0] + rec2[2]) / 2, (rec2[1] + rec2[3] ) / 2};
        System.out.println("point1: " + Arrays.toString(point1));
        System.out.println("point2: " + Arrays.toString(point2));
        double dis = Math.pow(point1[1] - point2[1], 2) + Math.pow(point1[0] - point2[0], 2);
        double parallax = Math.pow(point1[0] - rec1[0] + point2[0] - rec2[0], 2) + Math.pow(point1[1] - rec1[1] + point2[1] - rec2[1], 2);
        System.out.println("dis: " + dis);
        System.out.println("parallax: " + parallax);
        return dis < parallax;
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {2,2,3,3};
        System.out.println(isRectangleOverlapResult(rec1, rec2));
    }
}
