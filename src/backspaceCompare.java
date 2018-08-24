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
        push(s, sChar);
        push(t, tChar);
        return s.equals(t);
    }

    private static void push(Stack<Character> s, char[] chars) {
        for (char c : chars) {
            if (c != '#')
                s.push(c);
            else if (!s.empty())
                s.pop();
        }
    }


    public static void main(String[] args) {
        String S = "ab#####c";
        String T = "ad####c";
        System.out.println(backspaceCompareResult(S, T));
    }
}
