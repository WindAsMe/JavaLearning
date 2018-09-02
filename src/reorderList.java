/**
 * Author     : WindAsMe
 * File       : reorderList.java
 * Time       : Create on 18-9-2
 * Location   : ../Home/JavaForLeeCode2/reorderList.java
 * Function   : LeetCode No.143
 */
public class reorderList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static void reorderListResult(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode node = head;
            while (node.next.next != null)
                node = node.next;
            node.next.next = head.next;
            head.next = node.next;
            node.next = null;
            reorderListResult(head.next.next);
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        reorderListResult(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
