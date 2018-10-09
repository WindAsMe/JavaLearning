import javax.swing.text.LayoutQueue;

/**
 * Author     : WindAsMe
 * File       : middleNode.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/JavaForLeeCode2/middleNode.java
 * Function   : LeetCode No.876
 */
public class middleNode {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode middleNodeResult(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len % 2 == 0)
            len = len / 2 + 1;
        else
            len /= 2;
        System.out.println(len);
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next  = new ListNode(4);
        head.next.next.next.next  = new ListNode(5);
        head.next.next.next.next.next  = new ListNode(6);
        head.next.next.next.next.next.next  = new ListNode(7);
        middleNodeResult(head);
    }
}
