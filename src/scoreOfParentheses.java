import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : scoreOfParentheses.java
 * Time       : Create on 18-8-11
 * Location   : ../Home/JavaForLeeCode2/scoreOfParentheses.java
 * Function   : LeetCode No.856
 */
public class scoreOfParentheses {

    private static int scoreOfParenthesesResult(String S) {
        if (S.length() == 0)
            return 0;
        if (S.length() == 2)
            return 1;
        S = S.replace("()", "1");
        int[] helper = new int[S.length()];
        // '(' is -1
        // ')' is -2
        // '1' is 1
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                helper[i] = -1;
            else if (S.charAt(i) == ')')
                helper[i] = -2;
            else
                helper[i] = 1;
        }
        System.out.println(Arrays.toString(helper));
        int len = helper.length;
        while (len != 1) {
            for (int i = 0; i < len; i++) {
                if (helper[i] > 0 && i + 1 < len && helper[i + 1] > 0) {
                    helper[i] = helper[i] + helper[i + 1];
                    System.arraycopy(helper, i + 1 + 1, helper, i + 1, len - 1 - (i + 1));
                    len--;
                }
                if (helper[i] > 0 && i - 1 >= 0 && helper[i - 1] == -1 && i + 1 < len  && helper[i + 1] == -2) {
                    helper[i - 1] = helper[i] * 2;
                    System.arraycopy(helper, i + 1, helper, i, len - 1 - i);
                    for (int j = i; j < len - 1; j++)
                        helper[i] = helper[i + 1];
                    len -= 2;
                }
            }
        }
        return helper[0];
    }

    public static void main(String[] args) {
        System.out.println("ans: " + scoreOfParenthesesResult("(()(()))"));
    }
}
