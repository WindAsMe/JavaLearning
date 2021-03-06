/**
 * Author     : WindAsMe
 * File       : scoreOfParentheses.java
 * Time       : Create on 18-8-11
 * Location   : ../Home/JavaForLeeCode2/scoreOfParentheses.java
 * Function   : LeetCode No.856
 */
public class scoreOfParentheses {

    private static int scoreOfParentheses1(String S) {
        if (S.equals("()"))
            return 1;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    if (i == S.length() - 1)
                        return 2 * scoreOfParenthesesResult(S.substring(1, S.length() - 1));
                    else
                        return scoreOfParenthesesResult(S.substring(0, i + 1)) + scoreOfParenthesesResult(S.substring(i + 1));
                }
            }
        }
        return 0;
    }

    private static int scoreOfParenthesesResult(String S) {
        if (S.length() == 0)
            return 0;
        if (S.length() == 2)
            return 1;
        S = S.replace("()", "1");
        System.out.println(S);
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
        // System.out.println(Arrays.toString(helper));
        int len = helper.length;
        while (len != 1) {
            System.out.print("convert: ");
            for (int a = 0; a < len; a ++)
                System.out.print(helper[a] + " ");
            System.out.println();
            for (int i = 0; i < len; i++) {
                if (helper[i] > 0 && i + 1 < len && helper[i + 1] > 0) {
                    helper[i] = helper[i] + helper[i + 1];
                    System.arraycopy(helper, i + 1 + 1, helper, i + 1, len - 1 - (i + 1));
                    len--;
                }
                if (helper[i] > 0 && i - 1 >= 0 && helper[i - 1] == -1 && i + 1 < len  && helper[i + 1] == -2) {
                    helper[i - 1] = helper[i] * 2;
                    len -= 2;
                    // System.out.println("after: " + Arrays.toString(helper) + " i: " + i + " len: " + len);
                    System.arraycopy(helper, i + 2, helper, i, len - i);
                    // System.out.println("combine: " + Arrays.toString(helper));
                }
            }
        }
        return helper[0];
    }

    public static void main(String[] args) {
        System.out.println("ans: " + scoreOfParenthesesResult("()(()(())())"));
    }
}
