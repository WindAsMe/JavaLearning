/**
 * Author     : WindAsMe
 * File       : rotateRight.java
 * Time       : Create on 18-9-11
 * Location   : ../Home/JavaForLeeCode2/rotateRight.java
 * Function   : LeetCode No.61
 */
public class rotateRight {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode rotateRightResult(ListNode head, int k) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] helper = new int[len];
        node = head;
        for (int i = 0; i < len; i++) {
            helper[(i + k) % len] = node.val;
            node = node.next;
        }
        node = head;
        int i = 0;
        while (node != null) {
            node.val = helper[i];
            i++;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode ans = rotateRightResult(head, 3);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
