import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : kpm.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/kpm.java
 * Function   : Kpm SubString
 */
public class kpm {

    // compute the next
    // next save the common-pre-end length
    // like the string "ababaca"
    // -1: no existence, 0: length == 1, 1: length == 2 ...
    // a -> -1; ab -> -1; aba -> 0; abab -> 1;
    // ababa -> 2; ababac -> -1; ababaca -> 0;
    // the next is {-1, -1, 0, 1, 2, -1, 0}
    private static void init(char[] str, int[] next) {
        next[0] = -1;
        int k = -1;
        for (int q = 1; q < next.length; q++) {
            while (k > -1 && str[k + 1] != str[q])
                k = next[k];
            if (str[k + 1] == str[q])
                k = k + 1;
            next[q] = k;
        }
        System.out.println(Arrays.toString(next));
    }

    // s: expectation; t: substring
    private static boolean kpmResult(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] next = new int[s.length()];
        init(sChar, next);
        int k = -1;
        // This proceeding is like the init()
        for (char aSChar : sChar) {
            while (k > -1 && tChar[k + 1] != aSChar)
                k = next[k];
            if (tChar[k + 1] == aSChar)
                k = k + 1;
            if (k == tChar.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(kpmResult("ababaca", "aba"));
    }
}
