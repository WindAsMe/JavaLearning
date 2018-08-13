import java.util.*;

/**
 * Author     : WindAsMe
 * File       : longestWord.java
 * Time       : Create on 18-8-13
 * Location   : ../Home/JavaForLeeCode2/longestWord.java
 * Function   : LeetCode No.720
 */
public class longestWord {

    private static String longestWordResult(String[] words) {
        int length = 0;
        String word = "";
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        for (String word1 : words) {
            if (word1.length() > length || (word1.length() == length && word1.compareTo(word) < 0)) {
                int len = word1.length();
                while (len > 0 && set.contains(word1.substring(0, len)))
                    len--;
                if (len == 0) {
                    length = word1.length();
                    word = word1;
                }
            }
        }
        return word;
    }

    public static void main(String[] args) {
        String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(longestWordResult(words));
    }
}
