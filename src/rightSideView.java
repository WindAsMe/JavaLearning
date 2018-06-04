import java.util.*;

/**
 * Author     : WindAsMe
 * File       : rightSideView.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/rightSideView.java
 * Function   : LeeCode No.199
 */
public class rightSideView {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<Integer> rightSideViewResult(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        } else if (root.left == null && root.right == null){
            list.add(root.val);
            return list;
        } else {
            List<List<Integer>> lists = new ArrayList<>();
            // Stack to push and pop
            // The full one pop to empty one
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            queue1.add(root);

            layerIteration(lists, queue1, queue2);

            List<Integer> result = new ArrayList<>();
            for (List<Integer> list1 : lists) {
                result.add(list1.get(list1.size() - 1));
            }

            return result;
        }
    }

    private static void layerIteration(List<List<Integer>> lists, Queue<TreeNode> queue1, Queue<TreeNode> queue2){
        List<Integer> list = new ArrayList<>();
        if (queue1.isEmpty() && queue2.isEmpty()){
            return;
        } else if (queue1.isEmpty()){
            while (!queue2.isEmpty()){
                TreeNode temp = queue2.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue1.add(temp.left);
                }
                if (temp.right != null){
                    queue1.add(temp.right);
                }
            }
        } else {
            while (!queue1.isEmpty()){
                TreeNode temp = queue1.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue2.add(temp.left);
                }
                if (temp.right != null){
                    queue2.add(temp.right);
                }
            }
        }
        lists.add(list);
        layerIteration(lists, queue1, queue2);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(4);
        List<Integer> list = rightSideViewResult(root);
        for (int i = 0 ; i < list.size() ; i ++ ){
            System.out.print(list.get(i) + " ");
        }
    }
}
