import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : shortestCompletingWord.java
 * Time       : Create on 18-9-20
 * Location   : ../Home/JavaForLeeCode2/shortestCompletingWord.java
 * Function   : LeetCode No.784
 */
public class shortestCompletingWord {

    private static String shortestCompletingWordResult(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String temp = licensePlate.toLowerCase();
        char[] cs = temp.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : cs) {
            if (c >= 'a' && c <= 'z')
                builder.append(c);
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < builder.length(); i++) {
            if (map1.get(builder.charAt(i)) == null)
                map1.put(builder.charAt(i), 1);
            else
                map1.put(builder.charAt(i), map1.get(builder.charAt(i)) + 1);
        }
        for (String s : words) {
            Map<Character, Integer> map2 = new HashMap<>();
            char[] c = s.toCharArray();
            for (char aC : c)
                map2.merge(aC, 1, (a, b) -> a + b);
            if (contain(map1, map2))
                return s;
        }
        return null;
    }

    private static boolean contain(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        System.out.println(m2.toString());
        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (!(m2.get(entry.getKey()) != null && m2.get(entry.getKey()) >= entry.getValue()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWordResult(licensePlate, words));
    }
}
