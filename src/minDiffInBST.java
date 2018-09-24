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
        int[] min = {Integer.MAX_VALUE};
        dfs1(root, root, min);
        return min[0];
    }

    private static void dfs1(TreeNode node, TreeNode root, int[] min) {
        if (node != null) {
            dfs2(node, min, root);
            dfs1(node.left, root, min);
            dfs1(node.right, root, min);
        }
    }

    private static void dfs2(TreeNode node, int[] min, TreeNode root) {
        if (root != null && root != node) {
            System.out.println("node: " + node.val + " min[0]: " + min[0] + " deduct: " + Math.abs(node.val - root.val));
            min[0] = Math.min(min[0], Math.abs(node.val - root.val));
            dfs2(node, min, root.left);
            dfs2(node, min, root.right);
        } else if (root != null) {
            dfs2(node, min, root.left);
            dfs2(node, min, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(27);
        node.right = new TreeNode(34);
        node.right.right = new TreeNode(58);
        node.right.right.left = new TreeNode(50);

        System.out.println(minDiffInBSTResult(node));
    }
}
