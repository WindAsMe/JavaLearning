/**
 * Author     : WindAsMe
 * File       : countSubstrings.java
 * Time       : Create on 18-8-8
 * Location   : ../Home/JavaForLeeCode2/countSubstrings.java
 * Function   : LeetCode No.647
 */
public class countSubstrings {

    private static int countSubstringsResult(String s) {
        int ans = s.length();
        if (s.length() < 2)
            return ans;
        // the stride
        for (int i = 2; i <= s.length(); i++) {
            // j: start   j + i: end
            for (int j = 0; j + i < s.length(); j++) {
                if (valid(s.substring(j, j + i)))
                    ans++;
            }
        }
        return ans;
    }

    private static boolean valid(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            if (c[start] != c[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstringsResult("aaa"));
    }
}
