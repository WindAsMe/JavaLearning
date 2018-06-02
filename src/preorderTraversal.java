
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : preorderTraversal.java
 * Time       : Create on 18-6-1
 * Location   : ../Home/JavaForLeeCode2/preorderTraversal.java
 * Function   : LeeCode No.
 */
public class preorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // pre-order Iteration
    private static List<Integer> preorderTraversalResult(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        } else {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
            return list;
        }
    }

    private static void preOrder(TreeNode root, List<Integer> list){
        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        List<Integer> list = preorderTraversalResult(root);
        for (Integer a : list){
            System.out.print(a + " ");
        }
    }
}
