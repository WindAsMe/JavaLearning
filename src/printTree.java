import java.util.List;

/**
 * Author     : WindAsMe
 * File       : printTree.java
 * Time       : Create on 18-8-28
 * Location   : ../Home/JavaForLeeCode2/printTree.java
 * Function   :
 */
public class printTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<List<String>> printTreeResult(TreeNode root) {
        int[] depth = {0};
        dfs(root, depth, 1);
        System.out.println(depth[0]);
        return null;
    }

    private static void dfs(TreeNode root, int[] depth, int cur) {
        if (root == null)
            depth[0] = depth[0] > cur ? depth[0] : cur;
        else {
            dfs(root.left, depth, cur + 1);
            dfs(root.right, depth, cur + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        System.out.println(printTreeResult(root));
    }
}
