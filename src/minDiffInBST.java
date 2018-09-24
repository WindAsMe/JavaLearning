/**
 * Author     : WindAsMe
 * File       : minDiffInBST.java
 * Time       : Create on 18-9-24
 * Location   : ../Home/JavaForLeeCode2/minDiffInBST.java
 * Function   : LeetCode No.783
 */
public class minDiffInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int minDiffInBSTResult(TreeNode root) {
        return dfs1(root, root);
    }

    private static int dfs1(TreeNode node, TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        if (node != null) {
            dfs2(node, min, root);
            dfs1(node.left, root);
            dfs1(node.right, root);
        }
        return min[0];
    }

    private static void dfs2(TreeNode node, int[] min, TreeNode root) {
        if (root != null && root != node) {
            min[0] = Math.min(min[0], Math.abs(node.val - root.val));
            dfs2(node, min, root.left);
            dfs2(node, min, root.right);
        } else if (root != null) {
            dfs2(node, min, root.left);
            dfs2(node, min, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(6);
        System.out.println(minDiffInBSTResult(node));
    }
}
