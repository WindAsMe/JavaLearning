/**
 * Author     : WindAsMe
 * File       : isSubsequence.java
 * Time       : Create on 18-8-14
 * Location   : ../Home/JavaForLeeCode2/isSubsequence.java
 * Function   : LeetCode No.392
 */
public class isSubsequence {

    private static boolean isSubsequenceResult(String s, String t) {
        if (s.length() < 1)
            return true;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tChar[i] == sChar[index]) {
                System.out.println("i: " + i + "index: " + index);
                index++;
                if (index == s.length())
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequenceResult("acb", "ahbgdc"));
    }
}
