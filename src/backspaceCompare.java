import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : backspaceCompare.java
 * Time       : Create on 18-8-24
 * Location   : ../Home/JavaForLeeCode2/backspaceCompare.java
 * Function   : LeetCode No.844
 */
public class backspaceCompare {

    private static boolean backspaceCompareResult(String S, String T) {
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (char c : sChar) {
            if (c != '#')
                s.push(c);
            else if (!s.empty())
                s.pop();
        }

        for (char c : tChar) {
            if (c != '#')
                t.push(c);
            else if (!t.empty())
                t.pop();
        }
        return s.equals(t);
    }


    public static void main(String[] args) {
        String S = "ab##";
        String T = "c#d#";
        System.out.println(backspaceCompareResult(S, T));
    }
}
