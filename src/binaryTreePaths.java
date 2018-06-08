import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : binaryTreePaths.java
 * Time       : Create on 18-6-8
 * Location   : ../Home/JavaForLeeCode2/binaryTreePaths.java
 * Function   : LeeCode No.257
 */
public class binaryTreePaths {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<String> binaryTreePathsResult(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        } else {
            StringBuilder start = new StringBuilder();
            start.append(root.val).append("->");
            DFS(root, start, list);
            return list;
        }
    }

    private static void DFS(TreeNode node, StringBuilder temp, List<String> list){
        if (node.left != null && node.right != null) {
            StringBuilder leftTemp = new StringBuilder(temp);
            StringBuilder rightTemp = new StringBuilder(temp);
            leftTemp.append(node.left.val).append("->");
            rightTemp.append(node.right.val).append("->");
            DFS(node.left, leftTemp, list);
            DFS(node.right, rightTemp, list);
        }

        if (node.left != null && node.right == null) {
            StringBuilder leftTemp = new StringBuilder(temp);
            leftTemp.append(node.left.val).append("->");
            DFS(node.left, leftTemp, list);
        }


        if (node.left == null && node.right != null) {
            StringBuilder rightTemp = new StringBuilder(temp);
            rightTemp.append(node.right.val).append("->");
            DFS(node.right, rightTemp, list);
        }

        if (node.left == null && node.right == null) {
            temp.delete(temp.length() - 2, temp.length());
            list.add(temp.toString());
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(3);
//        root.left.left.right= new TreeNode(-1);
//
//        root.right = new TreeNode(-3);
//        root.right.left = new TreeNode(8);
//        root.right.right = new TreeNode(-2);
        List<String> list = binaryTreePathsResult(root);
        for (String aList : list) {
            System.out.println(aList);
        }
    }
}
