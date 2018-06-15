import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : findContentChildren.java
 * Time       : Create on 18-6-15
 * Location   : ../Home/JavaForLeeCode2/findContentChildren.java
 * Function   : LeeCode No.455
 */
public class findContentChildren {

    private static int findContentChildrenResult(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        } else {
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0;
            // In array s, only iteration for once
            int j = 0;
            for (int aG : g) {
                for (; j < s.length; j++) {
                    if (aG <= s[j]) {
                        // Set cookie to zero
                        s[j] = 0;
                        count++;
                        break;
                    }
                    // s.length <= g.length
                    if (j == s.length - 1) {
                        return count;
                    }
                }
            }
            // Out of circulation
            // Cookie is redundant or child is more
            return g.length;
        }
    }

    public static void main(String[] args) {
        int[] g = {1,1,1,1,1};
        int[] s = {1,2,3};
        System.out.println(findContentChildrenResult(g, s));
    }
}
