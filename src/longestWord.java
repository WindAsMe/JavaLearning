import java.util.Arrays;
import java.util.Comparator;

/**
 * Author     : WindAsMe
 * File       : longestWord.java
 * Time       : Create on 18-8-13
 * Location   : ../Home/JavaForLeeCode2/longestWord.java
 * Function   : LeetCode No.720
 */
public class longestWord {

    private static String longestWordResult(String[] words) {
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        String ans = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                String cur = words[i];
                for (int j = i + 1; j < words.length; j++) {
                    String temp = words[j];
                    if (cur.length() + 1 == temp.length() && cur.equals(temp.substring(0, temp.length() - 1)))
                        cur = words[j];
                }
                if (cur.length() > ans.length())
                    ans = cur;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"b", "ba", "banan", "ban", "bana", "a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWordResult(words));
    }
}
