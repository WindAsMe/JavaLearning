/**
 * Author     : WindAsMe
 * File       : repeatedStringMatch.java
 * Time       : Create on 18-8-29
 * Location   : ../Home/JavaForLeeCode2/repeatedStringMatch.java
 * Function   : LeetCode No.686
 */
public class repeatedStringMatch {

    private static int repeatedStringMatchResult(String A, String B) {
        int mul = 1;
        int lenB = B.length();
        StringBuilder a = new StringBuilder(A);
        while (a.length() <= B.length()) {
            if (a.length() == B.length() && a.toString().equals(B))
                return mul;
            mul++;
            a.append(A);
        }
        for (int i = 0; i + lenB < a.length(); i++) {
            // System.out.println(a.substring(i, i + lenB));
            if (a.substring(i, i + lenB).equals(B))
                return mul;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatchResult("abcd", "cdabcdab"));
    }
}
