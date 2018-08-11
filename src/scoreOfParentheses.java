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
        S = S.replace("()", "1");
        int[] helper = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                helper[i] = -1;
            else if (S.charAt(i) == ')')
                helper[i] = -2;
            else
                helper[i] = 1;
        }
        System.out.println(Arrays.toString(helper));


//        for (int i = 0; i < S.length(); i++) {
//            if (i - 1 >= 0 && i + 1 <= S.length() - 1 && S.charAt(i) == '1' && )
//        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParenthesesResult("(()(()))"));
    }
}
