import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : numJewelsInStones.java
 * Time       : Create on 18-9-21
 * Location   : ../Home/JavaForLeeCode2/numJewelsInStones.java
 * Function   : LeetCode No.771
 */
public class numJewelsInStones {

    private static int numJewelsInStonesResult(String J, String S) {
        if (J.length() == 0 || S.length() == 0)
            return 0;
        int count = 0;
        char[] jHelper = J.toCharArray();
        char[] sHelper = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char j : jHelper)
            set.add(j);
        for (char s : sHelper) {
            if (set.contains(s))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStonesResult("aA", "aAAbbbb"));
    }
}
