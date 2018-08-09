import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : connect.java
 * Time       : Create on 18-8-9
 * Location   : ../Home/JavaForLeeCode2/connect.java
 * Function   : LeetCode No.117
 */
public class connect {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    private static void connectResult(TreeLinkNode root) {
        Stack<TreeLinkNode> left = new Stack<>();
        Stack<TreeLinkNode> right = new Stack<>();
        left.push(root);
        while (!left.empty() && !right.empty()) {
            if (!left.empty()) {
                TreeLinkNode node = left.pop();
                right.push(node.right);
                right.push(node.left);
                while (!left.empty()) {
                    TreeLinkNode temp = left.pop();
                    temp.next = node;
                    node = temp;
                }
                continue;
            }
            if (!right.empty()) {
                TreeLinkNode node = right.pop();
                left.push(node.right);
                left.push(node.left);
                while (!right.empty()) {
                    TreeLinkNode temp = left.pop();
                    temp.next = node;
                    node = temp;
                }
            }
        }
    }
}
