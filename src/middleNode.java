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
        if (head == null)
            return null;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        len /= 2;
        node = head;
        while (len > 0) {
            len--;
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(middleNodeResult(null).val);
    }
}
