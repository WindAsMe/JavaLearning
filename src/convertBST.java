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

    private int sum = 0;
    private TreeNode convertBSTResult(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        node.val += sum;
        sum = node.val;
        dfs(node.left);
    }

    private static void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            print(node.left);
            print(node.right);
        }
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(12);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(13);
    }
}
