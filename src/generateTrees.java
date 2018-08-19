import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : generateTrees.java
 * Time       : Create on 18-8-19
 * Location   : ../Home/JavaForLeeCode2/generateTrees.java
 * Function   : LeetCode No.95
 */
public class generateTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<TreeNode> generateTreesResult(int n) {
        if (n <= 0) return new ArrayList<>();
        return create(1, n);
    }

    private static ArrayList<TreeNode> create(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int rootVal = start; rootVal <= end; rootVal++)
            for (TreeNode leftSubTreeRoot : create(start, rootVal - 1))
                for (TreeNode rightSubTreeRoot : create(rootVal + 1, end)) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftSubTreeRoot;
                    root.right = rightSubTreeRoot;
                    result.add(root);
                }
        return result;
    }

    private static void dfs(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTreesResult(4);
        for (TreeNode node : list) {
            dfs(node);
            System.out.println();
        }

    }
}
