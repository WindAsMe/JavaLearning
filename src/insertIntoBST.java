/**
 * Author     : WindAsMe
 * File       : insertIntoBST.java
 * Time       : Create on 18-8-12
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
        if (root.val < val) {
            TreeNode node = root;
            TreeNode son = root.right;
            while (son != null && son.val < val) {
                node = son;
                son = son.right;
            }
            TreeNode temp = new TreeNode(val);
            temp.right = son;
            node.right = temp;
        } else if (root.val > val) {
            TreeNode node = root;
            TreeNode son = root.left;
            while (son != null && son.val > val) {
                node = son;
                son = son.left;
            }
            TreeNode temp = new TreeNode(val);
            temp.left = son;
            node.left = temp;
        }
        return root;
    }


    private static void dfs(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ", ");
            dfs(node.left);
            dfs(node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);

        dfs(insertIntoBSTResult(root, 2));
    }
}
