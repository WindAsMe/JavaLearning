import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : uniqueMorseRepresentations.java
 * Time       : Create on 18-10-5
 * Location   : ../Home/JavaForLeeCode2/uniqueMorseRepresentations.java
 * Function   : LeetCode No.804
 */
public class uniqueMorseRepresentations {

    private static int uniqueMorseRepresentationsResult(String[] words) {
        String[] salt = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words)
            encode(word, set, salt);
        return set.size();
    }

    private static void encode(String s, Set<String> set, String[] salt) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars)
            builder.append(salt[c - 97]);
        // System.out.println(builder.toString());
        set.add(builder.toString());
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentationsResult(words));
    }
}
