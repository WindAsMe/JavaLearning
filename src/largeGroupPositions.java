import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : largeGroupPositions.java
 * Time       : Create on 18-8-24
 * Location   : ../Home/JavaForLeeCode2/largeGroupPositions.java
 * Function   : LeetCode No.830
 */
public class largeGroupPositions {

    private static List<List<Integer>> largeGroupPositionsResult(String S) {
        List<List> lists = new ArrayList<>();
        char[] s = S.toCharArray();
        // 26 word,
        // ans[*][0]: start
        // ans[*][1]: end
        int[][] ans = new int[26][2];
        ans[s[0] - 'a'][0] = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] != s[i - 1]) {
                ans[s[i - 1] - 'a'][1] = i - 1;
                ans[s[i] - 'a'][0] = i;
            }
        }

        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
        return null;
    }

    public static void main(String[] args) {
        String s = "abbxxxxzzy";
        largeGroupPositionsResult(s);
    }
}
