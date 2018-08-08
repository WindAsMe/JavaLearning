/**
 * Author     : WindAsMe
 * File       : findTilt.java
 * Time       : Create on 18-8-8
 * Location   : ../Home/JavaForLeeCode2/findTilt.java
 * Function   : LeetCode No.563
 */
public class findTilt {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int findTiltResult(TreeNode root) {
        int[] ans = {0};
        dfs(root, ans);
        return ans[0];
    }

    private static void add(TreeNode node, int[] sum) {
        if (node != null) {
            sum[0] += node.val;
            add(node.left, sum);
            add(node.right, sum);
        }

    }

    private static void dfs(TreeNode node, int[] ans) {
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.left == null) {
            int[] sum = {0};
            add(node.right, sum);
            ans[0] += sum[0];
            dfs(node.right, ans);
        } else if (node.right == null) {
            int[] sum = {0};
            add(node.left, sum);
            ans[0] += sum[0];
            dfs(node.left, ans);
        } else {
            int[] sum1 = {0};
            int[] sum2 = {0};
            add(node.left, sum1);
            add(node.right, sum2);
            ans[0] += Math.abs(sum1[0] - sum2[0]);
            dfs(node.left, ans);
            dfs(node.right, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(findTiltResult(root));
    }
}
