import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : letterCasePermutation.java
 * Time       : Create on 18-10-5
 * Location   : ../Home/JavaForLeeCode2/letterCasePermutation.java
 * Function   : LeetCode No.784
 */
public class letterCasePermutation {

    private static List<String> letterCasePermutationResult(String S) {
        List<String> list = new ArrayList<>();
        dfs(0, new StringBuilder(S), list);
        return list;
    }

    private static void dfs(int x, StringBuilder s, List<String> list) {
        if (x == s.length()) {
            list.add(s.toString());
            return;
        }
        char tmp = s.charAt(x);
        if (Character.isLetter(tmp)) {
            s.setCharAt(x, Character.toLowerCase(tmp));
            dfs(x + 1, s, list);
            s.setCharAt(x, Character.toUpperCase(tmp));
            dfs(x + 1, s, list);
        }
        else
            dfs(x + 1, s, list);
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutationResult("a1b2"));
    }
}
