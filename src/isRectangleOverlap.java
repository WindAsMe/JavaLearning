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
        double dis = Math.sqrt(point1[1] - point2[1]) + Math.sqrt(point1[0] + point2[0]);
        double parallex = Math.sqrt(point1[0] - rec1[0] + point2[0] - rec2[0]) + Math.sqrt(point1[1] - rec1[1] + point2[1] - rec2[1]);
        return dis > parallex;
    }

    public static void main(String[] args) {

    }
}
