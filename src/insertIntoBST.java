/**
 * Author     : WindAsMe
 * File       : insertIntoBST.java
 * Time       : Create on 18-8-30
 * Location   : ../Home/JavaForLeeCode2/insertIntoBST.java
 * Function   : LeetCode No.701
 */
public class insertIntoBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode insertIntoBSTResult(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode node = root;
        while (true) {
            if (val > node.val && node.right != null)
                node = node.right;
            else if (val < node.val && node.left != null)
                node = node.left;
            else
                break;
        }
        if (val > node.val)
            node.right = new TreeNode(val);
        else
            node.left = new TreeNode(val);
        return root;
    }

    private static void dfs(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(7);
        dfs(insertIntoBSTResult(node, 5));
    }
}
