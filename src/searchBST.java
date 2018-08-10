/**
 * Author     : WindAsMe
 * File       : searchBST.java
 * Time       : Create on 18-8-10
 * Location   : ../Home/JavaForLeeCode2/searchBST.java
 * Function   :
 */
public class searchBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode searchBSTResult(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val > root.val)
            return searchBSTResult(root.right, val);
        if (val < root.val)
            return searchBSTResult(root.left, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node  = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(7);
    }

}
