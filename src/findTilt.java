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

    private static void dfs(TreeNode node, int[] ans) {
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.left == null) {
            ans[0] += node.right.val;
            dfs(node.right, ans);
        } else if (node.right == null) {
            ans[0] += node.left.val;
            dfs(node.left, ans);
        } else {
            ans[0] += Math.abs(node.left.val - node.right.val);
            dfs(node.left, ans);
            dfs(node.right, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(findTiltResult(root));
    }
}
