import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : checkInclusion.java
 * Time       : Create on 18-8-9
 * Location   : ../Home/JavaForLeeCode2/checkInclusion.java
 * Function   : LeetCode No.567
 */
public class checkInclusion {

    private static boolean checkInclusionResult(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        char[] helper = s1.toCharArray();
        char[] s = s2.toCharArray();
        for (char c : helper)
            map.merge(c, 1, (a, b) -> a + b);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (map.get(s[i]) != null && origin(s, i, i + helper.length).equals(map))
                return true;
        }
        return false;
    }

    private static Map<Character, Integer> origin(char[] c, int start, int end) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            if (map.get(c[i]) == null)
                map.put(c[i], 1);
            else
                map.put(c[i], map.get(c[i]) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusionResult("ab", "aasudhCCabef"));
    }
}
