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
        TreeLinkNode lastNode = root;
        while (lastNode != null) {
            TreeLinkNode cur = new TreeLinkNode(0);
            TreeLinkNode curHead = cur;
            while (lastNode != null) {
                if (lastNode.left != null) {
                    cur.next = lastNode.left;
                    cur = cur.next;
                }
                if (lastNode.right != null) {
                    cur.next = lastNode.right;
                    cur = cur.next;
                }
                lastNode = lastNode.next;
            }
            lastNode = curHead.next;
        }
    }
}
