/**
 * Author     : WindAsMe
 * File       : invertTree.java
 * Time       : Create on 18-6-6
 * Location   : ../Home/JavaForLeeCode2/invertTree.java
 * Function   : LeeCode NO.226
 */
public class invertTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode invertTreeResult(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            reverse(root);
            return root;
        }
    }

    private static void reverse(TreeNode root) {
        if (root.left != null || root.right != null) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            if (root.left != null)
                reverse(root.left);
            if (root.right != null)
                reverse(root.right);
        }
    }


}
