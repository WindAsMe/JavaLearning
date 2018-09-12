/**
 * Author     : WindAsMe
 * File       : convertBST.java
 * Time       : Create on 18-9-12
 * Location   : ../Home/JavaForLeeCode2/convertBST.java
 * Function   : LeetCode No.538
 */
public class convertBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode convertBSTResult(TreeNode root) {

    }

    private static void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.right);
            dfs(node.left);
        }
    }
}
