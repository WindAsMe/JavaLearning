import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findDuplicateSubtrees.java
 * Time       : Create on 18-9-16
 * Location   : ../Home/JavaForLeeCode2/findDuplicateSubtrees.java
 * Function   :
 */
public class findDuplicateSubtrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<TreeNode> findDuplicateSubtreesResult(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null)
            return list;
        dfs1(root.left, root, list);
        dfs1(root.right, root, list);
        return list;
    }

    private static void dfs1(TreeNode node, TreeNode root, List<TreeNode> list) {
        if (node != null && root != null) {
            dfs2(node, root.left, list);
            dfs2(node, root.right, list);
            dfs1(node.left, root, list);
            dfs1(node.right, root, list);
        }
    }

    private static void dfs2(TreeNode node1, TreeNode node2, List<TreeNode> list) {
        if (node1.val == node2.val && treeEqual(node1, node2) && !list.contains(node1) && !list.contains(node2))
            list.add(node1);
        else if (node2.left != null)
            dfs2(node1, node2.left, list);
        else if (node2.right != null)
            dfs2(node1, node2.right, list);
    }



    private static boolean treeEqual(TreeNode node1, TreeNode node2) {
        return node1 != null && node2 != null && node1.val == node2.val && treeEqual(node1.left, node2.left) && treeEqual(node1.right, node2.right);
    }


    private static void dfs(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> list = findDuplicateSubtreesResult(root);
        for (TreeNode node : list)
            dfs(node);
    }
}
