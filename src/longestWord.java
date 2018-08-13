import java.util.Arrays;

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
        String cur = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) {
                break;
            } else {
                cur = words[i];
                for (int j = i + 1; j < words.length; j++) {
                    String temp = words[j];
                    if (temp.length() > cur.length() && cur.length() + 1 == temp.length() && cur.equals(temp.substring(0, temp.length())))
                        cur = words[j];
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        longestWordResult(words);
    }
}
