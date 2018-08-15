/**
 * Author     : WindAsMe
 * File       : isSubsequence.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/isSubsequence.java
 * Function   : LeetCode No.392
 */
public class isSubsequence {

    private boolean isSubsequenceResult(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] next = new int[s.length()];
        init(sChar, next);
    }


    private static void init(char[] s, int[] next) {
        int k = -1;
        next[0]  = -1;

    }
}
