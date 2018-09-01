import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : postorderTraversal.java
 * Time       : Create on 18-9-1
 * Location   : ../Home/JavaForLeeCode2/postorderTraversal.java
 * Function   :
 */
public class postorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static List<Integer> postorderTraversalResult(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
        return list;
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            dfs(node.right, list);
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(postorderTraversalResult(node).toString());
    }
}
