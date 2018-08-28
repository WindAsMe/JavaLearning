import java.util.ArrayList;
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
        int column = 0;
        dfs(root, depth, 0);
        for (int i = 1; i < depth[0]; i++)
            column = column * 2 + 1;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < depth[0]; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < column * 2 + 1; j++)
                list.add("");
            lists.add(list);
        }

        draw(root, 0, column, lists, column * 2 + 1);
        return lists;
    }

    private static void dfs(TreeNode root, int[] depth, int cur) {
        if (root == null)
            depth[0] = depth[0] > cur ? depth[0] : cur;
        else {
            dfs(root.left, depth, cur + 1);
            dfs(root.right, depth, cur + 1);
        }
    }

    private static void draw(TreeNode node, int layer, int column, List<List<String>> lists, int total) {
        if (node != null) {
            lists.get(layer).remove(column);
            lists.get(layer).add(column, String.valueOf(node.val));
            draw(node.left, layer + 1, column / 2, lists, total);
            draw(node.right, layer + 1, (total - column) / 2 + 1 + column, lists, total);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        List<List<String>> lists = printTreeResult(root);
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
