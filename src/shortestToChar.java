import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : shortestToChar.java
 * Time       : Create on 18-8-9
 * Location   : ../Home/JavaForLeeCode2/shortestToChar.java
 * Function   : LeetCode No.821
 */
public class shortestToChar {

    private static int[] shortestToCharResult(String S, char C) {
        char[] helper = S.toCharArray();
        int[] ans = new int[helper.length];
        for (int i = 0; i < helper.length; i++) {
            int left = i;
            int right = i;
            while (true) {
                if (left >= 0) {
                    if (helper[left] == C) {
                        ans[i] = i - left;
                        break;
                    } else
                        left--;
                }
                if (right < helper.length) {
                    if (helper[right] == C) {
                        ans[i] = right - i;
                        break;
                    } else
                        right++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToCharResult("loveleetcode", 'e')));
    }
}
