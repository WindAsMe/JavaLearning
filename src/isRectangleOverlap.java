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
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

    public static void main(String[] args) {
        int[] rec1 = {11,12,13,13};
        int[] rec2 = {17,1,17,19};
        System.out.println(isRectangleOverlapResult(rec1, rec2));
    }
}
