import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : edit.java
 * Time       : Create on 18-8-13
 * Location   : ../Home/JavaForLeeCode2/edit.java
 * Function   : dp: Edit Distance
 */
public class edit {

    // Find the shortest distance in convert
    // for which one to be the substring for the another is valid
    private static int editResult(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // create the 2-d matrix to save the current difference value
        int[][] ans = new int[c1.length + 1][c2.length + 1];
        // init the array like:
        // [0, 1, 2, 3, 4]
        // [1, 0, 0, 0, 0]
        // [2, 0, 0, 0, 0]
        // [3, 0, 0, 0, 0]
        // [4, 0, 0, 0, 0]
        // [5, 0, 0, 0, 0]

        for (int i = 1; i <= c1.length; i++)
            ans[i][0] = i;
        for (int i = 1; i <= c2.length; i++)
            ans[0][i] = i;

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                // if for i, j  c1[i - 1] == c2[j - 1]:
                // ans[i][j] = min(left, head, left - head)
                if (c1[i - 1] == c2[j - 1])
                    ans[i][j] = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);

                // if c1[i - 1] != c2[j - 1]
                // ans[i][j] = min(left, head, left - head) + 1
                else
                    ans[i][j] = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]) + 1;
            }
        }

        for (int[] a : ans)
            System.out.println(Arrays.toString(a));

        return ans[c1.length][c2.length];
    }

    public static void main(String[] args) {
        System.out.println(editResult("ferry", "fary"));
    }
}
