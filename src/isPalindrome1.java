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
        System.out.println(Arrays.toString(helper));
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeResult("A man, a plan, a canal: Panama"));
    }
}
