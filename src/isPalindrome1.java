import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : isPalindrome1.java
 * Time       : Create on 18-9-1
 * Location   : ../Home/JavaForLeeCode2/isPalindrome1.java
 * Function   : LeetCode No.125
 */
public class isPalindrome1 {

    private static boolean isPalindromeResult(String s) {
        String S = s.toLowerCase().trim();
        char[] helper = S.toCharArray();
        int start = 0;
        int end = helper.length - 1;
        while (start <= end) {
            if (!((helper[start] >= 97 && helper[start] <= 122) || (helper[start] >= 48 && helper[start] <= 57))) {
                start++;
                continue;
            }
            if (!((helper[end] >= 97 && helper[end] <= 122) || (helper[end] >= 48 && helper[end] <= 57))) {
                end--;
                continue;
            }
            if (helper[start] != helper[end])
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeResult("A man, a plan, a canal: Panama"));
    }
}
