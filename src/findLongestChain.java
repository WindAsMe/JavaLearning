/**
 * Author     : WindAsMe
 * File       : findLongestChain.java
 * Time       : Create on 18-8-27
 * Location   : ../Home/JavaForLeeCode2/findLongestChain.java
 * Function   : LeetCode No.646
 */
public class findLongestChain {

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
        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        System.out.println(findLongestChainResult(pairs));
    }
}
