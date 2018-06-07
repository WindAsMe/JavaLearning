import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author     : WindAsMe
 * File       : kthSmallest.java
 * Time       : Create on 18-6-7
 * Location   : ../Home/JavaForLeeCode2/kthSmallest.java
 * Function   : LeeCode No.230
 */
public class kthSmallest {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int kthSmallestResult(TreeNode root, int k) {
        Deque<TreeNode> leftDeque = new ArrayDeque<>();
        Deque<TreeNode> rightDeque = new ArrayDeque<>();
        addToDeque(leftDeque, root.left);
        if (k <= leftDeque.size()) {
            int temp = leftDeque.size();
            while (temp - k > 0) {
                leftDeque.pop();
                k ++;
            }
            System.out.println("k:" + k );
            return leftDeque.pop().val;
        } else if (k == leftDeque.size() + 1) {
            return root.val;
        } else {
            k -= (1 + leftDeque.size());
            addToDeque(rightDeque, root.right);
            int temp = rightDeque.size();
            while (temp - k  > 0) {
                rightDeque.pop();
                k ++;
            }
            return rightDeque.pop().val;
        }

    }

    // Recursion in Tree Pre-order
    private static void addToDeque(Deque<TreeNode> deque, TreeNode node) {
        if (node == null) {
            return;
        } else {
            addToDeque(deque, node.left);
            deque.push(node);
            addToDeque(deque, node.right);
        }
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(5);
        node.left.left.left.left = new TreeNode(2);

        node.left.right = new TreeNode(8);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(9);


        node.right = new TreeNode(12);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(13);
        node.right.right.right = new TreeNode(14);

        System.out.println(kthSmallestResult(node, 10));
    }

}

