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
        TreeNode(int x) {
            val = x;
        }
    }


    private static int res = 0;

    private static int findTiltResult(TreeNode root) {
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode node) {
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right= dfs(node.right);
        res += Math.abs(left - right);
        return left + right + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(findTiltResult(root));
    }
}
