/**
 * Author     : WindAsMe
 * File       : isSubsequence.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/isSubsequence.java
 * Function   : LeetCode No.392
 */
public class isSubsequence {

    private static boolean isSubsequenceResult(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tChar[i] == sChar[index]) {
                index++;
                if (index == s.length() - 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequenceResult("abc", "ahbgdc"));
    }
}
