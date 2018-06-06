/**
 * Author     : WindAsMe
 * File       : reverseList.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/reverseList.java
 * Function   : LeeCode No.
 */
public class reverseList {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode reverseListResult(ListNode head) {
        if (head == null) {
            return null;
        } else {
            int len = 0;
            ListNode temp = head;
            while (temp.next != null) {
                len ++;
                temp = temp.next;
            }

            ListNode node = new ListNode(head.val);
            addList(len, head, node);
            return node;
        }
    }

    private static void addList(int index, ListNode head, ListNode node) {
        System.out.println("Index: " + index );
        for (int i = 0 ; i < index ; i ++ ) {
            ListNode temp = head;
            for (int j = index - i ; j >= 1 ; j -- ) {
                temp = temp.next;
                System.out.println("i:" + i + "   " + "j:" + j + "    value:" + temp.val);
            }
            node.next = new ListNode(temp.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        ListNode result = reverseListResult(node);
        while (result != null) {
            System.out.println(result.val + " ");
        }

    }
}