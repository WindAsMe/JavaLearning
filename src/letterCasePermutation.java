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
        create(list, S, new StringBuilder(), S.length(), 0);
        return list;
    }

    private static void create(List<String> list, String s, StringBuilder builder, int len, int index) {
        if (index + 1 > len) {
            list.add(builder.toString());
            return;
        }
        for (int i = index + 1; i < len; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                StringBuilder temp = new StringBuilder(builder);
                temp.append(c - 32);
                create(list, s, temp, len, i);
            } else if (c >= 'A' && c <= 'Z') {
                StringBuilder temp = new StringBuilder(builder);
                temp.append(c + 32);
                create(list, s, temp, len, i);
            } else
                builder.append(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutationResult("a1b2"));
    }
}
