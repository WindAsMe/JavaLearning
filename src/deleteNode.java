/**
 * Author     : WindAsMe
 * File       : deleteNode.java
 * Time       : Create on 18-9-5
 * Location   : ../Home/JavaForLeeCode2/deleteNode.java
 * Function   : LeetCode No.237
 */
public class deleteNode {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static void deleteNodeResult(ListNode node) {
        node.val= node.next.val;
        node.next= node.next.next;
    }

    public static void main(String[] args) {
    }
}
