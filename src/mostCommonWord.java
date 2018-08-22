import java.util.*;

/**
 * Author     : WindAsMe
 * File       : mostCommonWord.java
 * Time       : Create on 18-8-22
 * Location   : ../Home/JavaForLeeCode2/mostCommonWord.java
 * Function   : LeetCode No.819
 */
public class mostCommonWord {

    private static String mostCommonWordResult(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        char[] helper = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : helper) {
            if (c >= 'a' && c <= 'z')
                sb.append(c);
            else if (c >= 'A' && c <= 'Z')
                sb.append((char) (c + 32));
            else {
                if (sb.length() != 0) {
                    String s = sb.toString();
                    map.merge(s, 1, (a, b) -> a + b);
                    sb.delete(0, sb.length());
                }
            }
        }
        System.out.println("map: " + map.toString());
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println("list: " + list.toString());
        for (Map.Entry<String, Integer> entry : list) {
            boolean contain = false;
            for (String s : banned) {
                if (s.equals(entry.getKey())) {
                    contain = true;
                    break;
                }
            }
            if (!contain)
                return entry.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] banned = {"hit"};
        System.out.println(mostCommonWordResult("Bob hit a ball, the hit BALL flew far after it was hit.", banned));
    }
}
