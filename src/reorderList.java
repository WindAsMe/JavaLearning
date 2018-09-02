/**
 * Author     : WindAsMe
 * File       : reorderList.java
 * Time       : Create on 18-9-2
 * Location   : ../Home/JavaForLeeCode2/reorderList.java
 * Function   :
 */
public class reorderList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static void reorderListResult(ListNode head) {
        ListNode node = head;
        while (node.next != null)
            node = node.next;
        node = head.next;
        head.next = node;
        reorderListResult(node.next);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        reorderListResult(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
