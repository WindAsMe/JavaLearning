/**
 * Author     : WindAsMe
 * File       : numDistinct.java
 * Time       : Create on 18-9-2
 * Location   : ../Home/JavaForLeeCode2/numDistinct.java
 * Function   : LeetCode No.115
 */
public class numDistinct {

    // s is longer
    private static int numDistinctResult(String s, String t) {
        if (s.length() < t.length())
            return 0;
        char[] sHelper = s.toCharArray();
        char[] tHelper = t.toCharArray();
        int[][] ans = new int[tHelper.length + 1][sHelper.length + 1];
        for (int i = 0; i < sHelper.length + 1; i++)
            ans[0][i] = 1;
        for (int i = 1; i < tHelper.length + 1; i++) {
            for (int j = 1; j < sHelper.length + 1;  j++)
                // If matched:
                // add the ans[i - 1][j - 1]
                ans[i][j] = ans[i][j - 1] + (sHelper[j - 1] == tHelper[i - 1] ? ans[i - 1][j - 1] : 0);
        }
        return ans[tHelper.length][sHelper.length];
    }

    public static void main(String[] args) {
        System.out.println(numDistinctResult("rabbbit", "rabbit"));
    }
}
