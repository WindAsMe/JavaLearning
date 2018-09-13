/**
 * Author     : WindAsMe
 * File       : findCircleNum.java
 * Time       : Create on 18-9-13
 * Location   : ../Home/JavaForLeeCode2/findCircleNum.java
 * Function   : LeetCode No.547
 */
public class findCircleNum {

    private static int findCircleNumResult(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return 0;
        int count = 0;
        boolean[] flag = new boolean[M.length];
        flag[0] = true;
        for (int i = 0; i < M.length; i++) {
            if (!flag[i]) {
                dfs(M, i, flag);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int i, boolean[] flag) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !flag[j]) {
                flag[j] = true;
                dfs(M, j, flag);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(findCircleNumResult(nums));
    }
}
