import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : numberOfLines.java
 * Time       : Create on 18-10-6
 * Location   : ../Home/JavaForLeeCode2/numberOfLines.java
 * Function   : LeetCode No.806
 */
public class numberOfLines {

    private static int[] numberOfLinesResult(int[] widths, String S) {
        int row = 1;
        int len = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (len + widths[c - 'a'] <= 100)
                len += widths[c - 'a'];
            else {
                row++;
                len = widths[c - 'a'];
            }
        }
        return new int[]{row, len};
    }

    public static void main(String[] args) {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        System.out.println(Arrays.toString(numberOfLinesResult(widths, "abcdefghijklmnopqrstuvwxyz")));

    }
}
