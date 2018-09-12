/**
 * Author     : WindAsMe
 * File       : diameterOfBinaryTree.java
 * Time       : Create on 18-9-12
 * Location   : ../Home/JavaForLeeCode2/diameterOfBinaryTree.java
 * Function   :
 */
public class diameterOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int diameterOfBinaryTreeResult(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(Math.max(diameterOfBinaryTreeResult(root.left), diameterOfBinaryTreeResult(root.right)), nodeDiameter(root));
    }

    private static int nodeDiameter(TreeNode node) {
        if (node == null)
            return 0;
        int sum = 0;
        if (node.left != null)
            sum += height(node.left);
        if (node.right != null)
            sum += height(node.right);
        return sum;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {

    }
}
