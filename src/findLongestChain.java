import java.util.Arrays;
import java.util.Comparator;

/**
 * Author     : WindAsMe
 * File       : findLongestChain.java
 * Time       : Create on 18-8-27
 * Location   : ../Home/JavaForLeeCode2/findLongestChain.java
 * Function   : LeetCode No.646
 */
public class findLongestChain {

    // DP
    private static int findLongestChainResult1(int[][] pairs) {
        int[] ans = new int[pairs.length];
        int max = 1;
        ans[0] = 1;
        // Must be sorted by the pair[0]
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    ans[i] = ans[i] > ans[j] + 1 ? ans[i] : ans[j] + 1;
            }
            if (ans[i] == 0)
                ans[i] = 1;
            max = max > ans[i] ? max : ans[i];
        }
        System.out.println(Arrays.toString(ans));
        return max;
    }

    // DFS: TL
    private static int findLongestChainResult(int[][] pairs) {
        int[] max = {1};
        for (int[] pair : pairs)
            dfs(pairs, max, pair[1], 1);
        return max[0];
    }

    private static void dfs(int[][] pairs, int[] max, int end, int len) {
        for (int[] pair : pairs) {
            if (end < pair[0]) {
                max[0] = max[0] > len + 1 ? max[0] : len + 1;
                dfs(pairs, max, pair[1], len + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{3,4},{2,3},{1,2}};
        int[][] pairs = {
                {1,2},
                {2,3},
                {3,4},
                {1,3},
                {4,5},
                {6,7},
                {1,9},
                {7,8},
                {5,8},
                {9,11}
        };
        System.out.println(findLongestChainResult1(a));
    }
}
