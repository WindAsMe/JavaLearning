import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : kpmMatch.java
 * Time       : Create on 18-6-15
 * Location   : ../Home/JavaForLeeCode2/kpmMatch.java
 * Function   : Learning String matched algorithm
 */
public class kpmMatch {

    private static int kpmMatchResult(String text, String matched) {
        if (text.length() < matched.length()) {
            return -1;
        }
        int[] next = new int[matched.length()];
        setNext(matched, next);
        int j = 0;
        for (int i = 0 ; i < text.length() ; i ++ ) {
            System.out.println("i:" + i + "  j:" + j);
            if (text.charAt(i) == matched.charAt(j)) {
                j ++;
                if (j == matched.length() - 1) {
                    return i - j + 1;
                }
            } else {
                if (j != 0) {
                    j = next[j] + 1;
                }
            }
        }
        return -1;
    }


    // Set array next
    private static void setNext(String matched, int[] next) {
        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < matched.length() - 1) {
            // matched.charAt(j) is prefix
            // matched.charAt(k) is postfix
            if (k == -1 || matched.charAt(j) == matched.charAt(k)) {
                ++ j;
                ++ k;
                next[j] = k;
            }
            else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
    }

    public static void main(String[] args) {
        System.out.println(kpmMatchResult("abcaabcdabcqqababc", "abcdabcqqab"));
    }
}
