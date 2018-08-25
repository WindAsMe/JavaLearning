/**
 * Author     : WindAsMe
 * File       : buddyStrings.java
 * Time       : Create on 18-8-25
 * Location   : ../Home/JavaForLeeCode2/buddyStrings.java
 * Function   : LeetCode No.859
 */
public class buddyStrings {

    private static boolean buddyStringsResult(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            char[] a = A.toCharArray();
            int[] ans = new int[26];
            for (char c : a)
                ans[c - 'a']++;
            for (int i : ans) {
                if (i > 1)
                    return true;
            }
            return false;
        }
        int count = 0;
        int len = A.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i])
                count++;
        }
        return count == 2;
    }

    public static void main(String[] args) {
        System.out.println(buddyStringsResult("aaaaaaabc", "aaaaaaacb"));
    }
}
